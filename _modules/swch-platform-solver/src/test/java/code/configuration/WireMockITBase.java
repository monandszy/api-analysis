package code.configuration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import code.ApplicationRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Getter
@ActiveProfiles("test")
@SpringBootTest(classes = ApplicationRunner.class)
public abstract class WireMockITBase {

  protected static WireMockServer wireMockServer;
  @Autowired
  protected ObjectMapper objectMapper;

  @BeforeAll
  static void beforeAll() {
    FileSource fs = new ClasspathFileSource("src/test/resources/wiremock/");
    wireMockServer = new WireMockServer(
      wireMockConfig()
        .port(9999)
        .fileSource(fs));
    wireMockServer.start();
  }

  @AfterAll
  static void afterAll() {
    wireMockServer.stop();
  }

  @AfterEach
  void afterEach() {
    wireMockServer.resetAll();
  }

}