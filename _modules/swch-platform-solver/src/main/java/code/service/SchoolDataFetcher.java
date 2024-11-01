package code.service;

import code.configuration.Authorization;
import code.configuration.Constants;
import code.configuration.Endpoints;
import code.generated_model.chapter.Chapters;
import code.generated_model.school_data.SchoolClass;
import code.generated_model.school_data.course.Course;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@AllArgsConstructor
public class SchoolDataFetcher {

  private ObjectMapper objectMapper;
  private WebClient client;

  @SneakyThrows
  public List<SchoolClass> getClasses() {
    String s = Files.readString(Path
      .of(Constants.jsonPath + "classes.json"));
    return objectMapper.readValue(s, new TypeReference<List<SchoolClass>>() {});
  }

  @SneakyThrows
  public List<Course> getCourses() {
    var retrieve = client.get()
      .uri(Endpoints.getCourses)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();
    List<Course> block = retrieve.bodyToMono(
      new ParameterizedTypeReference<List<Course>>() {}).block();
    log("getCourses response:%s".formatted(block));
    return block;
  }

  @SneakyThrows
  public Chapters getAllChapters() {
    var retrieve = client.get()
      .uri(Endpoints.getChaptersPath + "?no_page=true")
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();

    String str = retrieve.bodyToMono(String.class).block();
    str = "{\"chapters\":" + str + "}";
    log("getChapters response:%s".formatted(str));
    return objectMapper.readValue(str, Chapters.class);
  }

  private void log(String s) {
    log.info(s.replaceAll("\\r|\\n", ""));
  }
}