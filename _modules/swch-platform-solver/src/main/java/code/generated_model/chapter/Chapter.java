package code.generated_model.chapter;

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
    "created_at",
    "updated_at",
    "name",
    "is_extended",
    "chapter_field",
    "course"
  })
}))
public class Chapter {

  Integer id;
  String createdAt;
  String updatedAt;
  String name;
  Boolean isExtended;
  Object chapterField;
  Integer courseId;

}