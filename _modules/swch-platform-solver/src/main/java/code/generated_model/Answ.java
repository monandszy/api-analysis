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
@Generated("jsonschema2pojo")
public class Answ {

  @JsonProperty("school_class_grade")
  public String schoolClassGrade;
  @JsonProperty("task_data")
  public List<TaskDatum> taskData = new ArrayList<TaskDatum>();
  @JsonProperty("subject_id")
  public Integer subjectId;
  @JsonProperty("worksheet_id")
  public Integer worksheetId;
  @JsonProperty("percentage_score")
  public Integer percentageScore;
  @JsonProperty("ora_task_data")
  public List<Object> oraTaskData = new ArrayList<Object>();
  @JsonProperty("single_check_completion")
  public Boolean singleCheckCompletion;
  @JsonProperty("check_worksheet")
  public Boolean checkWorksheet;
  @JsonProperty("special_case_course_id")
  public Object specialCaseCourseId;

  /**
   * No args constructor for use in serialization
   */
  public Answ() {
  }

  @ConstructorProperties({
    "schoolClassGrade",
    "taskData",
    "subjectId",
    "worksheetId",
    "percentageScore",
    "oraTaskData",
    "singleCheckCompletion",
    "checkWorksheet",
    "specialCaseCourseId"
  })
  public Answ(String schoolClassGrade, List<TaskDatum> taskData, Integer subjectId, Integer worksheetId, Integer percentageScore, List<Object> oraTaskData, Boolean singleCheckCompletion, Boolean checkWorksheet, Object specialCaseCourseId) {
    super();
    this.schoolClassGrade = schoolClassGrade;
    this.taskData = taskData;
    this.subjectId = subjectId;
    this.worksheetId = worksheetId;
    this.percentageScore = percentageScore;
    this.oraTaskData = oraTaskData;
    this.singleCheckCompletion = singleCheckCompletion;
    this.checkWorksheet = checkWorksheet;
    this.specialCaseCourseId = specialCaseCourseId;
  }

}