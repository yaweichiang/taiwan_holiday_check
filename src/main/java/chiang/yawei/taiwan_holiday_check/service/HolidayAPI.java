package chiang.yawei.taiwan_holiday_check.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import chiang.yawei.taiwan_holiday_check.pojo.HolidayInfo;
import chiang.yawei.taiwan_holiday_check.pojo.HolidaysResp;
import chiang.yawei.taiwan_holiday_check.pojo.Result;

/**
 * 取得台北市政府國定假日資料
 */
@Component
public class HolidayAPI implements InitializingBean {
  @Value("${holidayApi.endpoint}")
  private String endpoint;
  private static final Logger log = LoggerFactory.getLogger(HolidayAPI.class);
  public static Integer last_date_id = 0; // 2022/12/31
  public static Integer count;
  public static Integer offset;
  public static Map<LocalDate, Boolean> holidayMap = new HashMap<>();

  public Boolean checkHoliday(LocalDate localDate) {
    try {
      if (holidayMap.containsKey(localDate))
        return holidayMap.get(localDate);
      else
        return false;
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Result result = null;
    List<HolidayInfo> holidayInfoList = null;
    do {
      offset = last_date_id;
      result = new RestTemplate().getForObject(endpoint.formatted(offset), HolidaysResp.class).getResult();
      holidayInfoList = result.getResults();
      count = result.getCount();
      if (holidayInfoList.size() > 0) {
        last_date_id = holidayInfoList.get(holidayInfoList.size() - 1).getId();
        holidayInfoList.stream().forEach(holidayInfo -> holidayMap.put(LocalDate.parse(holidayInfo.getDate(), HolidayInfo.yyyyMMdd), holidayInfo.getIsHoliday()));
      }
      log.info("[HolidayAPI] Loaded offset:{} count:{} last_date_id:{} list_size:{} map_size:{}", offset, count, last_date_id, holidayInfoList != null ? holidayInfoList.size() : 0, holidayMap.size());
    } while (holidayInfoList.size() == 1000 && last_date_id < count);
  }
}
