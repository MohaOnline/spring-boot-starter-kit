import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Application {

  @RequestMapping("/hello")
  String hello() {
    return "Greetings from Spring boot!";
  }

  public static void main(String[] args) {
    // 委托 SpringApplication 运行自己
    SpringApplication.run(Application.class, args);
  }

}
