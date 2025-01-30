package com.devteam45ldm.ldm.views.eLabClient.createReport;

import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@PageTitle("Bericht erstellen")
public class DragNDrop extends VerticalLayout implements CredentialsAware {

    private String uploadedFileName;
    private InputStream uploadedInputStream;
    private String uploadedMimeType;
    private long uploadedContentLength;
    private final TextField titleField = new TextField("Titel");
    private String apiKey;
    private String url;

    public DragNDrop() {
        // Create a memory buffer to store uploaded files
        MemoryBuffer buffer = new MemoryBuffer();

        // Create an Upload component with the buffer
        Upload upload = new Upload(buffer);

        // Customize the drag and drop area
        upload.setDropLabel(new Html("<div>Drop files here</div>"));

        // Set some additional configurations
        upload.setMaxFiles(5);  // Limit to 5 files
        upload.setMaxFileSize(10 * 1024 * 1024);  // 10MB max file size

        // Add event listeners for upload events
        // Add event listeners for upload events
        upload.addSucceededListener(event -> {
            uploadedFileName = event.getFileName();
            uploadedMimeType = event.getMIMEType();
            uploadedContentLength = event.getContentLength();
            uploadedInputStream = buffer.getInputStream();
            Notification.show("File uploaded: " + uploadedFileName);
        });

        upload.addFailedListener(event -> {
            // Handle upload failures
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
        Button createReportButton = new Button("Bericht erstellen", event -> {
            if (uploadedInputStream != null) {
                processUploadedFile(uploadedFileName, uploadedInputStream, uploadedMimeType, uploadedContentLength);
            } else {
                Notification.show("No file uploaded.");
            }
        });

        add(upload, titleField, createReportButton); // TODO replace with following code
        setWidthFull(); //TODO replace with following code
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(firstRow, secondRow, menuBar, experimentsComboBox, experimentDetailsLayout, classicEditor, experimentsMenuBar, editLayout);


    }

    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    private void processUploadedFile(String fileName, InputStream inputStream,
                                     String mimeType, long contentLength) {
        if ("application/xml".equals(mimeType) || fileName.endsWith(".xml")) {
            try {
                String xmlContent = new BufferedReader(new InputStreamReader(inputStream))
                        .lines()
                        .collect(Collectors.joining("\n"));
                JSONObject json = XMLToJsonParser.parseXMLToJson(xmlContent);
                Notification.show("XML file processed successfully: " + json);
                createExperiment(json.toString());

            } catch (Exception e) {
                Notification.show("Error processing XML file: " + e.getMessage());
            }
        } else {
            Notification.show("Unsupported file format: " + mimeType);
        }
    }

    private void createExperiment(String body) {
        String title = titleField.getValue();
        //ExperimentsBody body = new ExperimentsBody();
        //apiInstance.getClient(apiKeyField.getValue(), urlField.getValue()).postExperiment(body);
        Integer id = null;
        try { //TODO use ApiClient
            // apiInstance.getClient(apiKeyField.getValue(), urlField.getValue()).patchExperiment(id,selectedExperiment);
            String commandTemplate = """
                curl -v --request POST 'https://sfb270eln.physik.uni-due.de/api/v2/experiments/' \\
                --header 'Authorization: %s' \\
                --header 'Content-Type: application/json' \\
                --data '{
                    "title": "%s",
                    "body": "%s"
                }'
            """;

            String command = String.format(commandTemplate, apiKey, title, body);
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", command);
            processBuilder.directory(new File("/home"));
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();

            // Read the error stream from the command
            InputStream errorStream = process.getErrorStream();
            String errorResult = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            int exitCode = process.waitFor();
            //Notification.show("Error: " + errorResult);
        } catch (Exception e) {
            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
            Notification.show(e.toString());
            return;
        }
        Notification.show("Experiment erfolgreich erstellt.");
    }
}
