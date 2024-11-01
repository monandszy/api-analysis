package code.service;

import code.generated_model.multichoice_task.checked.CheckedTasks;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckService {

  private TaskFetcher taskFetcher;

  public Integer getCheckNumber(Integer worksheetId) {
    CheckedTasks checkedTasks = taskFetcher.getCheckedTasks(worksheetId);
    if (Objects.nonNull(checkedTasks) && Objects.nonNull(checkedTasks.getId())) {
      return checkedTasks.getId();
    } else {
      return taskFetcher.getWorksheetStudentCheck(worksheetId);
    }
  }
}