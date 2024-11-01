package code.generated_model.task_xml;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.beans.ConstructorProperties;
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
    "aid",
  })
}))
@Slf4j
public class Choice {
  @JacksonXmlProperty(localName = "aid", isAttribute = true)
  private final String aid;
  @JsonProperty("content")
  private String content;

  @JsonAnySetter
  public void setContent(String name, Object content) {
    if (!name.isEmpty()) {
      log.error("Unregistered parameter: [{}] content:{}", name, content);
      return;
    }
  }
}