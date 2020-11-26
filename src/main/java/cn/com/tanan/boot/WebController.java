package cn.com.tanan.boot;

import org.springframework.web.bind.annotation.*;

/**
 * Handles http requests per URI.
 */
@RestController
public class WebController {

  @RequestMapping("/hello")
  String hello() {
    return "Greetings from Spring Boot!";
  }
}
