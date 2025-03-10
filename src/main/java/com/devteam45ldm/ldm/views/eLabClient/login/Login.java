package com.devteam45ldm.ldm.views.eLabClient.login;

import com.devteam45ldm.ldm.controller.HTTPController;
import com.devteam45ldm.ldm.api.eLabClient.ELabClient;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.annotation.UIScope;
import io.swagger.client.api.InfoApi;
import io.swagger.client.model.Info;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the login view for the eLabClient.
 * It provides UI components for entering the URL and API key,
 * and handles login, logout, and connection testing.
 */
@PageTitle("Login")
@UIScope
public class Login extends Composite<VerticalLayout> {

    private final TextField urlField;
    private final PasswordField apiKeyField;
    private final MenuBar menuBar = new MenuBar();
    private final ELabClient<InfoApi> eLabClient = new ELabClient<>(InfoApi.class);
    private final List<LoginEventListener> listeners = new ArrayList<>();

    /**
     * Constructs the Login view and initializes the UI components.
     */
    public Login() {
        // Erste Zeile: URL und Test-Button
        urlField = new TextField("URL");

        HorizontalLayout firstRow = new HorizontalLayout(urlField);
        firstRow.setWidthFull();
        firstRow.setSpacing(true);

        // Zweite Zeile: API-Key und Read Tags Button
        apiKeyField = new PasswordField("API Key");

        HorizontalLayout secondRow = new HorizontalLayout(apiKeyField);
        secondRow.setWidthFull();
        secondRow.setSpacing(true);
        secondRow.getStyle().set("margin-bottom", "20px");

        // Create the MenuBar
        menuBar.setWidth("min-content");
        // Add menu items
        menuBar.addItem("Connection Test", event -> {
            try {
                testUrl();
            } catch (IOException e) {
                Notification.show("Error: " + e.getMessage());
            }
        });
        menuBar.addItem("Login", event -> getInfo());
        menuBar.addItem("Logout", event -> deleteLogin());
        menuBar.getItems().get(2).setEnabled(false);
        menuBar.getStyle().set("margin-bottom", "80px");

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar);
    }

    /**
     * Tests the provided URL to check if the eLab is reachable.
     *
     * @throws IOException if an I/O error occurs
     */
    private void testUrl() throws IOException {
        String url = urlField.getValue();
        if (url == null || url.isEmpty()) {
            Notification.show("Please enter a URL.");
            return;
        }

        if (!url.endsWith("/api/v2/info")) {
            url = url.endsWith("/") ? url + "api/v2/info" : url + "/api/v2/info";
        }

        HTTPController httpController = new HTTPController();
        ResponseEntity<String> checkURL = httpController.checkURL(url);
        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection() || checkURL.getStatusCode().value() == 401) {
            Notification.show("eLab is reachable");
        } else {
            Notification.show("eLab is unreachable: " + checkURL);
        }
    }

    /**
     * Retrieves information from the eLab using the provided API key and URL.
     */
    private void getInfo() {
        String apiKey = apiKeyField.getValue();
        String url = urlField.getValue();

        if ((apiKey == null || apiKey.isEmpty()) && (url == null || url.isEmpty())) {
            Notification.show("Please enter a URL and an API key.");
            return;
        }
        if (apiKey == null || apiKey.isEmpty()) {
            Notification.show("Please enter an API key.");
            return;
        }
        if (url == null || url.isEmpty()) {
            Notification.show("Please enter a URL.");
            return;
        }

        try {
            Info info = eLabClient.getClient(apiKey, url).getInfo();
            String version = (info != null && info.getElabftwVersion() != null && !info.getElabftwVersion().isEmpty()) ? info.getElabftwVersion() : "unbekannt";
            Notification.show("Login successfully. eLab-version: " + version);
            menuBar.getItems().get(1).setEnabled(false);
            menuBar.getItems().get(2).setEnabled(true);
            fireLoginEvent();
        } catch (Exception e) {
            Notification.show("Error during login: " + e.getMessage());
        }
    }

    /**
     * Clears the login fields and resets the menu bar.
     */
    private void deleteLogin() {
        urlField.clear();
        apiKeyField.clear();
        menuBar.getItems().get(1).setEnabled(true);
        menuBar.getItems().get(2).setEnabled(false);
        fireLoginEvent();
    }

    /**
     * Adds a login event listener.
     *
     * @param listener the listener to add
     */
    public void addLoginEventListener(LoginEventListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes a login event listener.
     *
     * @param listener the listener to remove
     */
    public void removeLoginEventListener(LoginEventListener listener) {
        listeners.remove(listener);
    }

    /**
     * Fires a login event to all registered listeners.
     */
    private void fireLoginEvent() {
        String url = urlField.getValue();
        String apiKey = apiKeyField.getValue();
        LoginEvent event = new LoginEvent(this, url, apiKey);
        for (LoginEventListener listener : listeners) {
            listener.onLogin(event);
        }
    }
}