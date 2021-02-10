/*
 * 需要放在 src/test 目录下
 */
package cn.com.tanan.boot;

import cn.com.tanan.boot.controller.JsonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(JsonController.class) /* 参数表明测试哪个 Controller */
public class JsonControllerTest {

    @Autowired
    private MockMvc mvc;    /* 模拟 HTTP requests，通过 SpringBootTest、AutoConfigureMockMvc 注入 MockMvc 实例 */

    @Test
    public void testJsonGreetingsText() throws Exception {
        mvc.perform(get("/json/greetings").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));

    }
}
