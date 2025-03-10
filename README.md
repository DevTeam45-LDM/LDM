# LDM

This project can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/ldm-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `src/main/frontend` contains the client-side JavaScript views of your application.
- `themes` folder in `src/main/frontend` contains the custom CSS styles.

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorial at [vaadin.com/docs/latest/tutorial/overview](https://vaadin.com/docs/latest/tutorial/overview).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/docs/latest/components](https://vaadin.com/docs/latest/components).
- View use case applications that demonstrate Vaadin capabilities at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Build any UI without custom CSS by discovering Vaadin's set of [CSS utility classes](https://vaadin.com/docs/styling/lumo/utility-classes). 
- Find a collection of solutions to common use cases at [cookbook.vaadin.com](https://cookbook.vaadin.com/).
- Find add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Forum](https://vaadin.com/forum).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin).


## Deploying using Docker

To build the Dockerized version of the project, run

```
mvn clean package -Pproduction
docker build . -t ldm:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 ldm:latest
```

Using docker compose, you can build and run the project using the following command:
```
mvn clean package -Pproduction
docker compose up -d --build
```

## Debug
### HTTP and HTTPS traffic
You can run a man-in-the-middle proxy for debugging purposes:
1. customize entrypoint in dockerfile
```
ENTRYPOINT ["/bin/bash", "-c", "/usr/local/bin/install_trust_certs.sh && java -Dhttp.proxyHost=host.docker.internal -Dhttp.proxyPort=8088 -Dhttps.proxyHost=host.docker.internal -Dhttps.proxyPort=8088 -jar /app.jar"]
```
2. start mitmproxy
```
docker run --rm -it -d -p 8088:8088 -p 127.0.0.1:8081:8081 mitmproxy/mitmproxy mitmweb --web-host 0.0.0.0
```
If you want to reuse the certs, try volume mounting:
```
docker run --rm -it -d -p 8088:8088 -p 127.0.0.1:8081:8081 -v /path/to/local/directory:/home/mitmproxy mitmproxy/mitmproxy mitmweb --web-host 0.0.0.0
```

4. copy the certificate from the Docker container ```/home/mitmproxy/.mitmproxy/mitmproxy-ca-cert.cer``` to the project folder ldm ```config/core/mitmproxy-ca-cert.cer```.
5. command 
```
mvn clean package -Pproduction
docker compose up -d --build
```
6. configure proxy
   - is accessible under http://localhost:8081
   - <img width="512" alt="Bildschirmfoto 2025-01-23 um 16 12 38" src="https://github.com/user-attachments/assets/ee292ca2-02eb-4860-b158-765ed97c0fb5" />

