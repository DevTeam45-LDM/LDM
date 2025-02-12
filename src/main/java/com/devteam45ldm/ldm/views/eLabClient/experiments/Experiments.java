package com.devteam45ldm.ldm.views.eLabClient.experiments;

import com.devteam45ldm.ldm.api.eLabClient.ELabController;
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

import com.wontlost.ckeditor.Constants;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import io.swagger.client.model.*;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.client.RestClientException;
import org.yaml.snakeyaml.util.Tuple;


/**
 * The ExperimentTemplates class represents a Vaadin view for testing the eLab API.
 * It allows users to enter a URL and API key, test the URL, and read experiments from the API.
 */
@PageTitle("Experiments")
@UIScope
public class Experiments extends Composite<VerticalLayout> implements CredentialsAware {

    private static final Logger logger = LoggerFactory.getLogger(Experiments.class);

    private final TextField urlField;
    private final PasswordField apiKeyField;
    private final ComboBox<String> experimentsComboBox;
    private List<Experiment> experiments;
    private final VerticalLayout experimentDetailsLayout;
    private final ELabController apiInstance = new ELabController();
    private final TextField editField = new TextField();
    private final MenuBar editMenuBar = new MenuBar();
    private final MenuBar experimentsMenuBar = new MenuBar();
    private Experiment selectedExperiment;
    private final HashMap<String, TextField> leftComponents = new HashMap<>();
    private final HashMap<String, TextField> rightComponents = new HashMap<>();

    private final VaadinCKEditor classicEditor;

