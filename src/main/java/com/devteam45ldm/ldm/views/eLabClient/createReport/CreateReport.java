package com.devteam45ldm.ldm.views.eLabClient.createReport;

import com.devteam45ldm.ldm.api.eLabClient.ELabController;
import com.devteam45ldm.ldm.parser.JsonToELabReportBody;
import com.devteam45ldm.ldm.parser.XMLToJsonParser;
import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.wontlost.ckeditor.Constants;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import io.swagger.client.api.TeamTagsApi;
import io.swagger.client.model.IdTagsBody;
import io.swagger.client.model.Tag;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devteam45ldm.ldm.views.eLabClient.login.Login;
import com.devteam45ldm.ldm.views.eLabClient.tags.Tags;

/**
 * The CreateReport class represents a view for creating reports in the eLabClient.
 * It allows users to upload XML files, process them, and create experiments.
 */
@PageTitle("Bericht erstellen")
public class CreateReport extends Composite<VerticalLayout> implements CredentialsAware {

    private InputStream uploadedInputStream;
    private final TextField titleField = new TextField("Titel");
    private final ELabController apiInstance = new ELabController();
    private String apiKey;
    private String url;
    private Boolean buttonAllowed = false;
    private final VaadinCKEditor classicEditor;


    // Todo
//    private final Login login = new Login();
//    private ArrayList<HasValue<?, ?>> inputFields;
    private Tag selectedTag;
    private final MenuBar editMenuBar = new MenuBar();
    private final TextField editField = new TextField();
    private final MenuBar tagsMenuBar;
    private final MenuItem item1;
    private final MenuItem item2;
    private final MultiSelectComboBox<Tag> responseGrid;
    private final MenuBar tagsBar;
//    private final Button tagCancleButton = new Button("Cancle",event ->
//            noneDisplay());
//    private final Button tagComboButton = new Button("Tag select", event ->
//    {
//        readTags();
//    });

    private final Button createReportButton = new Button("Bericht erstellen", event -> {
        if (uploadedInputStream != null) {
            createExperiment();
        } else {
            Notification.show("No file uploaded.");
        }
    });
//    private final MultiSelectComboBox<Country> comboBox = new MultiSelectComboBox<>(
//            "Countries");

    /**
     * Constructor for CreateReport.
     * Initializes the UI components and sets up event listeners.
     */
    public CreateReport() {
        // Create a memory buffer to store uploaded files
        MemoryBuffer buffer = new MemoryBuffer();

        // Create an Upload component with the buffer
        Upload upload = new Upload(buffer);

        // Customize the drag and drop area
        upload.setDropLabel(new Html("<div>Drop files here</div>"));
        upload.setWidth("100%");

        // Set some additional configurations
        upload.setMaxFiles(5);  // Limit to 5 files
        upload.setMaxFileSize(10 * 1024 * 1024);  // 10MB max file size

        // Add event listeners for upload events
        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            String mimeType = event.getMIMEType();

            try {
                uploadedInputStream = buffer.getInputStream();

                // Process the file here (e.g., save to disk, database, etc.)
                processUploadedFile(fileName, uploadedInputStream, mimeType);
                if (buttonAllowed) {
                    createReportButton.setEnabled(true);
                }

            } catch (Exception e) {
                // Handle any upload errors
                e.printStackTrace();
            }
        });

        upload.addFailedListener(event -> {
            // Handle upload failures
            createReportButton.setEnabled(false);
            Notification.show("Upload failed: " + event.getReason());
        });

        // Optional: Customize the drop zone styling
        upload.getElement().getStyle()
                .set("borderStyle", "dashed")
                .set("borderColor", "#a9a9a9")
                .set("borderWidth", "2px")
                .set("padding", "20px")
                .set("textAlign", "center");

        // Create the "Bericht erstellen" button
        createReportButton.setEnabled(false);

        classicEditor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>Experiment</p>";
            builder.editorType = Constants.EditorType.CLASSIC;
            builder.theme = Constants.ThemeType.LIGHT;
            builder.width = "100%";
            builder.height = "500px";
        }).createVaadinCKEditor();

        // Todo from here
