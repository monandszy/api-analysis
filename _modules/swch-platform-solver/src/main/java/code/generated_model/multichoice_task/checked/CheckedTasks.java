package code.generated_model.multichoice_task.checked;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import java.util.List;
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
    "id",
    "single_check_tasks",
    "created_at",
    "updated_at",
    "student_id",
    "worksheet_id"
  })
}))
public class CheckedTasks {

  Integer id;
  List<CheckedTask> checkedTasks;
  String createdAt;
  String updatedAt;
  Integer studentId;
  Integer worksheetId;

}