    /**
     * Constructs the ExperimentTemplates view.
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
                Notification.show("Fehler: " + e.getMessage());
            }
        });

        menuBar.addItem("Experimente lesen", event -> readExperiments());
        menuBar.getStyle().set("margin-bottom", "50px");

        experimentDetailsLayout = new VerticalLayout();
        experimentDetailsLayout.setWidthFull();
        experimentDetailsLayout.setMinHeight("500px");
        experimentDetailsLayout.setVisible(false);

        // Initialize ComboBox for experiments
        experimentsComboBox = new ComboBox<>("Experimente");
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

        experimentsMenuBar.addItem("Experiment erstellen", event -> loadCreator());
        experimentsMenuBar.setVisible(false);

        classicEditor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>Experiment</p>";
            builder.editorType = Constants.EditorType.CLASSIC;
            builder.theme = Constants.ThemeType.LIGHT;
            builder.width = "100%";
            builder.height = "500px";
        }).createVaadinCKEditor();
        //classicEditor.setEnabled(true);
        //classicEditor.setVisible(false);
        classicEditor.setReadOnly(true);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, experimentsComboBox, experimentDetailsLayout, classicEditor, experimentsMenuBar, editLayout);
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
                    .collect(Collectors.groupingBy(Experiment::getTitle, Collectors.counting()));

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
            logger.info("Experiments fetched successfully.");
            Notification.show("Experimente erfolgreich geladen.");
            experimentsMenuBar.setVisible(true);
        } catch (Exception e) {
            logger.error("Error fetching experiments", e);
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
    private List<Experiment> callExperimentsApi(String apiKey, String url) {
        // Fetch experiments
        List<Experiment> result = apiInstance.getExperimentsClient(apiKey, url).readExperiments(null, null, null, null, null, null, 9999, null, null, 3, null, null); //read all experiments
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
                leftMapping.put("Body", new Tuple<>(selectedExperiment.getBody() != null ? selectedExperiment.getBody() : "null", 1));
                leftMapping.put("Body HTML", new Tuple<>(selectedExperiment.getBodyHtml() != null ? selectedExperiment.getBodyHtml() : "null", 2));
                leftMapping.put("Can Read", new Tuple<>(selectedExperiment.getCanread() != null ? selectedExperiment.getCanread() : "null", 3));
                leftMapping.put("Can Write", new Tuple<>(selectedExperiment.getCanwrite() != null ? selectedExperiment.getCanwrite() : "null", 4));
                leftMapping.put("Comments", new Tuple<>(selectedExperiment.getComments() != null ? selectedExperiment.getComments().toString() : "null", 5));
                leftMapping.put("Content Type", new Tuple<>(selectedExperiment.getContentType() != null ? String.valueOf(selectedExperiment.getContentType()) : "null", 6));
                leftMapping.put("Created At", new Tuple<>(selectedExperiment.getCreatedAt() != null ? selectedExperiment.getCreatedAt() : "null", 7));
                leftMapping.put("Custom ID", new Tuple<>(selectedExperiment.getCustomId() != null ? String.valueOf(selectedExperiment.getCustomId()) : "null", 8));
                leftMapping.put("Date", new Tuple<>(selectedExperiment.getDate() != null ? selectedExperiment.getDate() : "null", 9));
                leftMapping.put("Elab ID", new Tuple<>(selectedExperiment.getElabid() != null ? selectedExperiment.getElabid() : "null", 10));
                leftMapping.put("Events Start", new Tuple<>(selectedExperiment.getEventsStart() != null ? selectedExperiment.getEventsStart() : "null", 11));
                leftMapping.put("Events Start Item ID", new Tuple<>(selectedExperiment.getEventsStartItemId() != null ? selectedExperiment.getEventsStartItemId() : "null", 12));
                leftMapping.put("Exclusive Edit Mode", new Tuple<>(selectedExperiment.getExclusiveEditMode() != null ? selectedExperiment.getExclusiveEditMode().toString() : "null", 13));
                leftMapping.put("Experiments Links", new Tuple<>(selectedExperiment.getExperimentsLinks() != null ? selectedExperiment.getExperimentsLinks().toString() : "null", 14));
                leftMapping.put("Metadata", new Tuple<>(selectedExperiment.getMetadata() != null ? selectedExperiment.getMetadata() : "null", 15));
                leftMapping.put("Modified At", new Tuple<>(selectedExperiment.getModifiedAt() != null ? selectedExperiment.getModifiedAt() : "null", 16));
                leftMapping.put("Next Step", new Tuple<>(selectedExperiment.getNextStep() != null ? selectedExperiment.getNextStep() : "null", 17));
                leftMapping.put("Orcid", new Tuple<>(selectedExperiment.getOrcid() != null ? selectedExperiment.getOrcid() : "null", 18));
                leftMapping.put("Page", new Tuple<>(selectedExperiment.getPage() != null ? selectedExperiment.getPage() : "null", 19));
                leftMapping.put("Rating", new Tuple<>(selectedExperiment.getRating() != null ? String.valueOf(selectedExperiment.getRating()) : "null", 20));
                leftMapping.put("Recent Comment", new Tuple<>(selectedExperiment.getRecentComment() != null ? selectedExperiment.getRecentComment() : "null", 21));
                leftMapping.put("Related Experiments Links", new Tuple<>(selectedExperiment.getRelatedExperimentsLinks() != null ? selectedExperiment.getRelatedExperimentsLinks().toString() : "null", 22));
                leftMapping.put("Related Items Links", new Tuple<>(selectedExperiment.getRelatedItemsLinks() != null ? selectedExperiment.getRelatedItemsLinks().toString() : "null", 23));
                leftMapping.put("State", new Tuple<>(selectedExperiment.getState() != null ? String.valueOf(selectedExperiment.getState()) : "null", 24));
                leftMapping.put("Steps", new Tuple<>(selectedExperiment.getSteps() != null ? selectedExperiment.getSteps().toString() : "null", 25));
                leftMapping.put("Tags", new Tuple<>(selectedExperiment.getTags() != null ? selectedExperiment.getTags() : "null", 26));
                leftMapping.put("Tags ID", new Tuple<>(selectedExperiment.getTagsId() != null ? selectedExperiment.getTagsId() : "null", 27));
                leftMapping.put("Team", new Tuple<>(selectedExperiment.getTeam() != null ? String.valueOf(selectedExperiment.getTeam()) : "null", 28));
                leftMapping.put("Team Name", new Tuple<>(selectedExperiment.getTeamName() != null ? selectedExperiment.getTeamName() : "null", 29));

                Map<String, Tuple<String, Integer>> rightMapping = new HashMap<>();
                rightMapping.put("Content Type", new Tuple<>(selectedExperiment.getContentType() != null ? String.valueOf(selectedExperiment.getContentType()) : "null", 0));
                rightMapping.put("Locked", new Tuple<>(selectedExperiment.getLocked() != null ? String.valueOf(selectedExperiment.getLocked()) : "null", 1));
                rightMapping.put("Locked By", new Tuple<>(selectedExperiment.getLockedby() != null ? String.valueOf(selectedExperiment.getLockedby()) : "null", 2));
                rightMapping.put("Locked At", new Tuple<>(selectedExperiment.getLockedAt() != null ? selectedExperiment.getLockedAt() : "null", 3));
                rightMapping.put("Metadata", new Tuple<>(selectedExperiment.getMetadata() != null ? selectedExperiment.getMetadata() : "null", 4));
                rightMapping.put("State", new Tuple<>(selectedExperiment.getState() != null ? String.valueOf(selectedExperiment.getState()) : "null", 5));
                rightMapping.put("Status", new Tuple<>(selectedExperiment.getStatus() != null ? String.valueOf(selectedExperiment.getStatus()) : "null", 6));
                rightMapping.put("Status Color", new Tuple<>(selectedExperiment.getStatusColor() != null ? selectedExperiment.getStatusColor() : "null", 7));
                rightMapping.put("Status Title", new Tuple<>(selectedExperiment.getStatusTitle() != null ? selectedExperiment.getStatusTitle() : "null", 8));
                rightMapping.put("Category", new Tuple<>(selectedExperiment.getCategory() != null ? String.valueOf(selectedExperiment.getCategory()) : "null", 9));
                rightMapping.put("Category Color", new Tuple<>(selectedExperiment.getCategoryColor() != null ? selectedExperiment.getCategoryColor() : "null", 10));
                rightMapping.put("Category Title", new Tuple<>(selectedExperiment.getCategoryTitle() != null ? selectedExperiment.getCategoryTitle() : "null", 11));
                rightMapping.put("First Name", new Tuple<>(selectedExperiment.getFirstname() != null ? selectedExperiment.getFirstname() : "null", 12));
                rightMapping.put("Full Name", new Tuple<>(selectedExperiment.getFullname() != null ? selectedExperiment.getFullname() : "null", 13));
                rightMapping.put("Has Attachment", new Tuple<>(selectedExperiment.getHasAttachement() != null ? String.valueOf(selectedExperiment.getHasAttachement()) : "null", 14));
                rightMapping.put("Has Comment", new Tuple<>(selectedExperiment.getHasComment() != null ? String.valueOf(selectedExperiment.getHasComment()) : "null", 15));
                rightMapping.put("ID", new Tuple<>(selectedExperiment.getId() != null ? String.valueOf(selectedExperiment.getId()) : "null", 16));
                rightMapping.put("Items Links", new Tuple<>(selectedExperiment.getItemsLinks() != null ? selectedExperiment.getItemsLinks().toString() : "null", 17));
                rightMapping.put("Last Change By", new Tuple<>(selectedExperiment.getLastchangeby() != null ? String.valueOf(selectedExperiment.getLastchangeby()) : "null", 18));
                rightMapping.put("Last Name", new Tuple<>(selectedExperiment.getLastname() != null ? selectedExperiment.getLastname() : "null", 19));
                rightMapping.put("Timestamped", new Tuple<>(selectedExperiment.getTimestamped() != null ? String.valueOf(selectedExperiment.getTimestamped()) : "null", 20));
                rightMapping.put("Timestamped By", new Tuple<>(selectedExperiment.getTimestampedby() != null ? String.valueOf(selectedExperiment.getTimestampedby()) : "null", 21));
                rightMapping.put("Timestamped At", new Tuple<>(selectedExperiment.getTimestampedAt() != null ? selectedExperiment.getTimestampedAt() : "null", 22));
                rightMapping.put("Access Key", new Tuple<>(selectedExperiment.getAccessKey() != null ? selectedExperiment.getAccessKey() : "null", 23));
                rightMapping.put("Type", new Tuple<>(selectedExperiment.getType() != null ? selectedExperiment.getType() : "null", 24));
                rightMapping.put("Up Item ID", new Tuple<>(selectedExperiment.getUpItemId() != null ? String.valueOf(selectedExperiment.getUpItemId()) : "null", 25));
                rightMapping.put("Uploads", new Tuple<>(selectedExperiment.getUploads() != null ? selectedExperiment.getUploads().toString() : "null", 26));
                rightMapping.put("User ID", new Tuple<>(selectedExperiment.getUserid() != null ? String.valueOf(selectedExperiment.getUserid()) : "null", 27));
                rightMapping.put("Sharelink", new Tuple<>(selectedExperiment.getSharelink() != null ? selectedExperiment.getSharelink() : "null", 28));


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

                showDetailsMenuBar();

                classicEditor.setValue(selectedExperiment.getBody());
                classicEditor.setReadOnly(true);
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
    private void createExperimentCURL() {
        String title = editField.getValue();
        Integer id;
        try {
            id = apiInstance.getExperimentsClient().createExperimentCURL(apiKeyField.getValue(), urlField.getValue(), title);
            if (!classicEditor.getValue().isEmpty()) {
                apiInstance.getExperimentsClient().modifyExperimentCURL(apiKeyField.getValue(), urlField.getValue(), id, title, classicEditor.getValue());
            }
        } catch (RestClientException e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return;
        }
        Notification.show("Experiment " + "[ID: " + id + "]" + " erfolgreich erstellt.");
        resetEditComponents();
        readExperiments();
        setExperimentById(id);
    }

    private void createExperiment() {
        String title = editField.getValue();
        ExperimentsBody experimentBody = new ExperimentsBody();
        experimentBody.setTitle(title);
        experimentBody.setBody(classicEditor.getValue());

        try {
            ResponseEntity<Void> response = apiInstance.getExperimentsClient().postExperimentWithHttpInfo(experimentBody);
            Objects.requireNonNull(response.getHeaders().get("Location")).forEach(location -> {
                String[] parts = location.split("/");
                int id = Integer.parseInt(parts[parts.length - 1]);
                apiInstance.getExperimentsClient().patchExperiment(id, experimentBody);
                Notification.show("Experiment " + "[ID: " + id + "]" + " erfolgreich erstellt.");
                resetEditComponents();
                readExperiments();
                setExperimentById(id);
            });
        } catch (Exception e) {
            Notification.show("Error creating experiment: " + e.getMessage());
        }
    }



    /**
     * Saves the changes made to the selected experiment.
     * Updates the selected experiment and refreshes the experiments list.
     */
    private void saveChanges() {
        Integer id = selectedExperiment.getId();
        String title = editField.getValue();
        ExperimentsBody experimentBody = new ExperimentsBody();
        experimentBody.setTitle(title);
        experimentBody.setBody(classicEditor.getValue());

        try {
            //apiInstance.getExperimentsClient(apiKeyField.getValue(), urlField.getValue()).modifyExperimentCURL(apiKeyField.getValue(), urlField.getValue(), id, selectedExperiment.getTitle(), selectedExperiment.getBody());
            apiInstance.getExperimentsClient().patchExperiment(id, experimentBody);
            Notification.show("Experiment " + "[ID: " + id + "]" + " erfolgreich erstellt.");
            resetEditComponents();
            readExperiments();
            setExperimentById(id);
        } catch (RestClientException e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return;
        }
        setModifyComponentsReadOnly(true);
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
        selectedExperiment.setBody(classicEditor.getValue());
    }

