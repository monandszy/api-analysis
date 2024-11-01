package code.generated_model.dragdrop_task;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("http://pojo.sodhanalibrary.com/")
@Value
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "uid",
    "width",
    "x",
    "description",
    "y",
    "align",
    "title",
    "height"
  })
}))
public class Zone {
  String uid;
  String width;
  String x;
  String description;
  String y;
  String align;
  String title;
  String height;
}