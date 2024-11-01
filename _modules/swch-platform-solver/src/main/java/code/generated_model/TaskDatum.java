package code.generated_model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "task_id",
  "task_type",
  "answers"
})
@Generated("jsonschema2pojo")
public class TaskDatum {

  @JsonProperty("task_id")
  public Integer taskId;
  @JsonProperty("task_type")
  public String taskType;
  @JsonProperty("answers")
  public List<AnswerPayload> answerPayloads = new ArrayList<AnswerPayload>();

  /**
   * No args constructor for use in serialization
   */
  public TaskDatum() {
  }

  @ConstructorProperties({
    "taskId",
    "taskType",
    "answers"
  })
  public TaskDatum(Integer taskId, String taskType, List<AnswerPayload> answerPayloads) {
    super();
    this.taskId = taskId;
    this.taskType = taskType;
    this.answerPayloads = answerPayloads;
  }

}