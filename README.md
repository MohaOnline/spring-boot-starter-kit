
``` bash
# 编译项目
mvn package

# 确认项目依赖
mvn dependency:tree

# 运行项目
mvn spring-boot:run

# 分析 jar 内容
jar tvf target/spring-boot-starter-kit-0.0.1-SNAPSHOT.jar

# 运行 jar 包
java -jar target/spring-boot-starter-kit-0.0.1-SNAPSHOT.jar
# 访问 http://localhost:8080/hello 观察内容
```

