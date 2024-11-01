package code.generated_model.school_data.course;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "id",
    "subject",
    "deadlines",
    "worksheets_modular_min",
    "worksheets_modular_max",
    "extended",
    "language_selected",
    "has_subcourses",
    "board_exam",
    "written_exam_not_available_for_planning",
    "verbal_exam_not_available_for_planning",
    "created_at",
    "updated_at",
    "image_file",
    "exam_tasks_count",
    "exam_ora_tasks_count",
    "is_visible",
    "is_visible_in_test_egzams",
    "can_be_extended",
    "has_own_material_in_extension",
    "has_own_material_in_base",
    "roll_even_if_own_material_base",
    "roll_even_if_own_material_extend",
    "is_grade_based_on_feedback",
    "part_of_other_course",
    "curriculum_difference_main_course",
    "school_class"
  })
}))
public class Course {

  Integer id;
  Subject subject;
  Deadlines deadlines;
  Integer worksheetsModularMin;
  Integer worksheetsModularMax;
  Boolean extended;
  Boolean languageSelected;
  Boolean hasSubcourses;
  Object boardExam;
  Boolean writtenExamNotAvailableForPlanning;
  Boolean verbalExamNotAvailableForPlanning;
  String createdAt;
  String updatedAt;
  Object imageFile;
  Integer examTasksCount;
  Integer examOraTasksCount;
  Boolean isVisible;
  Boolean isVisibleInTestEgzams;
  Boolean canBeExtended;
  Boolean hasOwnMaterialInExtension;
  Boolean hasOwnMaterialInBase;
  Boolean rollEvenIfOwnMaterialBase;
  Boolean rollEvenIfOwnMaterialExtend;
  Boolean isGradeBasedOnFeedback;
  Object partOfOtherCourse;
  Object curriculumDifferenceMainCourse;
  Integer schoolClass;

}