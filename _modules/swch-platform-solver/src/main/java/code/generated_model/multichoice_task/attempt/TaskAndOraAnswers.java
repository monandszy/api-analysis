package code.generated_model.multichoice_task.attempt;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Generated("http://pojo.sodhanalibrary.com/")
@Data
@EqualsAndHashCode(of = {})
@RequiredArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "percentage_score",
    "is_exam",
    "worksheet_student",
    "created_at",
    "student_id",
    "checker_id",
    "criterions",
    "file_answer",
    "feedback",
    "oraTask",
    "updated_at",
    "worksheet_exam_student",
    "is_checked",
    "id",
    "text",
    "attempts"
  })
}))
public class TaskAndOraAnswers {
  String percentageScore;
  String isExam;
  String worksheetStudent;
  String createdAt;
  String studentId;
  Object checkerId;
  Criterion[] criterions;
  Object fileAnswer;
  Object feedback;
  OraTask oraTask;
  String updatedAt;
  Object worksheetExamStudent;
  String isChecked;
  String id;
  Object text;
  String attempts;
}