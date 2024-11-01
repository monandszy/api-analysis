package code.generated_model.multichoice_task.attempt;

import code.generated_model.worksheet.Worksheet;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("http://pojo.sodhanalibrary.com/")
@Value
@Builder
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "percentage_score",
    "task_and_ora_answers",
    "special_case_note",
    "created_at",
    "student_id",
    "ora_tasks_only",
    "is_modular_choice",
    "special_case",
    "answers_data",
    "is_passed",
    "updated_at",
    "old_answers_data",
    "is_individual_suggestion",
    "percentage_progress",
    "worksheet",
    "parsed",
    "id",
    "has_unchecked_answers",
    "resource_status",
    "task_and_answers",
    "attempts",
    "course_student"
  })
}))
public class Results {
  Integer percentageScore;
  TaskAndOraAnswers[] taskAndOraAnswers;
  Object specialCaseNote;
  String createdAt;
  String studentId;
  String oraTasksOnly;
  String isModularChoice;
  String specialCase;
  AnswersData[] answersData;
  String isPassed;
  String updatedAt;
  Object oldAnswersData;
  String isIndividualSuggestion;
  Object percentageProgress;
  Worksheet worksheet;
  String parsed;
  String id;
  String hasUncheckedAnswers;
  Object resourceStatus;
  TaskAndAnswers[] taskAndAnswers;
  Integer attempts;
  String courseStudent;
}