package code.service;

import code.configuration.Authorization;
import code.configuration.Endpoints;
import code.generated_model.chapter.Chapters;
import code.generated_model.multichoice_task.attempt.AttemptsData;
import code.generated_model.multichoice_task.checked.CheckedTasks;
import code.generated_model.multichoice_task.data.Tasks;
import code.generated_model.worksheet.Worksheets;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class TaskFetcher {

  private WebClient client;
  private ObjectMapper objectMapper;

  @SneakyThrows
  public Map<String, Object> getToken() {
    MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
    bodyValues.add("email", Authorization.email);
    bodyValues.add("password", Authorization.password);

    var retrieve = client.post()
      .uri(Endpoints.login)
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromFormData(bodyValues))
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log("getToken response:%s".formatted(str));
    return objectMapper.readValue(
      str, new TypeReference<Map<String, Object>>() {
      });
  }

  @SneakyThrows
  public Chapters getChapters(Integer courseId, Boolean isExtended) {
    var retrieve = client.get()
      .uri(Endpoints.getChapters, courseId, isExtended)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();

    String str = retrieve.bodyToMono(String.class).block();
    str = "{\"chapters\":" + str + "}"; // on if pagination=false
    log("getChapters for courseId:[%s] response:%s".formatted(courseId, str));
    return objectMapper.readValue(str, Chapters.class);
  }

  @SneakyThrows
  public Worksheets getWorksheets(List<Integer> chapterIds, Integer courseId) {
    String ids = chapterIds.stream()
      .map(Object::toString).reduce((l, r) -> l + "," + r).orElse("");
    var retrieve = client.get()
      .uri(Endpoints.getWorksheets.replace("{course_id}", courseId.toString()).replace("{chapter_ids}", ids))
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();

    String str = retrieve.bodyToMono(String.class).block();
    log("getWorksheets for chapterIds:[%s] response:%s".formatted(ids, str));
    return objectMapper.readValue(str, Worksheets.class);
  }

  @SneakyThrows
  public Tasks getTasks(Integer worksheetId) {
    var retrieve = client.get()
      .uri(Endpoints.getTasks, worksheetId)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();

    String str = retrieve.bodyToMono(String.class).block();
    log("getTasks for worksheetId:[%s] response:%s".formatted(worksheetId, str));
    return objectMapper.readValue(str, Tasks.class);
  }

  @SneakyThrows
  public Integer getWorksheetStudentCheck(Integer worksheetId) {
    String bodyValue = "{\"worksheet_id\": %s}".formatted(worksheetId);
    var retrieve = client.post()
      .uri(Endpoints.postWorksheetStudentCheck)
      .contentType(MediaType.APPLICATION_JSON)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .bodyValue(bodyValue)
      .retrieve();
    log("getWorksheetStudentCheck for worksheetId:[%s] bodyValue:%s".formatted(worksheetId, bodyValue));

    String str = retrieve.bodyToMono(String.class).block();
    log("getWorksheetStudentCheck for worksheetId:[%s] response:%s".formatted(worksheetId, str));
    return Integer.valueOf(objectMapper.readValue(
      str, new TypeReference<Map<String, String>>() {
      }).get("id"));
  }

  @SneakyThrows
  public CheckedTasks getCheckedTasks(Integer worksheetId) {
    var retrieve = client.get()
      .uri(Endpoints.getCheckedTasks, worksheetId)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log("getCheckedTasks for worksheetId:[%s] response:%s".formatted(worksheetId, str));
    return objectMapper.readValue(str, CheckedTasks.class);
  }

  private void log(String s) {
    log.info(s.replaceAll("\\r|\\n", ""));
  }

  @SneakyThrows
  public AttemptsData getAttempts(Integer worksheetId) {
    var retrieve = client.get()
      .uri(Endpoints.checkAttempts, worksheetId)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log("getAttempts for worksheetId:[%s] response:%s".formatted(worksheetId, str));
    return objectMapper.readValue(str, AttemptsData.class);
  }
}