package code.generated_model.multichoice_task.attempt;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Generated("http://pojo.sodhanalibrary.com/")
@Data
@EqualsAndHashCode(of = {})
@RequiredArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "updated_at",
    "criteria",
    "name",
    "created_at",
    "id",
    "label",
    "explanation",
    "points"
  })
}))
public class Options {
  String updatedAt;
  String criteria;
  String name;
  String createdAt;
  String id;
  String label;
  String explanation;
  String points;
}