package cn.com.tanan.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/* SpringBootApplication 在自定义包里使用
 * 标识后自动扫描同包下的 Controller
 */
@SpringBootApplication
public class WebApplication {
  
  public static void main(String[] args) {
    // 委托 SpringApplication 运行自己
    SpringApplication.run(WebApplication.class, args);
  }

  /* Bean 标识 CommandLineRunner 启动时运行
   */
  @Bean
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
