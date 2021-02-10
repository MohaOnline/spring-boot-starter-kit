package cn.com.tanan.boot;

import cn.com.tanan.boot.controller.RawController;
import cn.com.tanan.boot.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* 测试用例需要定义数据库 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) /* 提供完整的 application context */
@AutoConfigureMockMvc
public class RawControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private RawController controller;

  @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

  @Autowired
  private MockMvc mvc;    /* 模拟 HTTP requests，通过 SpringBootTest、AutoConfigureMockMvc 注入 MockMvc 实例 */
  /* Web 层测试 */

  @Test
  public void testRawHelloText() throws Exception {
    mvc.perform(get("/raw/hello"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, World")));
  }


  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void testRawHelloJson200() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
        "http://localhost:" + this.port + "/raw/hello-json", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @MockBean
  private GreetingService service;

  /** @see GreetingService#greet() */
  @Test
  public void testRawHelloServiceText() throws Exception {
    // 用 Mockito 临时设置方法返回
    when(service.greet()).thenReturn("Hello, Mock");

    mvc.perform(get("/raw/hello-service")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, Mock")));

    // GreetingService#greet() 只被调用一次
    verify(service, times(1)).greet();

  }

}
