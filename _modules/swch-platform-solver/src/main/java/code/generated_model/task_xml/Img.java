package code.generated_model.task_xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("http://pojo.sodhanalibrary.com/")
@Value
@Builder
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "src",
    "alt",
    "style"
  })
}))
public class Img {
  String src; // correct path /static/edx/images/NAME.jpg
  String alt;
  String style;
}