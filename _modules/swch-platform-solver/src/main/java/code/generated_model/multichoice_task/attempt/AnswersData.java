package code.generated_model.multichoice_task.attempt;

import code.generated_model.multichoice_task.checked.AnswerPayload;
import code.generated_model.multichoice_task.checked.TaskInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("http://pojo.sodhanalibrary.com/")
@Value
@Builder
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "answers",
    "task_id",
    "task_info",
    "task_type"
  })
}))
public class AnswersData {
  AnswerPayload[] answers;
  String taskId;
  TaskInfo taskInfo;
  String taskType;
}