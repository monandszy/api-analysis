package code.generated_model.multichoice_task.checked;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@Builder
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "id",
    "zone",
    "value",
    "points",
    "aid"
  })
}))
public class AnswerPayload {

  Integer id;
  String zone;
  String value;
  Integer points;
  Integer aid;

}