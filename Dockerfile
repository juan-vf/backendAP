FROM openjdk:19
MAINTAINER devj
COPY target/j-0.0.1-SNAPSHOT.jar devj-app.jar
ENTRYPOINT ["java", "jar", "/devj-app.jar"]