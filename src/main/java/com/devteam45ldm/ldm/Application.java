package com.devteam45ldm.ldm;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.context.annotation.Bean;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@PWA(name = "LaborDatenManager", shortName = "LDM")
@Theme(value = "ldm")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        //System.setProperty("https.protocols", "TLSv1.3");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.3");
        System.setProperty("javax.net.debug", "ssl:handshake:verbose");
        System.setProperty("javax.net.ssl.trustStore", "/opt/java/openjdk/lib/security/cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        SpringApplication.run(Application.class, args);
    }
}