package cn.com.tanan.boot.controller;

import cn.com.tanan.boot.model.Greeting;
import cn.com.tanan.boot.service.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class RawController {

  /* 标记可访问 URI */
  @RequestMapping("/raw/hello")
  public @ResponseBody String hello() {
    return "Hello, World";
  }


  /** Greeting from service. */
  private final GreetingService service;
  public RawController(GreetingService service) {
    this.service = service;
  }

  @RequestMapping("/raw/hello-service")
  public @ResponseBody String helloService() {
    return service.greet();
  }


  /** Greeting from object. */
  private static final String template = "Hello, %s!";
  private static final AtomicLong counter = new AtomicLong();

  @GetMapping("/raw/hello-json")
  @ResponseBody /* 标记函数返回为应答内容，直接在 responseBody 里返回的对象会被转为 JSON */
  public Greeting helloJson(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

}
