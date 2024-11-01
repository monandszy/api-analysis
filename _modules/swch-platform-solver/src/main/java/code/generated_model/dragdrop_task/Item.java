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
    "feedback",
    "displayName",
    "imageDescription",
    "imageURL",
    "id"
  })
}))
public class Item {
  Feedback feedback;
  String displayName;
  String imageDescription;
  String imageURL;
  String id;
}