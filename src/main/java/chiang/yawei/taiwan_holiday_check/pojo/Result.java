package chiang.yawei.taiwan_holiday_check.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result implements Serializable {
  @JsonProperty(value = "limit")
  private Integer limit;
  @JsonProperty(value = "offset")
  private Integer offset;
  @JsonProperty(value = "count")
  private Integer count;
  @JsonProperty(value = "sort")
  private String sort;
  @JsonProperty(value = "results")
  private List<HolidayInfo> results;

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public List<HolidayInfo> getResults() {
    return results;
  }

  public void setResults(List<HolidayInfo> results) {
    this.results = results;
  }
}
