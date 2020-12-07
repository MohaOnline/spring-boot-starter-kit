package cn.com.tanan.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles http requests per URI.
 */
@RestController
public class JsonController {

  @RequestMapping("/json/hello")
  String testJsonHelloText() {
    return "Greetings from Spring Boot!";
  }
}
