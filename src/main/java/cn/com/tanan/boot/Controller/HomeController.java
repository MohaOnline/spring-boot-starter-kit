package cn.com.tanan.boot.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * Handles http requests per URI.
 */
@RestController
public class HomeController {

  @RequestMapping("/")
  String renderHome() {
    return "Greetings from Spring Boot!";
  }
}
