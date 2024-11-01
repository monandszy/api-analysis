package code.configuration;

public interface Constants {

  String resourcePath = "src/main/resources/";
  String jsonPath = resourcePath + "json_samples/";
  String javaDir = "src/main/java/";
  String outputDir = "code.generated_model";

   /*
    Model hierarchy:
    Courses
     Course
      Chapters
       Chapter
        Worksheets
         Worksheet
          Tasks
           Task
            Answer
   */
}