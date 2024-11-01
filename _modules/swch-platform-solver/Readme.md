### How to use:

- input data to Authorization.java interface in src/main/java/code/configuration/
- choose a worksheet or a subject
- prepare data from selected
  url: https://platforma.szkolawchmurze.org/courses/details/{courseId}/1/3/10/work-sheet/{worksheetId}/{subjectId}
  or
  url: https://api.szkolawchmurze.org/students/get_courses/?show_languages=true&for_exam=true&no_page=true
- ignore the /1/3/10/ numbers (might be different for you)
- just in case change the .schoolClassGrade("4") in the Solver Service.
- input data to the solveOne or solveAll test method in the SolveTest class
- run the test case. Worksheets will be solved or corrected.
- adjust pixel positioning in the RobotService to scan the worksheets with the GoFullPage extension.