//        if (login.isSignup() != null){
//            inputFields = new ArrayList<>();
//            //string url inputFields.getFirst();
//            //String pass inputFields.getLast();
//        };

        tagsBar = new MenuBar();
        item1 = tagsBar.addItem("Tag select",event -> readTags());
        item2 = tagsBar.addItem("cancel",event -> noneDisplay());
        item2.setEnabled(false);

        tagsMenuBar = new MenuBar();
        tagsMenuBar.addItem("Tag erstellen", event -> loadCreator());
        tagsMenuBar.addItem("Tag bearbeiten", event -> loadModifier());
        tagsMenuBar.addItem("Tag löschen", event -> loadDeleter());
        tagsMenuBar.setVisible(false);

        editField.setVisible(false);
        editMenuBar.setVisible(false);

        responseGrid = new MultiSelectComboBox<>();
        responseGrid.setAutoExpand(MultiSelectComboBox.AutoExpandMode.BOTH);
        responseGrid.getStyle().set("flex-grow", "0");
        responseGrid.getStyle().set("margin-bottom", "20px");
        responseGrid.setVisible(false);
        responseGrid.addSelectionListener(event -> selectedTag = event.getFirstSelectedItem().orElse(null));

        // Todo did it
        getContent().add(upload, titleField, tagsBar, responseGrid, tagsMenuBar, createReportButton, classicEditor);
        getContent().setWidth("100%");

    }

    // Todo  로그인한 url apikey 를 가져오던지 로그인 한 것을 확인하던지로 가자.

    public void noneDisplay() {
        responseGrid.setVisible(false);
        editMenuBar.setVisible(false);
        tagsMenuBar.setVisible(false);
//        item1.getElement().setEnabled(true);
        item2.getElement().setEnabled(false);
    }
    /**
     * Reads tags from the API using the provided API key and URL.
     * Sets the retrieved tags to the grid.
     */
    public void readTags() {

        try {
            List<Tag> apiResponse = callApiGet();
            responseGrid.setItems(apiResponse);
            // get only tags
            responseGrid.setItemLabelGenerator(Tag::getTag);
            responseGrid.setVisible(true);
            tagsMenuBar.setVisible(true);
            item2.getElement().setEnabled(true);
        } catch (Exception e) {
            Notification.show("Fehler: " + e.getMessage());
        }
    }


    /**
     * Loads the tag creation UI components.
     */
    private void loadCreator() {
        editMenuBar.removeAll();
        editMenuBar.addItem("Erstellen", event -> createTag());
        editMenuBar.addItem("Abbrechen", event -> cancelTag());
        editField.setVisible(true);
        editMenuBar.setVisible(true);
        tagsMenuBar.setVisible(false);
    }

    /**
     * Loads the tag modification UI components.
     */
    private void loadModifier() {
        if (selectedTag != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Speichern", event -> saveChanges());
            editMenuBar.addItem("Abbrechen", event -> cancelTag());
            editField.setVisible(true);
            editMenuBar.setVisible(true);
            tagsMenuBar.setVisible(false);
        } else {
            Notification.show("Bitte wähle einen Tag aus.");
        }
    }

    /**
     * Loads the tag deletion UI components.
     */
    private void loadDeleter() {
        if (selectedTag != null) {
            editMenuBar.removeAll();
            editMenuBar.addItem("Löschen", event -> deleteTag());
            editMenuBar.addItem("Abbrechen", event -> cancelTag());
            editMenuBar.setVisible(true);
            tagsMenuBar.setVisible(false);
        } else {
            Notification.show("Bitte wähle einen Tag aus.");
        }
    }

    /**
     * Calls the external API to retrieve tags.
     *
     * @return a list of tags
     */
    private List<Tag> callApiGet() {
        // Create an instance of the TeamTagsApi
        TeamTagsApi client = apiInstance.getTeamTagsClient(apiKey, url);

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
        TeamTagsApi client = apiInstance.getTeamTagsClient(apiKey, url);

        // Create a tag for the team with id=5
        try {
            client.postTeamTag(5, new IdTagsBody().tag(tag));
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

    /**
     * Creates a new tag using the value from the edit field.
     */
    private void createTag() {
        boolean result = callApiPost(editField.getValue());
        if (result) {
            Notification.show("Tag erfolgreich erstellt.");
        } else {
            Notification.show("Fehler beim Erstellen des Tags.");
        }

        resetEditComponents();
        readTags();
    }

    /**
     * Calls the external API to update an existing tag.
     *
     * @param tag the new tag value
     * @param id  the ID of the tag to update
     * @return true if the tag was updated successfully, false otherwise
     */
    private boolean callApiPatch(String tag, Integer id) {
        try { //TODO use ApiClient
            TeamTagsApi client = apiInstance.getTeamTagsClient(apiKey, url);
            client.modifyTagCURL(apiKey, url, 5, id, tag);
            return true;
        } catch (Exception e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return false;
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
        boolean result = callApiPatch(editField.getValue(), selectedTag.getId());
        if (result) {
            Notification.show("Änderungen erfolgreich gespeichert.");
        } else {
            Notification.show("Keine Berechtigung Tags zu Löschen: eLab Admin kontaktieren.");
        }

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
        TeamTagsApi client = apiInstance.getTeamTagsClient(apiKey, url);

        // Create a tag for the team with id=5
        try {
            client.deleteTeamTag(5, id);
            return true;
        } catch (RestClientException e) {
            Notification.show("Fehler: " + e.getMessage()); //DEBUG
            return false;
        }
    }

    /**
     * Deletes the selected tag.
     */
    private void deleteTag() {
        boolean result = callApiDelete(selectedTag.getId());
        if (result) {
            Notification.show("Tag erfolgreich gelöscht.");
        } else {
            Notification.show("Keine Berechtigung Tags zu Löschen: eLab Admin kontaktieren.");
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


    /**
     * Sets the credentials for the API.
     *
     * @param apiKey the API key
     * @param url    the URL of the API
     */
    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
        if (apiKey != null && !apiKey.isEmpty()) {
            this.buttonAllowed = true;
        }
    }

    /**
     * Processes the uploaded file.
     *
     * @param fileName    the name of the uploaded file
     * @param inputStream the input stream of the uploaded file
     * @param mimeType    the MIME type of the uploaded file
     */
    private void processUploadedFile(String fileName, InputStream inputStream,
                                     String mimeType) {
        if ("application/xml".equals(mimeType) || fileName.endsWith(".xml")) {
            try {
                String xmlContent = new BufferedReader(new InputStreamReader(inputStream))
                        .lines()
                        .collect(Collectors.joining("\n"));
                JSONObject json = XMLToJsonParser.parseXMLToJson(xmlContent);
                Notification.show("XML file processed successfully.");
                classicEditor.setValue(JsonToELabReportBody.convertJsonToHtml(json));
            } catch (Exception e) {
                Notification.show("Error processing XML file: " + e.getMessage());
            }
        } else {
            Notification.show("Unsupported file type: " + mimeType);
        }
    }

    /**
     * Creates an experiment using the API.
     */
    private void createExperiment() {
        String title = titleField.getValue();
        Integer id;
        if (titleField.isEmpty()) {
            Notification.show("Bitte geben Sie einen Titel ein.");
            return;
        }
        try { //TODO use ApiClient
            id = apiInstance.getExperimentsClient(apiKey, url).createExperimentCURL(apiKey, url, title);
            if (!classicEditor.getValue().isEmpty()) {
                apiInstance.getExperimentsClient(apiKey, url).modifyExperimentCURL(apiKey, url, id, title, classicEditor.getValue());
            }
        } catch (RestClientException e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return;
        }
        Notification.show("Experiment " + "[ID: " + id + "]" + " erfolgreich erstellt.");
    }
}
