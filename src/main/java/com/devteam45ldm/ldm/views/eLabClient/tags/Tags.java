package com.devteam45ldm.ldm.views.eLabClient.tags;

import com.devteam45ldm.ldm.api.eLabClient.ELabController;
import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
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

import io.swagger.client.api.*;
import io.swagger.client.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.List;


/**
 * The Tags class represents a Vaadin view for testing the eLab API.
 * It allows users to enter a URL and API key, test the URL, and read tags from the API.
 */
@PageTitle("Tags")
@UIScope
public class Tags extends Composite<VerticalLayout> implements CredentialsAware {

    private final TextField urlField;
    private final PasswordField apiKeyField;
    private final Grid<Tag> responseGrid;
    private final TextField editField = new TextField();
    private final MenuBar editMenuBar = new MenuBar();
    private final MenuBar tagsMenuBar;
    private Tag selectedTag;
    private final ELabController apiInstance = new ELabController();


    /**
     * Constructs the Tags view.
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
        menuBar.addItem("Connection Test", event -> {
            try {
                testUrl();
            } catch (IOException e) {
                Notification.show("Error: " + e.getMessage());
            }
        });
        menuBar.addItem("Read Tags", event -> readTags());
        menuBar.getStyle().set("margin-bottom", "80px");

        // Grid for displaying tags
        responseGrid = new Grid<>(Tag.class);
        responseGrid.setColumns("id", "tag", "itemCount", "isFavorite");
        responseGrid.setWidth("100%");
        responseGrid.getStyle().set("flex-grow", "0");
        responseGrid.getStyle().set("margin-bottom", "20px");
        responseGrid.setVisible(false);

        responseGrid.addSelectionListener(event -> selectedTag = event.getFirstSelectedItem().orElse(null));

        editField.setVisible(false);
        editMenuBar.setVisible(false);

        HorizontalLayout editLayout = new HorizontalLayout(editField, editMenuBar);
        editLayout.setWidthFull();
        editLayout.setSpacing(true);

        tagsMenuBar = new MenuBar();
        tagsMenuBar.addItem("Create", event -> loadCreator());
        tagsMenuBar.addItem("Modify", event -> loadModifier());
        tagsMenuBar.addItem("Delete", event -> loadDeleter());
        tagsMenuBar.setVisible(false);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, responseGrid, tagsMenuBar, editLayout);
    }

    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKeyField.setValue(apiKey);
        this.apiKeyField.setReadOnly(apiKey!=null && !(apiKey.isEmpty()));
        this.urlField.setValue(url);
        this.urlField.setReadOnly(url!=null && !(url.isEmpty()));
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
            Notification.show("eLab is reachable.");
            Notification.show("eLab is unreachable: " + checkURL);
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
            Notification.show("Please enter an API key and a URL.");
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
            List<Tag> apiResponse = callApiGet();
            responseGrid.setItems(apiResponse);
            responseGrid.setVisible(true);
            tagsMenuBar.setVisible(true);
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage());
        }
    }


    /**
     * Loads the tag creation UI components.
     */
    private void loadCreator() {
        editMenuBar.removeAll();
        editMenuBar.addItem("Create", event -> createTag());
        editMenuBar.addItem("Cancel", event -> cancelTag());
        editField.setVisible(true);
        editMenuBar.setVisible(true);
        tagsMenuBar.setVisible(false);
    }

    /**
     * Loads the tag modification UI components.
     */
    private void loadModifier() {
        if(selectedTag != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Save", event -> saveChanges());
            editMenuBar.addItem("Cancel", event -> cancelTag());
            editField.setVisible(true);
            editMenuBar.setVisible(true);
            tagsMenuBar.setVisible(false);
        }
        else {
            Notification.show("Please select a tag.");
        }
    }

    /**
     * Loads the tag deletion UI components.
     */
    private void loadDeleter() {
        if(selectedTag != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Delete", event -> deleteTag());
            editMenuBar.addItem("Cancel", event -> cancelTag());
            editMenuBar.setVisible(true);
            tagsMenuBar.setVisible(false);
        }
        else {
            Notification.show("Please select a tag.");
        }
    }

