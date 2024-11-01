package code.generated_model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "aid"
})
@Generated("jsonschema2pojo")
public class AnswerPayload {

  @JsonProperty("aid")
  public Integer aid;

  /**
   * No args constructor for use in serialization
   */
  public AnswerPayload() {
  }

  @ConstructorProperties({
    "aid"
  })
  public AnswerPayload(Integer aid) {
    super();
    this.aid = aid;
  }

}