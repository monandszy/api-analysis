package code.generated_model.school_data.course;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import java.util.List;
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
    "count",
    "next",
    "previous",
    "results"
  })
}))
public class Courses {

  Integer count;
  Object next;
  Object previous;
  List<Course> courses;

}