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
    "correct",
    "incorrect"
  })
}))
public class Feedback {
  String correct;
  String incorrect;
}