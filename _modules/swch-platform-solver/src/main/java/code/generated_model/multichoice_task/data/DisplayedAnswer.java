package code.generated_model.multichoice_task.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Generated("jsonschema2pojo")
@Value
@EqualsAndHashCode(of = {})
@AllArgsConstructor(onConstructor = @__({
  @JsonCreator,
  @ConstructorProperties({
    "id",
    "created_at",
    "updated_at",
    "value",
    "score",
    "is_correct",
    "drag_drop_id",
    "drag_drop_set",
    "x1_y1_coordinates",
    "x2_y2_coordinates",
    "task",
    "subtask"
  })
}))
public class DisplayedAnswer {

  @JsonProperty("id")
  Integer id;
  @JsonProperty("created_at")
  String createdAt;
  @JsonProperty("updated_at")
  String updatedAt;
  @JsonProperty("value")
  String value;
  @JsonProperty("score")
  Integer score;
  @JsonProperty("is_correct")
  Boolean isCorrect;
  @JsonProperty("drag_drop_id")
  String dragDropId;
  @JsonProperty("drag_drop_set")
  String dragDropSet;
  @JsonProperty("x1_y1_coordinates")
  Object x1Y1Coordinates;
  @JsonProperty("x2_y2_coordinates")
  Object x2Y2Coordinates;
  @JsonProperty("task")
  Integer taskId;
  @JsonProperty("subtask")
  Object subtask;

}