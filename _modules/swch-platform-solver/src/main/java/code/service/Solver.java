package code.service;

import code.configuration.Authorization;
import code.configuration.Endpoints;
import code.generated_model.multichoice_task.checked.AnswerPayload;
import code.generated_model.multichoice_task.checked.CheckedTasks;
import code.generated_model.multichoice_task.checked.TaskData;
import code.generated_model.multichoice_task.data.DisplayedAnswer;
import code.generated_model.multichoice_task.data.Task;
import code.generated_model.multichoice_task.payload.TaskPayload;
import code.generated_model.multichoice_task.payload.WorksheetPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@AllArgsConstructor
public class Solver {

  private WebClient client;
  private ObjectMapper objectMapper;

  @SneakyThrows
  public CheckedTasks postCheckedTasks(List<TaskPayload> taskPayloads) {
    String strPayload = objectMapper.writeValueAsString(taskPayloads);
    log("postCheckedTasks bodyValue:%s".formatted(strPayload));
    var retrieve = client.post()
      .uri(Endpoints.postCheckedTasks)
      .contentType(MediaType.APPLICATION_JSON)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .bodyValue(strPayload)
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log("postCheckedTasks response:%s".formatted(str));
    return objectMapper.readValue(str, CheckedTasks.class);
  }

  public List<TaskPayload> prepareTaskPayload(List<TaskData> taskData, Integer checkNumber) {
    return taskData.stream().map(e -> TaskPayload.builder()
      .taskId(e.getTaskId())
      .worksheetStudentCheck(checkNumber)
      .taskData(e)
      .build()
    ).toList();
  }

  @SneakyThrows
  public WorksheetPayload prepareWorksheetPayload(
    Integer worksheetId,
    Integer subjectId
  ) {
    return WorksheetPayload.builder()
      .percentageScore(0)
      .singleCheckCompletion(false)
      .checkWorksheet(true)
      .subjectId(subjectId)
      .schoolClassGrade("4")
      .worksheetId(worksheetId)
      .oraTaskData(List.of())
      .build();
  }

  public List<AnswerPayload> extractAnswers(Task e) {
    switch (e.getType()) {
      case "MULTI_OPTION" -> {
        return e.getAnswers().stream()
          .filter(DisplayedAnswer::getIsCorrect)
          .map(a -> AnswerPayload.builder()
            .aid(a.getId())
            .build()
          ).toList();
      }
      case "DRAG_DROP" -> {
        return e.getAnswers().stream()
          .filter(a -> !a.getDragDropSet().isEmpty())
          .map(a -> AnswerPayload.builder()
            .id(Integer.valueOf(a.getDragDropId()))
            .zone(a.getDragDropSet().contains(",") ?
              a.getDragDropSet().split(",")[0] :
              a.getDragDropSet())
            .build())
          .toList();
      }
      case "ORA" -> {
        return null;
      }
      case "STRING_ANSWER" -> {
        return e.getAnswers().stream()
          .map(a -> AnswerPayload.builder()
            .aid(a.getId())
            .value(a.getValue().contains(",") ?
              a.getValue().split(",")[0] :
              a.getValue())
            .build())
          .toList();
      }
    }
    return List.of();
  }

  public List<TaskData> prepareTaskData(List<Task> tasks, boolean extractAnswers) {
    return tasks.stream()
      .filter(e -> !e.getType().equals("ORA"))
      .map(e -> TaskData.builder()
        .taskId(e.getId())
        .taskType(e.getType())
        .answers(extractAnswers ? extractAnswers(e) : List.of())
        .build()).toList();
  }

  @SneakyThrows
  public void postAnswer(Integer worksheetId, WorksheetPayload payload) {
    String strPayload = objectMapper.writeValueAsString(payload);
    log("postAnswer for worksheet:[%s] bodyValue:%s".formatted(worksheetId, strPayload));
    var retrieve = client.post()
      .uri(Endpoints.postWorksheetAnswer)
      .contentType(MediaType.APPLICATION_JSON)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .bodyValue(strPayload)
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log("postAnswer for worksheet:[%s] response:%s".formatted(worksheetId, str));
  }

  private void log(String s) {
    log.info(s.replaceAll("\\r|\\n", ""));
  }

}