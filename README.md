# Spring Boot Starter Kit Guide
使开发 Spring Boot 更容易。

``` bash
# 编译项目
mvn compile

# 打包项目
mvn package

# 确认项目依赖
mvn dependency:tree

# 运行项目
mvn spring-boot:run
mvn clean spring-boot:run    # 确保最新代码启用

./mvnw spring-boot:run

# 运行测试
mvn test

# 分析 jar 内容
jar tvf target/spring-boot-starter-kit-0.0.1-SNAPSHOT.jar

# 运行 jar 包
java -jar target/spring-boot-starter-kit-0.0.1-SNAPSHOT.jar
# 访问 http://localhost:8080/hello 观察内容
```