    /**
     * Deletes the selected experiment.
     * Calls the API to delete the experiment and refreshes the experiments list.
     * Clears the ComboBox selection and resets the edit components.
     */
    private void deleteExperiment() {
        apiInstance.getExperimentsClient(apiKeyField.getValue(), urlField.getValue()).deleteExperiment(selectedExperiment.getId());
        Notification.show("Experiment erfolgreich gelöscht.");
        resetEditComponents();
        readExperiments();
        experimentsComboBox.clear();
    }

    /**
     * Loads the creator view for creating a new experiment.
     * Sets up the edit menu bar for creating a new experiment.
     */
    private void loadCreator() {
        experimentsComboBox.clear();
        editMenuBar.removeAll();
        editMenuBar.addItem("Erstellen", event -> createExperiment());
        editMenuBar.addItem("Abbrechen", event -> cancelCreate());
        editField.setVisible(true);
        editMenuBar.setVisible(true);
        experimentsMenuBar.setVisible(false);
        experimentDetailsLayout.setVisible(false);
        classicEditor.setVisible(true);
        classicEditor.setReadOnly(false);
        classicEditor.clear();
    }

    /**
     * Loads the modifier view for editing the selected experiment.
     * Sets up the edit menu bar for modifying the selected experiment.
     */
    private void loadModifier() {
        if (selectedExperiment != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Speichern", event -> saveChanges());
            editMenuBar.addItem("Abbrechen", event -> cancelModify());
            setModifyComponentsReadOnly(false);
            editField.setVisible(false);
            editMenuBar.setVisible(true);
            experimentsMenuBar.setVisible(false);
            classicEditor.setVisible(true);
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
            editMenuBar.addItem("Abbrechen", event -> cancelCreate());
            editMenuBar.setVisible(true);
            experimentsMenuBar.setVisible(false);
        } else {
            Notification.show("Bitte wählen Sie ein Experiment aus.");
        }
    }

    private void showDetailsMenuBar(){
        experimentsMenuBar.removeAll();
        experimentsMenuBar.addItem("Experiment erstellen", event -> loadCreator());
        experimentsMenuBar.addItem("Experiment bearbeiten", event -> loadModifier());
        experimentsMenuBar.addItem("Experiment löschen", event -> loadDeleter());
        classicEditor.setVisible(true);
    }

    /**
     * Cancels the current operation.
     * Resets the edit components to their default state.
     */
    private void cancelModify() {
        setModifyComponentsReadOnly(true);
        editField.setVisible(false);
        editMenuBar.setVisible(false);
        experimentsMenuBar.setVisible(true);
        showDetailsMenuBar();
    }

    private void cancelCreate() {
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
        experimentsMenuBar.addItem("Experiment erstellen", event -> loadCreator());
        experimentsMenuBar.setVisible(true);
        experimentDetailsLayout.setVisible(true);
        classicEditor.setVisible(false);
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
                    .map(Experiment::getTitle)
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
    private void setModifyComponentsReadOnly(Boolean status) {
        leftComponents.get("Title").setReadOnly(status);
        classicEditor.setReadOnly(status);
    }
}