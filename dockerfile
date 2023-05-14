FROM openjdk:17-jdk-slim
WORKDIR /app
COPY application/target/facts-api.jar /app/facts-api.jar
EXPOSE 81
ENTRYPOINT ["java", "-jar", "/app/facts-api.jar"]
