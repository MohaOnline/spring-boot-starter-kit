// Spring Cli Command examples：

/* 根据 groovy 启动 Spring Boot 环境
spring run hello.groovy
*/

/* 指定侦听端口
spring run hello.groovy  -- --server.port=9000
*/

/* Turn JVM on Windows
set "JAVA_OPTS=-Xms256m -Xmx2048m"
spring run hello.groovy
 */ 
// spring run hello.groovy  -- --server.port=9000 # 指定侦听端口
@RestController
class ThisWillActuallyRun {

    @RequestMapping("/")
    String home() {
        "Greetings from Groovy!"
    }

}
