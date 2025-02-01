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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@PageTitle("Bericht erstellen")
public class CreateReport extends Composite<VerticalLayout> implements CredentialsAware {

    private String uploadedFileName;
    private InputStream uploadedInputStream;
    private String uploadedMimeType;
    private long uploadedContentLength;
    private final TextField titleField = new TextField("Titel");
    private final ELabController apiInstance = new ELabController();
    private String apiKey;
    private String url;
    private Boolean buttonAllowed = false;

    private VaadinCKEditor classicEditor;
    private final Button createReportButton = new Button("Bericht erstellen", event -> {
        if (uploadedInputStream != null) {
            createExperiment();
        } else {
            Notification.show("No file uploaded.");
        }
    });

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
            long contentLength = event.getContentLength();

            try {
                uploadedFileName = event.getFileName();
                uploadedMimeType = event.getMIMEType();
                uploadedContentLength = event.getContentLength();
                uploadedInputStream = buffer.getInputStream();

                // Process the file here (e.g., save to disk, database, etc.)
                processUploadedFile(fileName, uploadedInputStream, mimeType, contentLength);
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

    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
        if(apiKey != null && !apiKey.isEmpty()) {
            this.buttonAllowed = true;
        }
    }

    private void processUploadedFile(String fileName, InputStream inputStream,
                                     String mimeType, long contentLength) {
        if (titleField.isEmpty()) {
            Notification.show("Bitte geben Sie einen Titel ein.");
            return;
        }
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

    private void createExperiment() {
        String title = titleField.getValue();
        try { //TODO use ApiClient
            apiInstance.getExperimentsClient(apiKey, url). createExperiment(id,selectedExperiment);
        } catch (Exception e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return;
        }
        Notification.show("Experiment erfolgreich erstellt.");
    }
}
