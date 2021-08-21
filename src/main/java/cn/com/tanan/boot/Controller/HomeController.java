package cn.com.tanan.boot.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * Handles http requests per URI.
 */
@RestController
public class HomeController {

  @RequestMapping("/")
  String Home() {
    return "Greetings from Spring Boot!";
  }
}
