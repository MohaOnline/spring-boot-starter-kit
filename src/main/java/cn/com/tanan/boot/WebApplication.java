package cn.com.tanan.boot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*
 * SpringBootApplication 在自定义包里使用 标识后自动扫描同包下的 Controller
 */
@SpringBootApplication
public class WebApplication {

  public static void main(String[] args) {
    // 委托 SpringApplication 运行自己
    SpringApplication.run(WebApplication.class, args);
  }

  /**
   * Callback for Command Line startting up.
   * 
   * @Bean 标识 CommandLineRunner 启动时运行
   */
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

    Logger logger = LoggerFactory.getLogger(WebApplication.class);

    return args -> {

      // 是否输出所有 Bean
      String ifPrintContextBeans = "true";
      if (ifPrintContextBeans.equals("true")) {

        logger.info("======== The beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
          logger.info(beanName);
        }
      }

    };
  }
}
