package code.service;

import code.configuration.Authorization;
import code.configuration.Endpoints;
import code.generated_model.multichoice_task.checked.AnswerPayload;
import code.generated_model.multichoice_task.checked.CheckedTask;
import code.generated_model.multichoice_task.checked.CheckedTasks;
import code.generated_model.multichoice_task.checked.TaskData;
import code.generated_model.multichoice_task.data.Task;
import code.generated_model.multichoice_task.payload.TaskPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class SingleSolverService {

  private WebClient client;
  private ObjectMapper objectMapper;

  @SneakyThrows
  public CheckedTask postCheckedTask(Task task, List<AnswerPayload> answerPayloads, Integer checkNumber) {
    TaskPayload payload = TaskPayload.builder()
      .taskId(task.getId())
      .worksheetStudentCheck(checkNumber)
      .taskData(TaskData.builder()
        .taskId(task.getId())
        .taskType(task.getType())
        .answers(answerPayloads)
        .build()
      ).build();

    String strPayload = objectMapper.writeValueAsString(payload);
    strPayload = "[" + strPayload + "]";
    log.info("postCheckedTask bodyValue:{}", strPayload);
    var retrieve = client.post()
      .uri(Endpoints.postCheckedTasks)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .bodyValue(strPayload)
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log.info("postCheckedTask response:{}", str);
    return objectMapper.readValue(str, CheckedTask.class);
  }

  @SneakyThrows
  public CheckedTasks getCheckedTasks(Integer worksheetId) {
    var retrieve = client.get()
      .uri(Endpoints.getCheckedTasks, worksheetId)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve();
    String str = retrieve.bodyToMono(String.class).block();
    log.info("getCheckedTasks for worksheetId:[{}] response:{}", worksheetId, str);
    return objectMapper.readValue(str, CheckedTasks.class);
  }

  public void postAttempt(Integer worksheetId) {
    String payload = "{\"worksheet_id\":\"%s\",\"grade\":\"3\",\"school_class_type\":\"HIGH\"}"
      .formatted(worksheetId);
    log.info("postAttempt bodyValue:{}", payload);
    client.post()
      .uri(Endpoints.postAddAttempt)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON)
      .header("Authorization", "Token " + Authorization.TOKEN)
      .bodyValue(payload)
      .retrieve();
  }

}