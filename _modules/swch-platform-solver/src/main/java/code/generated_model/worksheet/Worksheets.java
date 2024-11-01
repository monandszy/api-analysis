package code.generated_model.worksheet;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator
}))
public class Worksheets {

  List<Worksheet> worksheets;

}