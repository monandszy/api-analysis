package code;

import code.service.NaverService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(classes = ApplicationRunner.class)
class SomeNaverTest {

  NaverService naverService;

  @Test
  @SneakyThrows
  void extract() {
    naverService.extract();
  }
}