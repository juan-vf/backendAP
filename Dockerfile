FROM openjdk:19.0.1

COPY target/j-0.0.1-SNAPSHOT.jar /usr/src/backendAP/

WORKDIR /usr/src/backendAP

EXPOSE 8080
CMD ["java", "-jar", "j-0.0.1-SNAPSHOT.jar"]