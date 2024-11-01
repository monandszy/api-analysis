package code;

import code.generated_model.chapter.Chapter;
import code.generated_model.multichoice_task.attempt.AttemptsData;
import code.generated_model.multichoice_task.checked.AnswerPayload;
import code.generated_model.multichoice_task.checked.CheckedTask;
import code.generated_model.multichoice_task.checked.CheckedTasks;
import code.generated_model.multichoice_task.checked.TaskData;
import code.generated_model.multichoice_task.data.Task;
import code.generated_model.multichoice_task.payload.TaskPayload;
import code.generated_model.multichoice_task.payload.WorksheetPayload;
import code.generated_model.worksheet.Worksheet;
import code.service.CheckService;
import code.service.SingleSolverService;
import code.service.Solver;
import code.service.TaskFetcher;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(classes = ApplicationRunner.class)
@Slf4j
class SolveTest {

  private Solver solver;
  private TaskFetcher taskFetcher;
  private CheckService checkService;

  @BeforeAll
  public static void setupHeadlessMode() {
    System.setProperty("java.awt.headless", "false");
  }

  @Test
    // https://platforma.szkolawchmurze.org/courses/details/117/1/3/10/work-sheet/2136/39
  void solveOne() {
    int worksheetId = 2136;
    int subjectId = 39;
    solveWorksheet(worksheetId, subjectId);
  }

  /*
  To get Course/Subject Data - open a worksheet
  https://platforma.szkolawchmurze.org/courses/details/{courseId}/1/3/10/work-sheet/{worksheetId}/{subjectId}
  if something goes wrong during the operation:
     - filter the worksheet stream to get rid of selected worksheets
     - dropWhile - skip all until the condition is matched
  example language urls:
  // https://platforma.szkolawchmurze.org/courses/details/112/1/3/10/work-sheet/1858/37 // deu 3Lo
  // https://platforma.szkolawchmurze.org/courses/details/112/1/3/10/work-sheet/2134/37 // deu 4Lo
  // https://platforma.szkolawchmurze.org/courses/details/99/1/3/10/work-sheet/2139/34 // ang 4Lo

  To open the language worksheets in the browser find the broken endpoint in the network tab and redirect it
  while adding &show_languages=true header flag, using an extension.
  */
  @Test
  void solveAll() {
    Integer courseId = 33;
    Integer subjectId = 5;
    boolean isExtended = false; // Advanced Level
    List<Integer> chapterIds = taskFetcher.getChapters(courseId, isExtended)
      .getChapters().stream().map(Chapter::getId).toList();
    List<Worksheet> worksheets = taskFetcher.getWorksheets(chapterIds, courseId).getWorksheets()
      .stream()
      .toList();
    int size = worksheets.size();
    for (int i = 0; i < size; i++) {
      Integer id = worksheets.get(i).getId();
      log.info("Solving Worksheet: {} of {}, Id: {}", i, size, id);
      solveWorksheet(id, subjectId);
      TestUtils.sleep();
    }
  }

  void solveWorksheet(Integer worksheetId, Integer subjectId) {
    AttemptsData attempts = taskFetcher.getAttempts(worksheetId);
    List<Task> toSave;
    if (Arrays.isNullOrEmpty(attempts.getResults())) {
      log.info("SolveFirstTime WorksheetId: {}", worksheetId);
      toSave = solveJustInForSecondAttempt(worksheetId, subjectId);
    } else if (
      // perfect solve already present and can be fetched
      attempts.getResults()[0].getPercentageScore().equals(100)
        && attempts.getResults()[0].getAttempts().equals(2)
    ) {
      log.info("PerfectFirstTimeSolve WorksheetId: {}", worksheetId);
      toSave = taskFetcher.getTasks(worksheetId).getTasks();
    } else {
      if (!attempts.getResults()[0].getPercentageScore().equals(100)) {
        log.info("SolveAgain WorksheetId: {}", worksheetId);
      }
      log.info("CorrectingXTimeSolve WorksheetId: {}", worksheetId);
      toSave = solveJustInForSecondAttempt(worksheetId, subjectId);
      correctByChecked(toSave, worksheetId, subjectId);
    }
//      saveService.saveWorksheet(toSave);
  }

  @SneakyThrows
   /*
   This might be suspicious since it leaves checked tasks behind (normally deleted on postAnswer),
   but it is necessary to fix frontend rendering
    */
  private void correctByChecked(List<Task> solvedTasks, Integer worksheetId, Integer subjectId) {
    TestUtils.sleep();
    List<TaskData> solvedTaskData = solver.prepareTaskData(solvedTasks, true);
    WorksheetPayload payload = solver.prepareWorksheetPayload(worksheetId, subjectId);
    solver.postAnswer(worksheetId, payload.withTaskData(solvedTaskData));

    Integer checkNumber = checkService.getCheckNumber(worksheetId);
    List<TaskPayload> solvedTaskPayloads = solver.prepareTaskPayload(solvedTaskData, checkNumber);
    solver.postCheckedTasks(solvedTaskPayloads);
  }

  @SneakyThrows
   /*
    works by sending an empty answer as a 1st attempt,
    but it's treated as a full 2 attempt solve (idk why)
    (sometimes) the site still renders in 1st attempt mode(not solved),
    although the answers in getTask are present
    those answers are then sent in the 2nd attempt
    */
  private List<Task> solveJustInForSecondAttempt(Integer worksheetId, Integer subjectId) {
    List<Task> emptyTasks = taskFetcher.getTasks(worksheetId).getTasks();
    TestUtils.sleep();
    List<TaskData> emptyTaskData = solver.prepareTaskData(emptyTasks, false);
    WorksheetPayload payload = solver.prepareWorksheetPayload(worksheetId, subjectId);
    solver.postAnswer(worksheetId, payload.withTaskData(emptyTaskData));
    Integer checkNumber = checkService.getCheckNumber(worksheetId);

    List<TaskPayload> emptyTaskPayloads = solver.prepareTaskPayload(emptyTaskData, checkNumber);
    solver.postCheckedTasks(emptyTaskPayloads);
    TestUtils.sleep();

    List<Task> solvedTasks = taskFetcher.getTasks(worksheetId).getTasks();
    List<TaskData> solvedTaskData = solver.prepareTaskData(solvedTasks, true);
    solver.postAnswer(worksheetId, payload.withTaskData(solvedTaskData));

    return solvedTasks;
  }

  private SingleSolverService singleSolver;

  @Test
  @SneakyThrows
    // only works if answer data already present in getTask, use in case the solveOne doesn't work
    /*
     * sends checked tasks one by one
     * */
  void solveBySingle() {
    int worksheetId = 2136;
    int subjectId = 39;

    Integer checkNumber = checkService.getCheckNumber(worksheetId);
    List<Integer> checkedIds;
    CheckedTasks checkedTasks = singleSolver.getCheckedTasks(worksheetId);
    if (Objects.nonNull(checkedTasks) && Objects.nonNull(checkedTasks.getId()) && Objects.nonNull(checkedTasks.getCheckedTasks())) {
      checkedIds = checkedTasks.getCheckedTasks().stream().map(CheckedTask::getTaskId).toList();
    } else {
      checkedIds = List.of();
    }

    List<Task> solvedTasks = taskFetcher.getTasks(worksheetId).getTasks();

    solvedTasks.stream()
      .map(task -> {
        List<AnswerPayload> answerPayloads = solver.extractAnswers(task);
        return singleSolver.postCheckedTask(task, answerPayloads,
          checkedIds.contains(task.getId()) ? 1 : checkNumber // put breakpoint here
        );
      })
      .forEach(e -> TestUtils.sleep());

  }

}