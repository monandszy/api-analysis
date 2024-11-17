package code.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
@Slf4j
public class SomeController {

  private ObjectMapper objectMapper;

  @SneakyThrows
  @PostMapping("/log")
  ResponseEntity<Void> log(
    @RequestBody String message
  ) {
    Files.writeString(Path.of("_modules/novel-translation/_naver/_scraped/naver.log"), message + "\n",
      StandardOpenOption.APPEND);
    return ResponseEntity.ok().build();
  }

  @SneakyThrows
  @PostMapping("/send")
  ResponseEntity<Void> send(
    @RequestBody String json
  ) {
    Data data = objectMapper.readValue(json, Data.class);
    Path path = Path.of("_modules/novel-translation/_naver/_scraped/myNaver.log");
    Files.writeString(path, data.message() + "\n");
    return ResponseEntity.ok().build();
  }

  record Data(String message) {

  }
}