FROM openjdk:11.0-jre-slim

EXPOSE 8088
ARG JAR_FILE=spring-boot-starter-kit-0.0.1-SNAPSHOT.jar

ADD target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
