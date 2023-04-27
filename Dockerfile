FROM openjdk:17.0.7-jdk-oraclelinux8
COPY target/j-0.0.1-SNAPSHOT.jar /usr/src/backendAP/

WORKDIR /usr/src/backendAP

EXPOSE 8080
CMD ["java", "-jar", "j-0.0.1-SNAPSHOT.jar"]