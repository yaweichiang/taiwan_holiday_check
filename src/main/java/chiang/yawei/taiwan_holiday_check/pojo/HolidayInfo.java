package chiang.yawei.taiwan_holiday_check.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HolidayInfo implements Serializable {
  public static final DateTimeFormatter yyyyMd = DateTimeFormatter.ofPattern("yyyy/M/d");
  public static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  @JsonProperty(value = "_id")
  private Integer id;
  @JsonProperty(value = "date")
  private String date;
  @JsonProperty(value = "name")
  private String name;
  @JsonProperty(value = "isholiday")
  private Boolean isHoliday;
  @JsonProperty(value = "holidaycategory")
  private String holidayCategory;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = LocalDate.parse(date, yyyyMd).format(yyyyMMdd);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getIsHoliday() {
    return isHoliday;
  }

  public void setIsHoliday(String isHoliday) {
    this.isHoliday = isHoliday.equals("是") ? true : false;
  }

  public String getHolidayCategory() {
    return holidayCategory;
  }

  public void setHolidayCategory(String holidayCategory) {
    this.holidayCategory = holidayCategory;
  }
  //  public void setDate(String date){
  //    if (date.matches(JSON_DATE_REGEX))
  //      this.date = LocalDate.parse(date, yyyyMMdd);
  //  }

}
