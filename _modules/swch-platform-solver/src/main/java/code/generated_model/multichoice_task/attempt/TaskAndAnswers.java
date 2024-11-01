package code.generated_model.multichoice_task.attempt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.beans.ConstructorProperties;
import java.util.Objects;
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
    "task",
    "worksheet_student",
    "updated_at",
    "created_at",
    "student_id",
    "id"
  })
}))
public class TaskAndAnswers {

  private final String percentageScore;
  private final String task;
  private final String worksheetStudent;
  private final String updatedAt;
  private final String createdAt;
  private final String studentId;
  private final String id;
  private AnswerStructure[] answerStructure;

  @JsonSetter("answer_structure")
  void setAnswerStructure(String name, Object content) {
    if (Objects.isNull(content))
      return;
    if (content.getClass().isArray()) {
      this.answerStructure = (AnswerStructure[]) content;
    } else {
      this.answerStructure = new AnswerStructure[]
        {(AnswerStructure) content};
    }

  }
}