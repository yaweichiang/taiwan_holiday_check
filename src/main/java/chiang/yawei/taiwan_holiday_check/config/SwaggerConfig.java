package chiang.yawei.taiwan_holiday_check.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI springOpenAPI() {
    return new OpenAPI().info(new Info().title("Swagger API 測試頁面").description("台灣假日查詢api").version(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
  }
}
