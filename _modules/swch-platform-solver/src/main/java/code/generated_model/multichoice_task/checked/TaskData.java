package code.generated_model.multichoice_task.checked;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.beans.ConstructorProperties;
import java.util.List;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Generated("jsonschema2pojo")
@Value
@With
@EqualsAndHashCode(exclude = {})
@Builder
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "answers",
    "task_id",
    "task_info",
    "task_type"
  })
}))
public class TaskData {

  @JsonProperty("answers")
  List<AnswerPayload> answers;
  @JsonProperty("task_id")
  Integer taskId;
  @JsonProperty("task_info")
  TaskInfo taskInfo;
  @JsonProperty("task_type")
  String taskType;

}