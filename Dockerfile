FROM adoptopenjdk/openjdk16:jdk-16.0.1_9-alpine-slim

# Set the working directory
RUN mkdir /app
WORKDIR /app
COPY target/j-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "target/j-0.0.1-SNAPSHOT.jar"]