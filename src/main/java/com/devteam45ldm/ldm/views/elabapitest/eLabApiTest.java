package com.devteam45ldm.ldm.views.elabapitest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
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
import java.util.ArrayList;
import java.util.List;


@PageTitle("eLab API Test")
@Route("elab-api-test")
@Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class eLabApiTest extends Div {

    private final TextField urlField;
    private final Button testButton;
    private final PasswordField apiKeyField;
    private final Button readTagsButton;
    private final Grid<Tag> responseGrid;


    public eLabApiTest() {
        // Erste Zeile: URL und Test-Button
        urlField = new TextField("URL");
        testButton = new Button("Test");

        testButton.addClickListener(event -> {
            try {
                testUrl();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        HorizontalLayout firstRow = new HorizontalLayout(urlField, testButton);
        firstRow.setWidthFull();
        firstRow.setSpacing(true);

        // Zweite Zeile: API-Key und Read Tags Button
        apiKeyField = new PasswordField("API Key");
        readTagsButton = new Button("Read Tags");

        readTagsButton.addClickListener(event -> readTags());

        HorizontalLayout secondRow = new HorizontalLayout(apiKeyField, readTagsButton);
        secondRow.setWidthFull();
        secondRow.setSpacing(true);

        // Grid for displaying tags
        responseGrid = new Grid<>(Tag.class);
        responseGrid.setHeightFull();
        responseGrid.setColumns("id", "tag", "itemCount", "isFavorite"); // Update with actual fields of Tag
        responseGrid.setItems(List.of(new Tag().id(1).tag("Sample Tag").itemCount(10).isFavorite(1)));

        VerticalLayout mainLayout = new VerticalLayout(firstRow, secondRow, responseGrid);
        mainLayout.setSizeFull();
        add(mainLayout);
    }

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
            List<Tag> apiResponse = callExternalApi(apiKey, url);
            responseGrid.setItems(apiResponse);
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage());
        }
    }

    private List<Tag> callExternalApi(String apiKey, String url) {
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
}