package com.devteam45ldm.ldm.views.ApiTest.Experiments;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

import com.devteam45ldm.ldm.controller.HTTPController;

import io.swagger.client.*;
import io.swagger.client.api.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;


/**
 * The eLabApiTest class represents a Vaadin view for testing the eLab API.
 * It allows users to enter a URL and API key, test the URL, and read tags from the API.
 */
@PageTitle("Experiments")
//@Route("api-test/experiments")
//@Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class Experiments extends Composite<VerticalLayout> {

    private final TextField urlField;
    private final PasswordField apiKeyField;

    /**
     * Constructs the eLabApiTest view.
     * Initializes the UI components and layout.
     */
    public Experiments() {
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
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth("min-content");

        // Add menu items
        menuBar.addItem("Verbindungstest", event -> {
            try {
                testUrl();
            } catch (IOException e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        menuBar.addItem("Experimente lesen", event -> readExperiments());
        menuBar.getStyle().set("margin-bottom", "50px");

        // Initialize ComboBox for experiments
        ComboBox<String> experimentsComboBox = new ComboBox<>("Experimente");
        experimentsComboBox.setWidthFull();
        experimentsComboBox.getStyle().set("margin-bottom", "50px");

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, experimentsComboBox);
    }

    /**
     * Tests the URL entered by the user.
     * Checks if the URL is reachable and shows a notification with the result.
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
        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection()) {
            Notification.show("API is reachable.");
        } else {
            Notification.show("API is not reachable: " + checkURL.toString());
        }
    }


    private void readExperiments() {
        String apiKey = apiKeyField.getValue();
        String url = urlField.getValue();
        if (apiKey == null || apiKey.isEmpty()) {
            Notification.show("Please enter an API key.");
            return;
        }
        if (url == null || url.isEmpty()) {
            Notification.show("Please enter a URL.");
            return;
        }

        try {
            List<ExperimentTemplate> experiments = callExperimentsApi(apiKey, url);
            // Assuming you have a grid or other UI component to display experiments
            // responseGrid.setItems(experiments);
            System.out.println("break point : ");
            System.out.println(experiments);
            Notification.show("Experiments fetched successfully.");
        } catch (Exception e) {
            System.out.println("break point 2 : ");
            System.out.println(e.getMessage());
            Notification.show("Error: " + e.getMessage());
        }
    }

    private List<ExperimentTemplate> callExperimentsApi(String apiKey, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        if (!url.endsWith("/api/v2")) {
            url = url.endsWith("/") ? url + "api/v2" : url + "/api/v2";
        }

        // Set up the API client
        ApiClient client = new ApiClient();
        client.setBasePath(url);

        // Configure API key authorization: token
        ApiKeyAuth token = (ApiKeyAuth) client.getAuthentication("token");
        token.setApiKey(apiKey);
        client.addDefaultHeader("Authorization" ,token.getApiKey());

        // Create an instance of the ExperimentsApi
        ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi(client);
        // Fetch experiments
        return apiInstance.readExperimentsTemplates();
    }
}