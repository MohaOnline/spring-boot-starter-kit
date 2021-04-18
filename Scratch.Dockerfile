# docker build -t spring-boot-starter-kit:0.0.1-SNAPSHOT .

FROM maven:3.6.3-openjdk-11-slim as BUILDER
ARG JAR_FILE=spring-boot-starter-kit-0.0.1-SNAPSHOT.jar
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package
COPY target/${JAR_FILE} target/application.jar

FROM openjdk:11.0.8-jre-slim
EXPOSE 8088
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
ENTRYPOINT ["java","-jar","/app/application.jar"]
