package com.devteam45ldm.ldm.views.eLabClient.experiments;

import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
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

import io.swagger.client.api.*;
import io.swagger.client.model.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devteam45ldm.ldm.views.eLabClient.ELabClient;
import org.springframework.web.client.RestClientException;
import org.yaml.snakeyaml.util.Tuple;


/**
 * The ExperimentTemplates class represents a Vaadin view for testing the eLab API.
 * It allows users to enter a URL and API key, test the URL, and read experiments from the API.
 */
@PageTitle("ExperimentTemplates")
//@Route("elab/experiment-templates")
//@Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class ExperimentTemplates extends Composite<VerticalLayout> implements CredentialsAware {

    private static final Logger logger = LoggerFactory.getLogger(ExperimentTemplates.class);

    private final TextField urlField;
    private final PasswordField apiKeyField;
    private final ComboBox<String> experimentsComboBox;
    private List<ExperimentTemplate> experiments;
    private final VerticalLayout experimentDetailsLayout;
    private final ELabClient<ExperimentsTemplatesApi> apiInstance = new ELabClient<>(ExperimentsTemplatesApi.class);
    private final TextField editField = new TextField();
    private final MenuBar editMenuBar = new MenuBar();
    private final MenuBar experimentsMenuBar = new MenuBar();
    private ExperimentTemplate selectedExperiment;
    private final HashMap<String, TextField> leftComponents = new HashMap<>();
    private final HashMap<String, TextField> rightComponents = new HashMap<>();

    /**
     * Constructs the ExperimentTemplates view.
     * Initializes the UI components and layout.
     */
    public ExperimentTemplates() {
        // Erste Zeile: URL und Test-Button
        urlField = new TextField("URL");

        HorizontalLayout firstRow = new HorizontalLayout(urlField);
        firstRow.setWidthFull();
        firstRow.setSpacing(true);

        // Zweite Zeile: API-Key und Read Tags Button
        apiKeyField = new PasswordField("API Schlüssel");

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
                Notification.show("Fehler: " + e.getMessage());
            }
        });

        menuBar.addItem("Vorlagen lesen", event -> readExperiments());
        menuBar.getStyle().set("margin-bottom", "50px");

        experimentDetailsLayout = new VerticalLayout();
        experimentDetailsLayout.setWidthFull();
        experimentDetailsLayout.setMinHeight("500px");
        experimentDetailsLayout.setVisible(false);

        // Initialize ComboBox for experiments
        experimentsComboBox = new ComboBox<>("Vorlagen");
        experimentsComboBox.setWidthFull();
        experimentsComboBox.getStyle().set("margin-bottom", "50px");
        experimentsComboBox.setAllowCustomValue(false);
        experimentsComboBox.addValueChangeListener(event -> showExperimentDetails(event.getValue()));
        experimentsComboBox.addValueChangeListener(event -> {
            if (event.getValue() == null) {
                resetEditComponents();
                experimentDetailsLayout.setVisible(false);
            }
        });

        editField.setVisible(false);
        editMenuBar.setVisible(false);

        HorizontalLayout editLayout = new HorizontalLayout(editField, editMenuBar);
        editLayout.setWidthFull();
        editLayout.setSpacing(true);

        experimentsMenuBar.addItem("Vorlage erstellen", event -> loadCreator());
        experimentsMenuBar.setVisible(false);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, experimentsComboBox, experimentDetailsLayout, experimentsMenuBar, editLayout);
    }

    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKeyField.setValue(apiKey);
        this.apiKeyField.setReadOnly(true);
        this.urlField.setValue(url);
        this.urlField.setReadOnly(true);
    }

    /**
     * Loads the creator view for creating a new experiment.
     * Sets up the edit menu bar for creating a new experiment.
     */
    private void loadCreator() {
        editMenuBar.removeAll();
        editMenuBar.addItem("Erstellen", event -> createExperiment());
        editMenuBar.addItem("Abbrechen", event -> cancelExperiment());
        editField.setVisible(true);
        editMenuBar.setVisible(true);
        experimentsMenuBar.setVisible(false);
    }

    /**
     * Loads the modifier view for editing the selected experiment.
     * Sets up the edit menu bar for modifying the selected experiment.
     */
    private void loadModifier() {
        if (selectedExperiment != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Speichern", event -> saveChanges());
            editMenuBar.addItem("Abbrechen", event -> cancelExperiment());
            setFormComponentReadOnly(false);
            editField.setVisible(false);
            editMenuBar.setVisible(true);
            experimentsMenuBar.setVisible(false);
        } else {
            Notification.show("Bitte wählen Sie ein Experiment aus.");
        }
    }

    /**
     * Loads the deleter view for deleting the selected experiment.
     * Sets up the edit menu bar for deleting the selected experiment.
     */
    private void loadDeleter() {
        if (selectedExperiment != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Löschen", event -> deleteExperiment());
            editMenuBar.addItem("Abbrechen", event -> cancelExperiment());
            editMenuBar.setVisible(true);
            experimentsMenuBar.setVisible(false);
        } else {
            Notification.show("Bitte wählen Sie ein Experiment aus.");
        }
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
            Notification.show("Bitte URL eingeben.");
            return;
        }

        if (!url.endsWith("/api/v2/info")) {
            url = url.endsWith("/") ? url + "api/v2/info" : url + "/api/v2/info";
        }

        HTTPController httpController = new HTTPController();
        ResponseEntity<String> checkURL = httpController.checkURL(url);
        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection() || checkURL.getStatusCode().value() == 401) {
            Notification.show("eLab ist erreichbar.");
            logger.info("API is reachable.");
        } else {
            Notification.show("eLab ist nicht erreichbar: " + checkURL);
            logger.warn("API is not reachable: {}", checkURL);
        }
    }

    /**
     * Reads experiments from the API using the provided API key and URL.
     * Populates the ComboBox with the experiment titles.
     */
    private void readExperiments() {
        String apiKey = apiKeyField.getValue();
        String url = urlField.getValue();
        if (apiKey == null || apiKey.isEmpty()) {
            Notification.show("Bitte API Schlüssel eingeben.");
            return;
        }
        if (url == null || url.isEmpty()) {
            Notification.show("Bitte URL eingeben.");
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
            experimentsComboBox.setLabel("Vorlagen (" + experiments.size() + ")");
            logger.info("Templates fetched successfully.");
            Notification.show("Vorlagen erfolgreich geladen.");
            experimentsMenuBar.setVisible(true);
        } catch (Exception e) {
            logger.error("Error fetching templates", e);
            Notification.show("Fehler: " + e.getMessage());
        }
    }

    /**
     * Calls the experiments API to fetch the list of experiments.
     *
     * @param apiKey the API key
     * @param url the URL
     * @return the list of experiments
     */
    private List<ExperimentTemplate> callExperimentsApi(String apiKey, String url) {
        // Fetch experiments
        List<ExperimentTemplate> result = apiInstance.getClient(apiKey, url).readExperimentsTemplates();
        logger.info("Fetching experiments from {}", url);
        logger.info("Experiments: {}", result);
        return result;
    }

    /**
     * Shows the details of the selected experiment.
     * Displays the details in two columns within the experimentDetailsLayout.
     *
     * @param selectedTitle the title of the selected experiment
     */
    private void showExperimentDetails(String selectedTitle) {
        experimentDetailsLayout.removeAll();
        if (selectedTitle == null || selectedTitle.isEmpty()) {
            return;
        }

        // Check if the title contains an ID
        String idPattern = "; \\[id:(\\d+)]";
        Pattern pattern = Pattern.compile(idPattern);
        Matcher matcher = pattern.matcher(selectedTitle);

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

                Map<String, Tuple<String, Integer>> leftMapping = new HashMap<>();
                leftMapping.put("Title", new Tuple<>(selectedExperiment.getTitle() != null ? selectedExperiment.getTitle() : "null", 0));
                leftMapping.put("ID", new Tuple<>(selectedExperiment.getId() != null ? String.valueOf(selectedExperiment.getId()) : "null", 1));
                leftMapping.put("User ID", new Tuple<>(selectedExperiment.getUserid() != null ? String.valueOf(selectedExperiment.getUserid()) : "null", 2));
                leftMapping.put("Created At", new Tuple<>(selectedExperiment.getCreatedAt() != null ? selectedExperiment.getCreatedAt() : "null", 3));
                leftMapping.put("Modified At", new Tuple<>(selectedExperiment.getModifiedAt() != null ? selectedExperiment.getModifiedAt() : "null", 4));
                leftMapping.put("Team", new Tuple<>(selectedExperiment.getTeamsId() != null ? String.valueOf(selectedExperiment.getTeamsId()) : "null", 5));
                leftMapping.put("Status", new Tuple<>(selectedExperiment.getStatus() != null ? String.valueOf(selectedExperiment.getStatus()) : "null", 6));
                leftMapping.put("Body", new Tuple<>(selectedExperiment.getBody() != null ? selectedExperiment.getBody() : "null", 7));
                leftMapping.put("Category", new Tuple<>(selectedExperiment.getCategory() != null ? String.valueOf(selectedExperiment.getCategory()) : "null", 8));
                leftMapping.put("Ordering", new Tuple<>(selectedExperiment.getOrdering() != null ? String.valueOf(selectedExperiment.getOrdering()) : "null", 9));
                leftMapping.put("Can Read", new Tuple<>(selectedExperiment.getCanread() != null ? selectedExperiment.getCanread() : "null", 10));
                leftMapping.put("Can Write", new Tuple<>(selectedExperiment.getCanwrite() != null ? selectedExperiment.getCanwrite() : "null", 11));
                leftMapping.put("Can Read Target", new Tuple<>(selectedExperiment.getCanReadTarget() != null ? selectedExperiment.getCanReadTarget() : "null", 12));
                leftMapping.put("Can Write Target", new Tuple<>(selectedExperiment.getCanWriteTarget() != null ? selectedExperiment.getCanWriteTarget() : "null", 13));
                leftMapping.put("Up Item ID", new Tuple<>(selectedExperiment.getUpItemId() != null ? String.valueOf(selectedExperiment.getUpItemId()) : "null", 14));
                leftMapping.put("Has Attachment", new Tuple<>(selectedExperiment.getHasAttachment() != null ? selectedExperiment.getHasAttachment() : "null", 15));
                leftMapping.put("Exclusive Edit Mode", new Tuple<>(selectedExperiment.getExclusiveEditMode() != null ? selectedExperiment.getExclusiveEditMode().toString() : "null", 16));

                Map<String, Tuple<String, Integer>> rightMapping = new HashMap<>();
                rightMapping.put("Content Type", new Tuple<>(selectedExperiment.getContentType() != null ? String.valueOf(selectedExperiment.getContentType()) : "null", 0));
                rightMapping.put("Locked", new Tuple<>(selectedExperiment.getLocked() != null ? String.valueOf(selectedExperiment.getLocked()) : "null", 1));
                rightMapping.put("Locked By", new Tuple<>(selectedExperiment.getLockedby() != null ? String.valueOf(selectedExperiment.getLockedby()) : "null", 2));
                rightMapping.put("Locked At", new Tuple<>(selectedExperiment.getLockedAt() != null ? selectedExperiment.getLockedAt() : "null", 3));
                rightMapping.put("Metadata", new Tuple<>(selectedExperiment.getMetadata() != null ? selectedExperiment.getMetadata() : "null", 4));
                rightMapping.put("State", new Tuple<>(selectedExperiment.getState() != null ? String.valueOf(selectedExperiment.getState()) : "null", 5));
                rightMapping.put("Is Pinned", new Tuple<>(selectedExperiment.getIsPinned() != null ? String.valueOf(selectedExperiment.getIsPinned()) : "null", 6));
                rightMapping.put("Status Title", new Tuple<>(selectedExperiment.getStatusTitle() != null ? selectedExperiment.getStatusTitle() : "null", 7));
                rightMapping.put("Status Color", new Tuple<>(selectedExperiment.getStatusColor() != null ? selectedExperiment.getStatusColor() : "null", 8));
                rightMapping.put("Category Title", new Tuple<>(selectedExperiment.getCategoryTitle() != null ? selectedExperiment.getCategoryTitle() : "null", 9));
                rightMapping.put("Category Color", new Tuple<>(selectedExperiment.getCategoryColor() != null ? selectedExperiment.getCategoryColor() : "null", 10));
                rightMapping.put("Next Step", new Tuple<>(selectedExperiment.getNextStep() != null ? selectedExperiment.getNextStep() : "null", 11));
                rightMapping.put("First Name", new Tuple<>(selectedExperiment.getFirstname() != null ? selectedExperiment.getFirstname() : "null", 12));
                rightMapping.put("Last Name", new Tuple<>(selectedExperiment.getLastname() != null ? selectedExperiment.getLastname() : "null", 13));
                rightMapping.put("Orc ID", new Tuple<>(selectedExperiment.getOrcId() != null ? selectedExperiment.getOrcId() : "null", 14));
                rightMapping.put("Full Name", new Tuple<>(selectedExperiment.getFullname() != null ? selectedExperiment.getFullname() : "null", 15));
                rightMapping.put("Team Name", new Tuple<>(selectedExperiment.getTeamName() != null ? selectedExperiment.getTeamName() : "null", 16));

                leftMapping.forEach((label, tuple) -> {
                    TextField textField = createTextField(label, tuple._1(), tuple._2());
                    leftComponents.put(label, textField);
                    leftColumn.add(textField);
                });

                rightMapping.forEach((label, tuple) -> {
                    TextField textField = createTextField(label, tuple._1(), tuple._2());
                    rightComponents.put(label, textField);
                    rightColumn.add(textField);
                });

                HorizontalLayout columns = new HorizontalLayout(leftColumn, rightColumn);
                columns.setWidthFull();
                experimentDetailsLayout.add(columns);

                experimentsMenuBar.removeAll();
                experimentsMenuBar.addItem("Vorlage erstellen", event -> loadCreator());
                experimentsMenuBar.addItem("Vorlage bearbeiten", event -> loadModifier());
                experimentsMenuBar.addItem("Vorlage löschen", event -> loadDeleter());

            }
        } catch (Exception e) {
            logger.error("Error showing experiment details", e);
            Notification.show("Fehler: " + e.getMessage());
        }

        experimentDetailsLayout.setVisible(true);
        experimentsMenuBar.setVisible(true);
    }

    /**
     * Creates a read-only TextField with the specified label and value.
     *
     * @param label the label of the TextField
     * @param value the value of the TextField
     * @param order the order of the TextField in the layout
     * @return the created TextField
     */
    private TextField createTextField(String label, String value, Integer order) {
        TextField textField = new TextField(label);
        textField.setValue(value);
        textField.setReadOnly(true);
        textField.getElement().getStyle().set("order", order.toString());
        textField.setWidth("400px");
        return textField;
    }

    /**
     * Creates a new experiment using the provided title.
     * Resets the edit components and refreshes the experiments list.
     */
    private void createExperiment() {
        String title = editField.getValue();
        ExperimentsTemplatesBody body = new ExperimentsTemplatesBody().title(title);
        apiInstance.getClient(apiKeyField.getValue(), urlField.getValue()).postExperimentTemplate(body);
        Notification.show("Vorlage erfolgreich erstellt.");
        resetEditComponents();
        readExperiments();
        experiments.stream()
                .filter(experiment -> experiment.getTitle().equals(title))
                .findFirst()
                .ifPresent(experiment -> setExperimentById(experiment.getId()));
    }

    /**
     * Saves the changes made to the selected experiment.
     * Updates the selected experiment and refreshes the experiments list.
     */
    private void saveChanges() {
        Integer id = selectedExperiment.getId();
        updateSelectedExperiment();
        try {
            apiInstance.getClient(apiKeyField.getValue(), urlField.getValue()).patchExperimentTemplate(id,selectedExperiment);
        } catch (RestClientException e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
        }
        setFormComponentReadOnly(true);
        Notification.show("Änderungen erfolgreich gespeichert.");
        resetEditComponents();
        readExperiments();
        setExperimentById(id);
    }

    /**
     * Updates the selected experiment with the values from the form components.
     */
    private void updateSelectedExperiment() {
        selectedExperiment.setTitle(leftComponents.get("Title").getValue());
    }

    /**
     * Deletes the selected experiment.
     * Calls the API to delete the experiment and refreshes the experiments list.
     * Clears the ComboBox selection and resets the edit components.
     */
    private void deleteExperiment() {
        apiInstance.getClient(apiKeyField.getValue(), urlField.getValue()).deleteExperimentTemplate(selectedExperiment.getId());
        Notification.show("Vorlage erfolgreich gelöscht.");
        resetEditComponents();
        readExperiments();
        experimentsComboBox.clear();
    }

    /**
     * Cancels the current operation.
     * Resets the edit components to their default state.
     */
    private void cancelExperiment() {
        resetEditComponents();
    }

    /**
     * Cancels the current operation.
     * Resets the edit components to their default state.
     */
    private void resetEditComponents() {
        editField.setVisible(false);
        editMenuBar.setVisible(false);
        experimentsMenuBar.removeAll();
        experimentsMenuBar.addItem("Vorlage erstellen", event -> loadCreator());
        experimentsMenuBar.setVisible(true);
        experimentDetailsLayout.setVisible(false);
    }

    /**
     * Sets the selected experiment in the ComboBox by its ID.
     * Finds the experiment by ID and sets it as the selected value in the ComboBox.
     *
     * @param id the ID of the experiment to select
     */
    private void setExperimentById(Integer id) {
        if (id != null) {
            experimentsComboBox.setValue(experiments.stream()
                    .filter(experiment -> Objects.equals(experiment.getId(), id))
                    .map(ExperimentTemplate::getTitle)
                    .findFirst()
                    .orElse(null));
        }
    }

    /**
     * Sets the read-only status of the form components.
     * Updates the read-only status of the form components based on the provided status.
     *
     * @param status the read-only status to set
     */
    private void setFormComponentReadOnly(Boolean status) {
        leftComponents.get("Title").setReadOnly(status);
        //rightComponents.get("Is Pinned").setReadOnly(status); // not editable
    }
}