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
    "end_date",
    "image",
    "use_in_exam",
    "question",
    "raw_xml",
    "created_at",
    "index",
    "explanation",
    "type",
    "content",
    "is_correct",
    "task_xml",
    "updated_at",
    "is_additional_task",
    "is_draft",
    "hint",
    "max_score",
    "worksheet",
    "id",
    "start_date"
  })
}))
public class OraTask {
  Object endDate;
  Object image;
  String useInExam;
  String question;
  String rawXml;
  String createdAt;
  String index;
  String explanation;
  String type;
  String content;
  String isCorrect;
  String taskXml;
  String updatedAt;
  String isAdditionalTask;
  String isDraft;
  String hint;
  String maxScore;
  String worksheet;
  String id;
  String start_date;
}