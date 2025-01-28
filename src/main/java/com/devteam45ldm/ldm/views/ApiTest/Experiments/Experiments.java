package com.devteam45ldm.ldm.views.ApiTest.Experiments;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.ComboBox;
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
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The eLabApiTest class represents a Vaadin view for testing the eLab API.
 * It allows users to enter a URL and API key, test the URL, and read tags from the API.
 */
@PageTitle("Experiments")
//@Route("api-test/experiments")
//@Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class Experiments extends Composite<VerticalLayout> {

    private static final Logger logger = LoggerFactory.getLogger(Experiments.class);

    private final TextField urlField;
    private final PasswordField apiKeyField;
    private final ComboBox<String> experimentsComboBox;
    private List<ExperimentTemplate> experiments;
    private final VerticalLayout experimentDetailsLayout;

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
                logger.error("Error testing URL", e);
                Notification.show("Error: " + e.getMessage());
            }
        });

        menuBar.addItem("Experimente lesen", event -> readExperiments());
        menuBar.getStyle().set("margin-bottom", "50px");

        // Initialize ComboBox for experiments
        experimentsComboBox = new ComboBox<>("Experimente");
        experimentsComboBox.setWidthFull();
        experimentsComboBox.getStyle().set("margin-bottom", "50px");
        experimentsComboBox.setAllowCustomValue(false);
        experimentsComboBox.addValueChangeListener(event -> showExperimentDetails(event.getValue()));

        experimentDetailsLayout = new VerticalLayout();
        experimentDetailsLayout.setWidthFull();
        experimentDetailsLayout.setMinHeight("500px");
        experimentDetailsLayout.setVisible(false);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, experimentsComboBox, experimentDetailsLayout);
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
            logger.info("API is reachable.");
        } else {
            Notification.show("API is not reachable: " + checkURL);
            logger.warn("API is not reachable: {}", checkURL);
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
            experiments = callExperimentsApi(apiKey, url);
            Map<String, Long> titleCount = experiments.stream()
                    .collect(Collectors.groupingBy(ExperimentTemplate::getTitle, Collectors.counting()));

            List<String> experimentTitles = experiments.stream()
                    .map(experiment -> {
                        String title = experiment.getTitle();
                        if (titleCount.get(title) > 1) {
                            return title + "; [id:" + experiment.getId() + "]";
                        } else {
                            return title;
                        }
                    })
                    .collect(Collectors.toList());

            experimentsComboBox.setItems(experimentTitles);
            experimentsComboBox.setLabel("Experimente (" + experiments.size() + ")");
            //experimentsComboBox.setValue(experiments.size() + " Experimente geladen");
            logger.info("Experiments fetched successfully.");
            Notification.show("Experiments fetched successfully.");
        } catch (Exception e) {
            logger.error("Error fetching experiments", e);
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

        // Create an instance of the ExperimentsApi
        ExperimentsTemplatesApi apiInstance = new ExperimentsTemplatesApi(client);

        // Fetch experiments
        List<ExperimentTemplate> result = apiInstance.readExperimentsTemplates();
        logger.info("Fetching experiments from {}", url);
        logger.info("Experiments: {}", result);
        return result;
    }

    private void showExperimentDetails(String selectedTitle) {
        experimentDetailsLayout.removeAll();
        if (selectedTitle == null || selectedTitle.isEmpty()) {
            return;
        }

        // Check if the title contains an ID
        String idPattern = "; \\[id:(\\d+)]";
        Pattern pattern = Pattern.compile(idPattern);
        Matcher matcher = pattern.matcher(selectedTitle);

        ExperimentTemplate selectedExperiment;
        if (matcher.find()) {
            // Extract the ID and search by ID
            int id = Integer.parseInt(matcher.group(1));
            selectedExperiment = experiments.stream()
                    .filter(experiment -> experiment.getId() == id)
                    .findFirst()
                    .orElse(null);
        } else {
            // Search by title
            selectedExperiment = experiments.stream()
                    .filter(experiment -> selectedTitle.equals(experiment.getTitle()))
                    .findFirst()
                    .orElse(null);
        }

        try {
            if (selectedExperiment != null) {
                VerticalLayout leftColumn = new VerticalLayout();
                VerticalLayout rightColumn = new VerticalLayout();
                leftColumn.add(
                        createTextField("ID", selectedExperiment.getId() != null ? String.valueOf(selectedExperiment.getId()) : "null"),
                        createTextField("User ID", selectedExperiment.getUserid() != null ? String.valueOf(selectedExperiment.getUserid()) : "null"),
                        createTextField("Created At", selectedExperiment.getCreatedAt() != null ? selectedExperiment.getCreatedAt() : "null"),
                        createTextField("Modified At", selectedExperiment.getModifiedAt() != null ? selectedExperiment.getModifiedAt() : "null"),
                        createTextField("Team", selectedExperiment.getTeamsId() != null ? String.valueOf(selectedExperiment.getTeamsId()) : "null"),
                        createTextField("Title", selectedExperiment.getTitle() != null ? selectedExperiment.getTitle() : "null"),
                        createTextField("Status", selectedExperiment.getStatus() != null ? String.valueOf(selectedExperiment.getStatus()) : "null"),
                        createTextField("Body", selectedExperiment.getBody() != null ? selectedExperiment.getBody() : "null"),
                        createTextField("Category", selectedExperiment.getCategory() != null ? String.valueOf(selectedExperiment.getCategory()) : "null"),
                        createTextField("Ordering", selectedExperiment.getOrdering() != null ? String.valueOf(selectedExperiment.getOrdering()) : "null"),
                        createTextField("Can Read", selectedExperiment.getCanread() != null ? selectedExperiment.getCanread() : "null"),
                        createTextField("Can Write", selectedExperiment.getCanwrite() != null ? selectedExperiment.getCanwrite() : "null"),
                        createTextField("Can Read Target", selectedExperiment.getCanReadTarget() != null ? selectedExperiment.getCanReadTarget() : "null"),
                        createTextField("Can Write Target", selectedExperiment.getCanWriteTarget() != null ? selectedExperiment.getCanWriteTarget() : "null"),
                        createTextField("Up Item ID", selectedExperiment.getUpItemId() != null ? String.valueOf(selectedExperiment.getUpItemId()) : "null"),
                        createTextField("Has Attachment", selectedExperiment.getHasAttachment() != null ? selectedExperiment.getHasAttachment() : "null")
                );

                rightColumn.add(
                        createTextField("Content Type", selectedExperiment.getContentType() != null ? String.valueOf(selectedExperiment.getContentType()) : "null"),
                        createTextField("Locked", selectedExperiment.getLocked() != null ? String.valueOf(selectedExperiment.getLocked()) : "null"),
                        createTextField("Locked By", selectedExperiment.getLockedby() != null ? String.valueOf(selectedExperiment.getLockedby()) : "null"),
                        createTextField("Locked At", selectedExperiment.getLockedAt() != null ? selectedExperiment.getLockedAt() : "null"),
                        createTextField("Metadata", selectedExperiment.getMetadata() != null ? selectedExperiment.getMetadata() : "null"),
                        createTextField("State", selectedExperiment.getState() != null ? String.valueOf(selectedExperiment.getState()) : "null"),
                        createTextField("Is Pinned", selectedExperiment.getIsPinned() != null ? String.valueOf(selectedExperiment.getIsPinned()) : "null"),
                        createTextField("Status Title", selectedExperiment.getStatusTitle() != null ? selectedExperiment.getStatusTitle() : "null"),
                        createTextField("Status Color", selectedExperiment.getStatusColor() != null ? selectedExperiment.getStatusColor() : "null"),
                        createTextField("Category Title", selectedExperiment.getCategoryTitle() != null ? selectedExperiment.getCategoryTitle() : "null"),
                        createTextField("Category Color", selectedExperiment.getCategoryColor() != null ? selectedExperiment.getCategoryColor() : "null"),
                        createTextField("Next Step", selectedExperiment.getNextStep() != null ? selectedExperiment.getNextStep() : "null"),
                        createTextField("First Name", selectedExperiment.getFirstname() != null ? selectedExperiment.getFirstname() : "null"),
                        createTextField("Last Name", selectedExperiment.getLastname() != null ? selectedExperiment.getLastname() : "null"),
                        createTextField("Orc ID", selectedExperiment.getOrcId() != null ? selectedExperiment.getOrcId() : "null"),
                        createTextField("Full Name", selectedExperiment.getFullname() != null ? selectedExperiment.getFullname() : "null"),
                        createTextField("Team Name", selectedExperiment.getTeamName() != null ? selectedExperiment.getTeamName() : "null")
                );

                HorizontalLayout columns = new HorizontalLayout(leftColumn, rightColumn);
                columns.setWidthFull();
                experimentDetailsLayout.add(columns);
            }
        } catch (Exception e) {
            logger.error("Error showing experiment details", e);
            Notification.show("Error: " + e.getMessage());
        }

        experimentDetailsLayout.setVisible(true);
    }

    private TextField createTextField(String label, String value) {
        TextField textField = new TextField(label);
        textField.setValue(value);
        textField.setReadOnly(true);
        textField.setWidth("400px");
        return textField;
    }
}