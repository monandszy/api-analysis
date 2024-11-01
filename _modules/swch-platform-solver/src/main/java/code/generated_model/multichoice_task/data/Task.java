package code.generated_model.multichoice_task.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    "worksheet",
    "content",
    "hint",
    "explanation",
    "task_xml",
    "type",
    "image",
    "answers",
    "question",
    "is_additional_task"

  })
}))
public class Task {

  @JsonProperty("id")
  Integer id;
  @JsonProperty("worksheet")
  Integer worksheetId;
  @JsonProperty("content")
  String content;
  @JsonProperty("hint")
  String hint;
  @JsonProperty("explanation")
  String explanation;
  @JsonProperty("task_xml")
  String taskXml;
  @JsonProperty("type")
  String type;
  @JsonProperty("image")
  Object image;
  @JsonProperty("answers")
  List<DisplayedAnswer> answers;
  @JsonProperty("question")
  String question;
  @JsonProperty("is_additional_task")
  Boolean isAdditionalTask;

}