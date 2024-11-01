package code;

import code.generated_model.school_data.course.Course;
import code.service.SchoolDataFetcher;
import java.util.List;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(classes = ApplicationRunner.class)
class CourseFilteringTest {

  private SchoolDataFetcher dataFetcher;

  @Test
  void test() {
    List<Course> courses = dataFetcher.getCourses();
    courses.forEach(System.out::println);
  }
}