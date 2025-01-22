package com.devteam45ldm.ldm.views.ApiTest.Tags;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.annotation.UIScope;

import com.devteam45ldm.ldm.controller.HTTPController;

import io.swagger.client.*;
import io.swagger.client.api.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

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
    private TeamTagsApi apiClient;
    private MenuBar tagsMenuBar;
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
        menuBar.getStyle().set("margin-bottom", "80px");

        // Grid for displaying tags
        responseGrid = new Grid<>(Tag.class);
        responseGrid.setColumns("id", "tag", "itemCount", "isFavorite");
        responseGrid.setWidth("100%");
        responseGrid.getStyle().set("flex-grow", "0");
        responseGrid.getStyle().set("margin-bottom", "20px");
        responseGrid.setVisible(false);

        responseGrid.addSelectionListener(event -> {
            selectedTag = event.getFirstSelectedItem().orElse(null);
        });

        editField.setVisible(false);
        editMenuBar.setVisible(false);

        HorizontalLayout editLayout = new HorizontalLayout(editField, editMenuBar);
        editLayout.setWidthFull();
        editLayout.setSpacing(true);

        tagsMenuBar = new MenuBar();
        tagsMenuBar.addItem("Tag erstellen", event -> loadCreator());
        tagsMenuBar.addItem("Tag bearbeiten", event -> loadModifier());
        tagsMenuBar.addItem("Tag löschen", event -> loadDeleter());
        tagsMenuBar.setVisible(false);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, responseGrid, tagsMenuBar, editLayout);
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
            Notification.show("Bitte geben Sie eine URL ein.");
            return;
        }

        if (!url.endsWith("/api/v2/info")) {
            url = url.endsWith("/") ? url + "api/v2/info" : url + "/api/v2/info";
        }

        HTTPController httpController = new HTTPController();
        ResponseEntity<String> checkURL = httpController.checkURL(url);
        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection() || checkURL.getStatusCode().value() == 401) {
            Notification.show("API ist erreichtbar.");
        } else {
            Notification.show("API ist nicht erreichbar: " + checkURL.toString());
        }
    }

    /**
     * Reads tags from the API using the provided API key and URL.
     * Sets the retrieved tags to the grid.
     */
    private void readTags() {
        String apiKey = apiKeyField.getValue();
        String url = urlField.getValue();

        if ((apiKey == null || apiKey.isEmpty()) && (url == null || url.isEmpty())) {
            Notification.show("Bitte geben Sie einen API-Schlüssel und eine URL ein.");
            return;
        }
        if (apiKey == null || apiKey.isEmpty()) {
            Notification.show("Bitte geben Sie einen API-Schlüssel ein.");
            return;
        }
        if (url == null || url.isEmpty()) {
            Notification.show("Bitte geben Sie eine URL ein.");
            return;
        }

        try {
            List<Tag> apiResponse = callApiGet();
            responseGrid.setItems(apiResponse);
            responseGrid.setVisible(true);
            tagsMenuBar.setVisible(true);
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage());
        }
    }


    private void loadCreator() {
        editMenuBar.removeAll();
        editMenuBar.addItem("Erstellen", event -> createTag());
        editMenuBar.addItem("Abbrechen", event -> cancelTag());
        editField.setVisible(true);
        editMenuBar.setVisible(true);
        tagsMenuBar.setVisible(false);
    }

    private void loadModifier() {
        if(selectedTag != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Speichern", event -> saveTag());
            editMenuBar.addItem("Abbrechen", event -> cancelTag());
            editField.setVisible(true);
            editMenuBar.setVisible(true);
            tagsMenuBar.setVisible(false);
        }
        else {
            Notification.show("Bitte wählen Sie einen Tag aus.");
        }
    }

    private void loadDeleter() {
        if(selectedTag != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Löschen", event -> deleteTag());
            editMenuBar.addItem("Abbrechen", event -> cancelTag());
            editMenuBar.setVisible(true);
            tagsMenuBar.setVisible(false);
        }
        else {
            Notification.show("Bitte wählen Sie einen Tag aus.");
        }
    }

    private TeamTagsApi createClient(String apiKey , String url) {
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
        return new TeamTagsApi(client);
    }

    private TeamTagsApi getClient(){
        String apiKey = apiKeyField.getValue();
        String url = urlField.getValue();
        if(apiClient == null){
            apiClient = createClient(apiKey, url);
        }
        else if(!apiClient.getApiClient().getBasePath().equals(urlField.getValue()) || !((ApiKeyAuth) apiClient.getApiClient().getAuthentication("token")).getApiKey().equals(apiKeyField.getValue())){
            apiClient = createClient(apiKey, url);
        }
        return apiClient;
    }


    /**
     * Calls the external API to retrieve tags.
     *
     * @return a list of tags
     */
    private List<Tag> callApiGet() {
        // Create an instance of the TeamTagsApi
        TeamTagsApi apiInstance = getClient();

        // Get the tags for the team with id=5
        return apiInstance.readTeamTags(5);
    }

    private boolean callApiPost(String tag) {
        // Create an instance of the TeamTagsApi
        TeamTagsApi apiInstance = getClient();

        // Create a tag for the team with id=5
        try {
            apiInstance.postTeamTag(5, new IdTagsBody().tag(tag));
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

    private void createTag(){
        boolean result = callApiPost(editField.getValue());
        if (result) {
            Notification.show("Tag erfolgreich erstellt.");
        } else {
            Notification.show("Fehler beim Erstellen des Tags.");
        }

        resetEditComponents();
        readTags();
    }

    private boolean callApiPost(String tag, Integer id) {
        // Create an instance of the TeamTagsApi
        TeamTagsApi apiInstance = getClient();

        // Update a tag for the team with id=5
        try {
            apiInstance.patchTeamTag(5, selectedTag.getId(), new TagsSubidBody().tag(tag));
            return true;
        } catch (RestClientException e) {
            Notification.show("Error: " + e.getMessage());
            return false;
        }
    }

    private void saveTag() {
        boolean result = callApiPost(editField.getValue(), selectedTag.getId());
        if (result) {
            Notification.show("Änderungen erfolgreich gespeichert.");
        } else {
            Notification.show("Fehler beim Speichern der Änderungen.");
        }

        resetEditComponents();
        readTags();
    }

    private boolean callApiPost(Integer id) {
        // Create an instance of the TeamTagsApi
        TeamTagsApi apiInstance = getClient();

        // Create a tag for the team with id=5
        try {
            apiInstance.deleteTeamTag(5, id);
            return true;
        } catch (RestClientException e) {
            //Notification.show("Error: " + e.getMessage()); //DEBUG
            return false;
        }
    }

    private void deleteTag() {
        boolean result = callApiPost(selectedTag.getId());
        if (result) {
            Notification.show("Tag erfolgreich gelöscht.");
        } else {
            Notification.show("Keine Berechtigung Tags zu Löschen: eLab Admin kontaktieren.");
        }

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
        tagsMenuBar.setVisible(true);
    }
}