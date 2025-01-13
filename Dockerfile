# Base image
FROM eclipse-temurin:21-jre
LABEL org.opencontainers.image.authors="devteam45.ldm@gmail.com"

# Create config directory
RUN mkdir -p /config

# Copy the trust-cert installation script
COPY docker/install_trust_certs.sh /usr/local/bin/install_trust_certs.sh
RUN chmod +x /usr/local/bin/install_trust_certs.sh

# MongoDB
ARG MONGO_HOST
ARG MONGO_PORT
ARG MONGO_INITDB_DATABASE
ARG MONGO_INITDB_ROOT_USERNAME
ARG MONGO_INITDB_ROOT_PASSWORD

# Hashicorp Vault
ARG VAULT_HOST
ARG VAULT_PORT
ARG VAULT_TOKEN

# Copy application JAR
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the trust-cert script on container start and then start the Java application
ENTRYPOINT ["/bin/bash", "-c", "/usr/local/bin/install_trust_certs.sh && java -Djavax.net.ssl.trustStore=/opt/java/openjdk/lib/security/cacerts -Djavax.net.ssl.trustStorePassword=changeit -jar /app.jar"]
