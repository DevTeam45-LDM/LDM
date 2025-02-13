package com.devteam45ldm.ldm.views.eLabClient.createReport;

import com.devteam45ldm.ldm.api.eLabClient.ELabController;
import com.devteam45ldm.ldm.parser.JsonToELabReportBody;
import com.devteam45ldm.ldm.parser.XMLToJsonParser;
import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.wontlost.ckeditor.Constants;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import io.swagger.client.model.ExperimentsBody;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * The CreateReport class represents a view for creating reports in the eLabClient.
 * It allows users to upload XML files, process them, and create experiments.
 */
@Component
@PageTitle("Create Report")
public class CreateReport extends Composite<VerticalLayout> implements CredentialsAware {

    private InputStream uploadedInputStream;
    private final TextField titleField = new TextField("Title");
    private final Button previewButton;
    private final ELabController apiInstance = new ELabController();
    private String apiKey;
    private String url;
    private Boolean buttonAllowed = false;
    private JSONObject jsonObject;
    private FileService fileService = new FileService();

    private final VaadinCKEditor classicEditor;
    private final Button createReportButton = new Button("Create experiment", event -> {
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

        // TODO
        // Create the "Preview" button
       previewButton = new Button("Preview", event -> {
            previewExperiment();
        });

        // Create the "Bericht erstellen" button
        createReportButton.setEnabled(false);

        classicEditor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>Experiment</p>";
            builder.editorType = Constants.EditorType.CLASSIC;
            builder.theme = Constants.ThemeType.LIGHT;
            builder.width = "100%";
            builder.height = "500px";
        }).createVaadinCKEditor();

        getContent().add(upload, previewButton,titleField, createReportButton,classicEditor);
        getContent().setWidth("100%");

    }

    // TODO
    public void previewExperiment() {
        Dialog previewDialog = new Dialog();
        previewDialog.setWidth("80%");
        previewDialog.setHeight("80%");

        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);

        Div previewContent = new Div();
        previewContent.setWidth("100%");
        previewContent.setHeight("100%");
        previewContent.setText(jsonObject.toString());

        Button closeButton = new Button("Close", event -> previewDialog.close());
        closeButton.getElement().getStyle().set("position", "absolute");
        closeButton.getElement().getStyle().set("top", "10px");
        closeButton.getElement().getStyle().set("right", "10px");

        VerticalLayout dialogLayout = new VerticalLayout(previewContent, closeButton);
        previewDialog.add(dialogLayout);
        previewDialog.open();

        // Load content asynchronously
        getUI().ifPresent(ui -> ui.access(() -> {
            previewContent.getElement().setProperty("innerHTML", classicEditor.getValue());
            dialogLayout.remove(progressBar);
            dialogLayout.add(previewContent, closeButton);
        }));
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
     * Represents a file document in MongoDB.
     */
    @Document(collection = "files")
    public class FileDocument {
        @Id
        private String id;
        private String fileName;
        private String content;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    /**
     * Service class for managing file documents in MongoDB.
     */
    @Service
    public class FileService {

        @Autowired
        private FileRepository fileRepository;

        public String saveFile(String fileName, String content) {
            FileDocument fileDocument = new FileDocument();
            fileDocument.setFileName(fileName);
            fileDocument.setContent(content);
            fileDocument = fileRepository.save(fileDocument);
            return fileDocument.getId();
        }
    }


    /**
     * Processes the uploaded file.
     * @param fileName the name of the uploaded file
     * @param inputStream the input stream of the uploaded file
     * @param mimeType the MIME type of the uploaded file
     */
    @Autowired
    private void processUploadedFile(String fileName, InputStream inputStream, String mimeType) {
        if ("application/xml".equals(mimeType) || fileName.endsWith(".xml")) {
            try {
                String xmlContent = new BufferedReader(new InputStreamReader(inputStream))
                        .lines()
                        .collect(Collectors.joining("\n"));
                JSONObject json = XMLToJsonParser.parseXMLToJson(xmlContent);
                jsonObject = json;
                Notification.show("XML file processed successfully.");

                // Save the JSON file to MongoDB
                String jsonContent = json.toString();
                String fileId = fileService.saveFile(fileName.replace(".xml", ".json"), jsonContent);

                // Generate a link to the uploaded file
                String fileLink = "<a href='/files/" + fileId + "'>" + fileName + "</a>";
                String editorContent = JsonToELabReportBody.convertJsonToHtml(json) + "<br>" + fileLink;
                classicEditor.setValue(editorContent);

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
        ExperimentsBody experimentBody = new ExperimentsBody();
        experimentBody.setTitle(titleField.getValue());
        experimentBody.setBody(classicEditor.getValue());
        final Integer[] id = new Integer[1];
        if (titleField.isEmpty()) {
            Notification.show("Please enter a title.");
            return;
        }
        try {
            ResponseEntity<Void> response = apiInstance.getExperimentsClient(apiKey, url).postExperimentWithHttpInfo(experimentBody);
            Objects.requireNonNull(response.getHeaders().get("Location")).forEach(location -> {
                String[] parts = location.split("/");
                id[0] = Integer.parseInt(parts[parts.length - 1]);
                apiInstance.getExperimentsClient().patchExperiment(id[0], experimentBody);
            });
        } catch (Exception e) {
            Notification.show("Error creating experiment: " + e.getMessage());
        }
        Notification.show("Created experiment " + "[ID: " + id[0] + "]" + "  successfully.");
    }
}
