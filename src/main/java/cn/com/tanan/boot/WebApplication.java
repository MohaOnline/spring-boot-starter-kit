package cn.com.tanan.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Arrays;

/* SpringBootApplication 在自定义包里使用
 * 标识后自动扫描同包下的 Controller、Entity
 */
@SpringBootApplication /* 隐式打开 @EnableWebMvc，激活 http / https 通信 URL */
public class WebApplication {
  
  public static void main(String[] args) {
    // 委托 SpringApplication 运行自己
    SpringApplication.run(WebApplication.class, args);
  }

  /**
   * 加载主数据源
   */
  @Bean
  @Primary
  @ConditionalOnProperty(prefix="spring.datasource", name="jdbc-url", havingValue="")
  @ConfigurationProperties(prefix="spring.datasource")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }

  /**
   * @link https://stackoverflow.com/questions/30337582/spring-boot-configure-and-use-two-datasources
   * 加载 h2 数据源
   */
  @Bean
  @ConfigurationProperties(prefix="spring.h2.ds")
  public DataSource h2DataSource() {
    return DataSourceBuilder.create().build();
  }

  /* Bean annotation 标识 CommandLineRunner 启动时运行 */
  // @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      System.out.println("The beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }

    };
  }
}
