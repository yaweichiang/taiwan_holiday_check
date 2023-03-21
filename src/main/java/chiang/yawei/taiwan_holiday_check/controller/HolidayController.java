package chiang.yawei.taiwan_holiday_check.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import chiang.yawei.taiwan_holiday_check.service.HolidayAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Holiday API")
@RestController
public class HolidayController {
  private Logger logger = LoggerFactory.getLogger(HolidayController.class);
  private static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
  @Autowired
  private HolidayAPI holidayAPI;

  @Operation(summary = "check date information about holiday")
  @GetMapping("/check/{date}")
  public Boolean checkHoliday(@Parameter(name = "date", description = "date,ex=20230312") @PathVariable(name = "date") String date) {
    try {
      LocalDate localDate = LocalDate.parse(date, yyyyMMdd);
      logger.info("date:{}", date);
      return holidayAPI.checkHoliday(localDate);
    } catch (Exception e) {
      return false;
    }
  }
}
