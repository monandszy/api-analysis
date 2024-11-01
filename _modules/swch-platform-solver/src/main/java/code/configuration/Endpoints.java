package code.configuration;

public interface Endpoints {

  String getChaptersPath = "students/get_chapters/";
  String getChaptersParams = "?course={course_id}&no_page=true&is_extended={is_extended}";
  String getChapters = getChaptersPath + getChaptersParams;
  String getWorksheetsPath = "students/get_worksheets/";
  String getWorksheetsParams = "?course={course_id}&chapter_ids={chapter_ids}";
  String getWorksheets = getWorksheetsPath + getWorksheetsParams;
  String getTasksPath = "students/get_tasks/";
  String getTasksParams = "?worksheet={worksheet_id}";
  String getTasks = getTasksPath + getTasksParams;

  String getCheckedTasks = "students/get_my_checked_tasks/?worksheet_id={worksheet_id}";

  String postCheckedTasks = "students/add_checked_tasks/";

  String patchCheckedTasks = "students/{checked_task_id}/update_checked_task/";

  String login = "users/login/";

  String postWorksheetStudentCheck = "students/create_worksheet_checked_record/";

  String postAddAttempt = "students/post_add_attempts/";

  String postWorksheetAnswer = "students/post_worksheet_answer/";

  String checkAttempts = "students/check_attempts/?worksheet_id={worksheet_id}&school_class=10";

  String getAvailableClasses = "students/get_available_school_classes/";

  String getCourses = "students/get_courses/?no_page=true";

  // Italian https://platforma.szkolawchmurze.org/courses/details/117/1/3/10/work-sheet/2136/39
}