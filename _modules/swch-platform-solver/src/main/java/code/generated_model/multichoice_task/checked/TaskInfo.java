package code.generated_model.multichoice_task.checked;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "max_score",
    "student_score",
    "task_percentage_score"
  })
}))
public class TaskInfo {

  Integer maxScore;
  Integer studentScore;
  Integer taskPercentageScore;

}