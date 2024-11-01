package code.generated_model.school_data;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "id",
    "name",
    "school_class_type",
    "grade"
  })
}))
public class SchoolClass {

  Integer id;
  String name;
  String schoolClassType;
  Integer grade;

}