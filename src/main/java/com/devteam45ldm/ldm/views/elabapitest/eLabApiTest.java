package com.devteam45ldm.ldm.views.elabapitest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.TagsApi;
import io.swagger.client.model.Tag;
import com.devteam45ldm.ldm.controller.PingController;

import java.util.List;

@PageTitle("eLab API Test")
@Route("elab-api-test")
@UIScope
public class eLabApiTest extends Div {

    private TextField urlField;
    private Button testButton;
    private PasswordField apiKeyField;
    private Button readTagsButton;
    private Div jsonResponseDiv;
    private Grid<Tag> responseGrid;

    public eLabApiTest() {
        // Erste Zeile: URL und Test-Button
        urlField = new TextField("URL");
        testButton = new Button("Test");

        testButton.addClickListener(event -> testUrl());

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
        responseGrid = new Grid<>(Tag.class);
        responseGrid.setSizeFull();
        responseGrid.setColumns("tag", "itemCount"); // Update with actual fields of Tag

        VerticalLayout mainLayout = new VerticalLayout(firstRow, secondRow, jsonResponseDiv, responseGrid);
        mainLayout.setSizeFull();
        add(mainLayout);
    }

    private void testUrl() {
        String url = urlField.getValue();
        if (url == null || url.isEmpty()) {
            Notification.show("Please enter a URL.");
            return;
        }

        PingController pingController = new PingController();
        if (pingController.pingELab(url).getStatusCode().is2xxSuccessful()){
            Notification.show("URL is reachable.");
        } else {
            Notification.show("URL is not reachable.");
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

    private List<Tag> callExternalApi(String apiKey, String url) throws ApiException {
        ApiClient client = new ApiClient();
        client.setBasePath(url);
        client.setApiKey(apiKey);

        TagsApi api = new TagsApi(client);
        return api.readTags("teams", 5);
    }
}