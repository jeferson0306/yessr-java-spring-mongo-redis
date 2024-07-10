FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY . /app
WORKDIR /app
RUN chmod +x ./mvnw
RUN ./mvnw clean package
ENTRYPOINT ["java", "-jar", "/app/target/yessr-1.0.0.jar"]
