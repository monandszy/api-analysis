package code;

import code.configuration.Authorization;
import code.service.TaskFetcher;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(classes = ApplicationRunner.class)
class ModelGenerationTest {

  private TaskFetcher taskFetcher;
  private WebClient webClient;

  @Test
  @SneakyThrows
  void login() {
    Map<String, Object> userValueMap = taskFetcher.getToken();
    userValueMap.forEach((k, v) -> System.out.println(k + " " + v));
    if (!Authorization.TOKEN.equals(userValueMap.get("token")))
      throw new RuntimeException("Token Update Needed");
  }
}