    /**
     * Calls the external API to retrieve tags.
     *
     * @return a list of tags
     */
    private List<Tag> callApiGet() {
        // Create an instance of the TeamTagsApi
        TeamTagsApi client = apiInstance.getTeamTagsClient(apiKeyField.getValue(), urlField.getValue());

        // Get the tags for the team with id=5
        return client.readTeamTags(5);
    }

    /**
     * Calls the external API to create a new tag.
     *
     * @param tag the tag to create
     * @return true if the tag was created successfully, false otherwise
     */
    private boolean callApiPost(String tag) {
        // Create an instance of the TeamTagsApi
        TeamTagsApi client = apiInstance.getTeamTagsClient(apiKeyField.getValue(), urlField.getValue());

        // Create a tag for the team with id=5
        try {
            client.postTeamTag(5, new TagsBody().tag(tag));
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

    /**
     * Creates a new tag using the value from the edit field.
     */
    private void createTag(){
        boolean result = callApiPost(editField.getValue());
        if (result) {
            Notification.show("Tag created successfully.");
        } else {
            Notification.show("Error: Could not create tag.");
        }

        resetEditComponents();
        readTags();
    }

    /**
     * Calls the external API to update an existing tag.
     *
     * @param tag the new tag value
     * @param id the ID of the tag to update
     * @return true if the tag was updated successfully, false otherwise
     */
    private void callApiPatch(String tag, Integer id) {
        try {
            TeamTagsApi client = apiInstance.getTeamTagsClient(apiKeyField.getValue(), urlField.getValue());
            client.patchTags(id, new Tag().tag(tag));
            Notification.show("Changes saved successfully.");
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage() + " " + e.getClass());
        }
    }

/*
    Der Fehler wird ursprünglich von HttpComponentsClientHttpRequestFactory geworfen und in der Methode createResourceAccessException von RestTemplate aufgefangen.
    Dort wird der Fehler in eine RessourceAccessException umgewandelt und aufgrund der fehlenden Fehlerbehandlung propagiert.
    Die Methode patchTeamTagWithHttpInfo von TeamTagsApi macht dann daraus eine RestClientException.
    Daher, wie auch der mitmproxy zeigt, wird keine PATCH-Anfrage an den Server gesendet.
*/

    /**
     * Saves changes to the selected tag using the value from the edit field.
     */
    private void saveChanges() {
        callApiPatch(editField.getValue(), selectedTag.getId());
        resetEditComponents();
        readTags();
    }

    /**
     * Calls the external API to delete an existing tag.
     *
     * @param id the ID of the tag to delete
     * @return true if the tag was deleted successfully, false otherwise
     */
    private boolean callApiDelete(Integer id) {
        // Create an instance of the TeamTagsApi
        TeamTagsApi client = apiInstance.getTeamTagsClient(apiKeyField.getValue(), urlField.getValue());

        // Create a tag for the team with id=5
        try {
            client.deleteTeamTag(5, id);
            return true;
        } catch (RestClientException e) {
            Notification.show("Error: " + e.getMessage()); //DEBUG
            return false;
        }
    }

    /**
     * Deletes the selected tag.
     */
    private void deleteTag() {
        boolean result = callApiDelete(selectedTag.getId());
        if (result) {
            Notification.show("Tag successfully deleted.");
        } else {
            Notification.show("No permission to delete tags: Contact eLab Admin.");
        }

        resetEditComponents();
        readTags();
    }

    /**
     * Cancels the current tag operation and resets the UI components.
     */
    private void cancelTag() {
        resetEditComponents();
    }

    /**
     * Resets the edit components to their default state.
     */
    private void resetEditComponents() {
        responseGrid.deselectAll();
        editField.setVisible(false);
        editMenuBar.setVisible(false);
        tagsMenuBar.setVisible(true);
    }
}