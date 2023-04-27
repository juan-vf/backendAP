FROM adoptopenjdk/openjdk16:jdk-16.0.1_9-alpine-slim

# Set the working directory
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .
COPY target/j-0.0.1-SNAPSHOT.jar j-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "target/j-0.0.1-SNAPSHOT.jar"]