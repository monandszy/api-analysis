package code.generated_model.task_xml;

import code.generated_model.task_xml.choice_redirectors.Choiceresponse;
import code.generated_model.task_xml.choice_redirectors.Multiplechoiceresponse;
import code.generated_model.task_xml.choice_redirectors.Optionresponse;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Generated("http://pojo.sodhanalibrary.com/")
@Data
@EqualsAndHashCode(of = {})
@RequiredArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "img",
    "class",
    "choiceresponse",
    "multiplechoiceresponse",
    "optionresponse",
    "problem",
    "markdown",
    "weight",
    "display_name"
  })
}))
@Slf4j
public class TaskXml {
  private final Img img;
  private final String clazz;
  private final Choiceresponse choiceresponse; // for square
  private final Multiplechoiceresponse[] multiplechoiceresponse; // for circle
  private final Optionresponse[] optionresponse; // for fill
  private final TaskXml problem; //for fill
  private final String markdown;
  private final String weight;
  private final String displayName;
  private Object[] p;
  private List<String> content = new ArrayList<>();

  @JsonSetter("p")
  public void setP(Object[] p) {
    System.out.println("P!!:" + Arrays.toString(p));
    this.p = p;
  }

  @JsonAnySetter
  public void setContent(String name, Object content) {
    if (!name.isEmpty()) {
      log.error("Unregistered parameter: [{}] content:{}", name, content);
      return;
    }
    if (content instanceof List<?>) {
      this.content.addAll((List) content);
    }
    if (content instanceof String)
      this.content.add(content.toString());
  }

}