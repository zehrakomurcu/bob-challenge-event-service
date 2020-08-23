FROM openjdk:8-jre-alpine
COPY target/ .
CMD ["java" ,"-Xms600m" ,"-Xmx600m", "-jar", "eventService-0.0.1-SNAPSHOT.jar"]
