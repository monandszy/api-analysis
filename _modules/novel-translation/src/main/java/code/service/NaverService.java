package code.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class NaverService {

  @SneakyThrows
  public void extract() {
    String html = Files.readString(Path.of("_naver/_scraped/myNaver.log"));
    Document doc = Jsoup.parse(html);
    Element contentDiv = doc.getElementById("content");

    Elements paragraphs = contentDiv.select("p");

    StringBuilder cleanText = new StringBuilder();
    for (Element paragraph : paragraphs) {
      String text = paragraph.text().trim();
      if (!text.isEmpty()) {
        if (text.equals("게임 속 바바리안으로 살아남기 (연재)")) {
          break;
        }
        cleanText.append(text).append("\n");
      }
    }
    Files.writeString(Path.of("_naver/%s.txt".formatted(cleanText.toString().lines().findFirst().orElseThrow())), cleanText);
  }
}