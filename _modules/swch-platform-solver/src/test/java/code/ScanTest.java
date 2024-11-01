package code;

import code.configuration.Constants;
import code.generated_model.chapter.Chapter;
import code.generated_model.chapter.Chapters;
import code.generated_model.worksheet.Worksheet;
import code.service.RobotService;
import code.service.TaskFetcher;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(classes = ApplicationRunner.class)
@Slf4j
class ScanTest {

  private RobotService robotService;
  private TaskFetcher taskFetcher;

  @BeforeAll
  public static void setupHeadlessMode() {
    System.setProperty("java.awt.headless", "false");
  }

  @Test
  @SneakyThrows
  @DisplayName("Create a file with all the links")
  void createLinkFile() {
    Integer courseId = 31;
    Integer subjectId = 2;
    Chapters chapters = taskFetcher.getChapters(courseId, false);
    String resourceName = "Physics";
    Path resourcePath = Path.of(Constants.resourcePath + resourceName + ".txt");
    try (BufferedWriter writer = Files.newBufferedWriter(resourcePath,
      StandardOpenOption.APPEND
    )) {
      chapters.getChapters()
        .forEach(chapter -> {
            // write chapter header
            try {
              writer.write("[%s] ".formatted(chapter.getId()) + chapter.getName() + "\n");
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
            // list worksheets
            taskFetcher.getWorksheets(List.of(chapter.getId()), courseId).getWorksheets().forEach(a -> {
              try {
                writer.write("https://platforma.szkolawchmurze.org/courses/details/" +
                  "32/1/3/10/work-sheet/%s/%s \n".formatted(a.getId(), subjectId));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });
            TestUtils.sleep();
          }
        );
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("Scans the page using the GoFullPage Chrome extension")
   /*
    requires correct positioning - I used Autohotkey Window Spy
   */
  void scanWithBrowser() {
    Integer courseId = 33;
    Integer subjectId = 5;
    Chapters chapters = taskFetcher.getChapters(courseId, false);
    List<Integer> chapterIds = chapters.getChapters().stream().map(Chapter::getId).toList();
    List<Worksheet> worksheets = taskFetcher.getWorksheets(chapterIds, courseId).getWorksheets()
      .stream()
      .toList();
    robotService.initialize();
    for (Worksheet worksheet : worksheets) {
      TestUtils.sleep();
      scanWorksheet(worksheet, courseId, subjectId);
    }

  }

  private void scanWorksheet(Worksheet worksheet, Integer courseId, Integer subjectId) {
    // test click
    robotService.gotoxy(1640, 20);
    robotService.click();
    // enter link
    robotService.gotoxy(1187, 65);
    robotService.click();
    robotService.type("https://platforma.szkolawchmurze.org/courses/details/" +
      "%s/1/3/10/work-sheet/%s/%s \n".formatted(
        courseId, worksheet.getId(), subjectId));
    robotService.enter();
    robotService.sleep(10000);
    // click extension
    robotService.gotoxy(1640, 65);
    robotService.click();
    // scan delay
    robotService.gotoxy(1880, 230);
    robotService.delayUntilPixelEquals(new Color(228, 228, 228));
    // download
    robotService.gotoxy(1705, 140);
    robotService.click();
    // rename
    robotService.sleep(1000);
    robotService.backspace();
    robotService.type("C[%s]W[%s] ".formatted(worksheet.getChapter().getName(), worksheet.getName())
      .replaceAll("[?]|[:]|[\\\\]|[/]|[\"]|[']", ""));
    //save
    robotService.sleep(1000);
    robotService.combinePress(KeyEvent.VK_CONTROL, KeyEvent.VK_ENTER);
    // close page (return to swch)
    robotService.sleep(1000);
    robotService.combinePress(KeyEvent.VK_CONTROL, KeyEvent.VK_W);
    robotService.sleep(1000);
  }
}