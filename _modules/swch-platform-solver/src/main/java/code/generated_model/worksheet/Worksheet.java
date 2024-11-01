package code.generated_model.worksheet;

import code.generated_model.chapter.Chapter;
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
    "has_draft",
    "school_year",
    "chapter",
    "created_at",
    "updated_at",
    "description",
    "name",
    "deadline",
    "image_file",
    "intro",
    "bibliography",
    "subject_base",
    "coursebook",
    "worksheet_class",
    "proposed_class"
  })
}))
public class Worksheet {

  Integer id;
  Boolean hasDraft;
  String schoolYear;
  Chapter chapter;
  String createdAt;
  String updatedAt;
  Object description;
  String name;
  Object deadline;
  String imageFile;
  String intro;
  String bibliography;
  String subjectBase;
  Object coursebook;
  String worksheetClass;
  Object proposedClass;

}