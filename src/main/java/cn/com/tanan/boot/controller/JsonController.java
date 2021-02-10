package cn.com.tanan.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles http requests per URI.
 */
@RequestMapping("/json")
@RestController /* @see @RestController = @Controller + @ResponseBody */
public class JsonController {

  @RequestMapping("/greetings")
  String jsonGreetingsText() {
    return "Greetings from Spring Boot!";
  }
}
