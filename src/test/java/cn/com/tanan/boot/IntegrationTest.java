package cn.com.tanan.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.net.URL;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class IntegrationTest {
  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
      this.base = new URL("http://localhost:" + port + "/");
  }

  @Test
  public void testGreetingsText() throws Exception {
      ResponseEntity<String> response = template.getForEntity(base.toString() + "json/greetings",
              String.class);
      assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
  }

  @Value("${local.management.port}")
  private int mgtPort;

  @Test
  public void testActuatorInfo200() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.template.getForEntity(
        "http://localhost:" + this.mgtPort + "/actuator/info", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}
