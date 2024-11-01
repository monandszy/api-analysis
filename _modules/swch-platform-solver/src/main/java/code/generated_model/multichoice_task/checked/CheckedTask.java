package code.generated_model.multichoice_task.checked;

import code.generated_model.multichoice_task.data.Task;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Generated("jsonschema2pojo")
@Value
@With
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "id",
    "task_data",
    "created_at",
    "updated_at",
    "is_correct",
    "percentage_score",
    "attempts",
    "parsed",
    "worksheet_student_check",
    "task",
    "task_serialized"
  })
}))
public class CheckedTask {

  Integer id;
  TaskData taskData;
  String createdAt;
  String updatedAt;
  Boolean isCorrect;
  Object percentageScore;
  Integer attempts;
  Boolean parsed;
  Integer worksheetStudentCheck;
  Integer taskId;
  //    @JsonProperty("task_serialized")
  Task task; // sometimes appears - contains all answers

}