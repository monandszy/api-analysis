package code.generated_model.task_xml.drag_drop;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "finish",
    "start"
  })
}))
@Generated("jsonschema2pojo")
public class Feedback {

  String finish;
  String start;

}