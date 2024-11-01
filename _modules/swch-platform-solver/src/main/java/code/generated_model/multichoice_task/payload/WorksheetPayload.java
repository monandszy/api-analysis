package code.generated_model.multichoice_task.payload;

import code.generated_model.multichoice_task.checked.TaskData;
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
@EqualsAndHashCode(of = {})
@Builder
@With
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "school_class_grade",
    "task_data",
    "subject_id",
    "worksheet_id",
    "percentage_score",
    "ora_task_data",
    "single_check_completion",
    "check_worksheet",
    "special_case_course_id"
  })
}))
public class WorksheetPayload {

  @JsonProperty("school_class_grade")
  String schoolClassGrade;
  @JsonProperty("task_data")
  List<TaskData> taskData;
  @JsonProperty("subject_id")
  Integer subjectId;
  @JsonProperty("worksheet_id")
  Integer worksheetId;
  @JsonProperty("percentage_score")
  Integer percentageScore;
  @JsonProperty("ora_task_data")
  List<Object> oraTaskData;
  @JsonProperty("single_check_completion")
  Boolean singleCheckCompletion;
  @JsonProperty("check_worksheet")
  Boolean checkWorksheet;
  @JsonProperty("special_case_course_id")
  Object specialCaseCourseId;

}