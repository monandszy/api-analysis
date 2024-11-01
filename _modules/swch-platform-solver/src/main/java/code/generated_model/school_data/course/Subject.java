package code.generated_model.school_data.course;

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
  @ConstructorProperties({"id",
    "icon",
    "background_icon",
    "background_icon_exam",
    "is_curriculum_difference",
    "key",
    "name",
    "subject_type",
    "optional",
    "curriculum_difference_main_subject"
  })
}))
public class Subject {

  Integer id;
  String icon;
  String backgroundIcon;
  String backgroundIconExam;
  Boolean isCurriculumDifference;
  String key;
  String name;
  String subjectType;
  Boolean optional;
  Object curriculumDifferenceMainSubject;

}