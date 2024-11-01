package code.generated_model.task_xml.choice_redirectors;

import code.generated_model.task_xml.Choice;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("http://pojo.sodhanalibrary.com/")
@Value
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "choice_num",
    "choice"
  })
}))
public class Checkboxgroup {
  String choice_num;
  Choice[] choice;
}