package code.generated_model.task_xml.drag_drop;

import code.generated_model.dragdrop_task.Feedback;
import code.generated_model.dragdrop_task.Item;
import code.generated_model.dragdrop_task.Zone;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.beans.ConstructorProperties;
import java.util.List;
import javax.annotation.processing.Generated;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@EqualsAndHashCode(of = {})
@RequiredArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "feedback",
    "items",
    "targetImg",
    "targetImgDescription",
    "zones"
  })
}))
@Generated("jsonschema2pojo")
public class TaskXmlJson {

  Feedback feedback;
  List<Item> items;
  String targetImg;
  String targetImgDescription;
  List<Zone> zones;

}