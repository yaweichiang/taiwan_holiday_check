package chiang.yawei.taiwan_holiday_check.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HolidaysResp implements Serializable {
  @JsonProperty(value = "result")
  private Result result;

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }
}
