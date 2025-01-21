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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@PageTitle("eLab API Test")
@Route("elab-api-test")
@Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class eLabApiTest extends Div {
    private static final Logger logger = LoggerFactory.getLogger(eLabApiTest.class);

    private TextField urlField;
    private Button testButton;
    private PasswordField apiKeyField;
    private Button readTagsButton;
    private Div jsonResponseDiv;


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

        // Dritte Zeile: JSON-Antwort
        jsonResponseDiv = new Div();
        jsonResponseDiv.getStyle().set("white-space", "pre-wrap");
        jsonResponseDiv.getStyle().set("overflow", "auto");
        jsonResponseDiv.setHeight("300px");
        jsonResponseDiv.setWidthFull();

        // Grid for displaying tags
        //responseGrid = new Grid<>(Tag.class);
        //responseGrid.setSizeFull();
        //responseGrid.setColumns("id", "tag", "itemCount"); // Update with actual fields of Tag

        VerticalLayout mainLayout = new VerticalLayout(firstRow, secondRow, jsonResponseDiv);
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
            InlineResponse2003 apiResponse = callExternalApi(apiKey, url);
            displayTags(apiResponse);
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage());
        }
    }

    private void displayTags(InlineResponse2003 apiResponse) {
        jsonResponseDiv.setText(apiResponse.toString());
    }

    private InlineResponse2003 callExternalApi(String apiKey, String url) {
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
        InlineResponse2003 response2003 = apiInstance.readTeamTags(5);
        logger.debug("API Response: {}", response2003.toString());
        return response2003;
    }
}