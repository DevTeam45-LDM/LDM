package com.devteam45ldm.ldm.views.ApiTest.Tags;

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
@PageTitle("Tags")
//@Route("api-test/tags")
// @Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class Tags extends Composite<VerticalLayout> {

    private final TextField urlField;
    private final PasswordField apiKeyField;
    private final Grid<Tag> responseGrid;
    private final TextField editField = new TextField();
    private final MenuBar editMenuBar = new MenuBar();
    private Button editButton;
    private Tag selectedTag;


    /**
     * Constructs the eLabApiTest view.
     * Initializes the UI components and layout.
     */
    public Tags() {
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
        menuBar.addItem("Tags lesen", event -> readTags());
        menuBar.getStyle().set("margin-bottom", "100px");

        // Grid for displaying tags
        responseGrid = new Grid<>(Tag.class);
        responseGrid.setColumns("id", "tag", "itemCount", "isFavorite");
        responseGrid.setWidth("100%");
        responseGrid.getStyle().set("flex-grow", "0");
        responseGrid.getStyle().set("margin-bottom", "20px");

        responseGrid.addSelectionListener(event -> {
            selectedTag = event.getFirstSelectedItem().orElse(null);
        });

        editButton = new Button("Eintrag bearbeiten", event -> {
            if (selectedTag != null) {
                editButton.setVisible(false);
                editField.setValue(selectedTag.getTag());
                editField.setVisible(true);
                editMenuBar.setVisible(true);
            } else {
                Notification.show("Bitte wählen Sie einen Eintrag aus.");
            }
        });


        editField.setVisible(false);

        editMenuBar.setVisible(false);
        editMenuBar.addItem("Speichern", event -> saveTag());
        editMenuBar.addItem("Abbrechen", event -> cancelTag());

        HorizontalLayout editLayout = new HorizontalLayout(editField, editMenuBar);
        editLayout.setWidthFull();
        editLayout.setSpacing(true);

        // Initialize ComboBox for experiments
        ComboBox<String> experimentsComboBox = new ComboBox<>("Experimente");
        experimentsComboBox.setWidthFull();
        experimentsComboBox.getStyle().set("margin-bottom", "50px");

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, responseGrid, editButton, editLayout);
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
        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection() || checkURL.getStatusCode().value() == 401) {
            Notification.show("API is reachable.");
        } else {
            Notification.show("API is not reachable: " + checkURL.toString());
        }
    }

    /**
     * Reads tags from the API using the provided API key and URL.
     * Sets the retrieved tags to the grid.
     */
    private void readTags() {
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
            List<Tag> apiResponse = callApi(apiKey, url);
            responseGrid.setItems(apiResponse);
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage());
        }
    }

    /**
     * Calls the external API to retrieve tags.
     *
     * @param apiKey the API key
     * @param url the URL
     * @return a list of tags
     */
    private List<Tag> callApi(String apiKey, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        if (!url.endsWith("/api/v2")) {
            url = url.endsWith("/") ? url + "api/v2" : url + "/api/v2";
        }

        // Set up the API client
        ApiClient client = new ApiClient();
        ConfigApi api = new ConfigApi(client);
        client.setBasePath(url);

        // Configure API key authorization: token
        ApiKeyAuth token = (ApiKeyAuth) client.getAuthentication("token");
        token.setApiKey(apiKey);

        // Create an instance of the TeamTagsApi
        TeamTagsApi apiInstance = new TeamTagsApi(client);

        // Get the tags for the team with id=5
        return apiInstance.readTeamTags(5);
    }

    private void saveTag() {
        //TODO Implement save logic here
        resetEditComponents();
        readTags();
    }

    private void cancelTag() {
        resetEditComponents();
    }

    private void resetEditComponents() {
        responseGrid.deselectAll();
        editField.setVisible(false);
        editMenuBar.setVisible(false);
        editButton.setVisible(true);
    }
}