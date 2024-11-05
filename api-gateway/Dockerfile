FROM openjdk:17

COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar app.jar

EXPOSE ${API_GATEWAY_SERVER_PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]