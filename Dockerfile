FROM eclipse-temurin:21-jre

#USER 0
RUN mkdir -p /config
#USER $CONTAINER_USER_ID

ARG MONGO_INITDB_ROOT_USERNAME
ARG MONGO_INITDB_ROOT_PASSWORD

COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
