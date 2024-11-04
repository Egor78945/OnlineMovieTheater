FROM openjdk:17

COPY build/libs/service-discovery-0.0.1-SNAPSHOT.jar app.jar

EXPOSE ${SERVICE_DISCOVERY_SERVER_PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]