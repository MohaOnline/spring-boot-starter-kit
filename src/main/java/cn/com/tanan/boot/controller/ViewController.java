package cn.com.tanan.boot.controller;

import cn.com.tanan.boot.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Define endpoint URLs under /view/ which leverage template to render page.
 */
@Controller
public class ViewController {

    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/view/hello")
    public String helloView(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "hello"; /* View name */
    }

    /** GET 返回 login 页面 */
    @GetMapping("/view/user/login")
    public String loginView(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name, Model m){
        m.addAttribute("name", name);
        m.addAttribute("greeting", new Greeting(counter.incrementAndGet(), ""));
        return "/user/login"; /* 返回模版，pom.xml 中添加 spring-boot-starter-thymeleaf 后可直接跳转 */
    }

    @PostMapping("/view/user/login")
    public String loginViewSubmit(@ModelAttribute Greeting greeting) {
        return "/user/home";
    }
}
