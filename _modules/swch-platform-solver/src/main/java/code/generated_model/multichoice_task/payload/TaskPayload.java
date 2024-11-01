package code.generated_model.multichoice_task.payload;

import code.generated_model.multichoice_task.checked.TaskData;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@EqualsAndHashCode(of = {})
@Builder
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "worksheet_student_check",
    "task_data",
    "task"
  })
}))
public class TaskPayload {

  @JsonProperty("worksheet_student_check")
  Integer worksheetStudentCheck;
  @JsonProperty("task_data")
  TaskData taskData;
  @JsonProperty("task")
  Integer taskId;

}