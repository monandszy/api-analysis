package code.generated_model.task_xml.drag_drop;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "align",
    "description",
    "height",
    "title",
    "uid",
    "width",
    "x",
    "y"
  })
}))
@Generated("jsonschema2pojo")
public class Zone {

  String align;
  String description;
  String height;
  String title;
  String uid;
  String width;
  String x;
  String y;

}