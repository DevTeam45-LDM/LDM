package com.devteam45ldm.ldm.views.eLabClient.createReport;

import com.devteam45ldm.ldm.api.eLabClient.ELabController;
import com.devteam45ldm.ldm.parser.JsonToELabReportBody;
import com.devteam45ldm.ldm.parser.XMLToJsonParser;
import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.wontlost.ckeditor.Constants;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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
    private final Button createReportButton = new Button("Bericht erstellen", event -> {
        if (uploadedInputStream != null) {
            createExperiment();
        } else {
            Notification.show("No file uploaded.");
        }
    });

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

        getContent().add(upload, titleField, createReportButton,classicEditor);
        getContent().setWidth("100%");

    }

    /**
     * Sets the credentials for the API.
     * @param apiKey the API key
     * @param url the URL of the API
     */
    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
        if(apiKey != null && !apiKey.isEmpty()) {
            this.buttonAllowed = true;
        }
    }

    /**
     * Processes the uploaded file.
     * @param fileName the name of the uploaded file
     * @param inputStream the input stream of the uploaded file
     * @param mimeType the MIME type of the uploaded file
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
            id = apiInstance.getExperimentsClient().createExperimentCURL(apiKey, url, title);
            if (!classicEditor.getValue().isEmpty()) {
                apiInstance.getExperimentsClient().modifyExperimentCURL(apiKey, url, id, title, classicEditor.getValue());
            }
        } catch (RestClientException e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return;
        }
        Notification.show("Experiment " + "[ID: " + id + "]" + " erfolgreich erstellt.");
    }
}
