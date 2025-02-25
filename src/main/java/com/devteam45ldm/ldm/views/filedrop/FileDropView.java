//package com.devteam45ldm.ldm.views.filedrop;
//
//import com.devteam45ldm.ldm.api.eLabClient.ELabClient;
//import com.devteam45ldm.ldm.api.eLabClient.ELabController;
//import com.devteam45ldm.ldm.controller.HTTPController;
//import com.devteam45ldm.ldm.parser.JsonToELabReportBody;
//import com.devteam45ldm.ldm.parser.XMLToJsonParser;
//import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
//import com.devteam45ldm.ldm.views.eLabClient.login.Login;
//import com.devteam45ldm.ldm.views.eLabClient.login.LoginEvent;
//import com.devteam45ldm.ldm.views.eLabClient.login.LoginEventListener;
//import com.vaadin.flow.component.Html;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.menubar.MenuBar;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.component.upload.Upload;
//import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Menu;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import com.wontlost.ckeditor.Constants;
//import com.wontlost.ckeditor.VaadinCKEditor;
//import com.wontlost.ckeditor.VaadinCKEditorBuilder;
//import io.swagger.client.api.InfoApi;
//import io.swagger.client.model.Info;
//import org.json.JSONObject;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestClientException;
//
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@PageTitle("Home")
//@Route("")
//@Menu(order = 0, icon = "line-awesome/svg/globe-solid.svg")
//public class FileDropView extends VerticalLayout implements CredentialsAware,LoginEventListener {
//
//    private InputStream uploadedInputStream;
//    private final TextField titleField = new TextField("Titel");
//    private final ELabController apiInstance = new ELabController();
//    private String apiKey;
//    private String url;
//    private Boolean buttonAllowed = false;
//
//    private final VaadinCKEditor classicEditor;
//    private final Button createReportButton = new Button("Bericht erstellen", event -> {
//        if (uploadedInputStream != null) {
//            createExperiment();
//        } else {
//            Notification.show("No file uploaded.");
//        }
//    });
//
//    //new components
//    private final Upload upload;
//    private final MemoryBuffer buffer;
//    private boolean isInitialized = false;
//    private final Login login = new Login();
//
//    //components for the login
//    private final TextField urlField;
//    private final PasswordField apiKeyField;
//    private final MenuBar menuBar = new MenuBar();
//    private final ELabClient<InfoApi> eLabClient = new ELabClient<>(InfoApi.class);
//    private final List<LoginEventListener> listeners = new ArrayList<>();
//
//
//    public FileDropView() {
//        // Create a memory buffer to store uploaded files
//        buffer = new MemoryBuffer();
//
//        // Create an Upload component with the buffer
//        upload = new Upload(buffer);
//
//        // setup upload component
//        setupUpload();
//
//        // Add event listeners for upload events
//        upload.addSucceededListener(event -> {
//            String fileName = event.getFileName();
//            String mimeType = event.getMIMEType();
//
//            try {
//                // Get the input stream of the uploaded file
//                uploadedInputStream = buffer.getInputStream();
//
//                // Process the file here (e.g., save to disk, database, etc.)
//                processUploadedFile(fileName, uploadedInputStream, mimeType);
//                if (buttonAllowed) {
//                    createReportButton.setEnabled(true);
//                }
//
//            } catch (Exception e) {
//                // Handle any upload errors
//                e.printStackTrace();
//            }
//        });
//
//        upload.addFailedListener(event -> {
//            // Handle upload failures
//            createReportButton.setEnabled(false);
//            Notification.show("Upload failed: " + event.getReason());
//        });
//
//        // Optional: Customize the drop zone styling
//        upload.getElement().getStyle()
//                .set("borderStyle", "dashed")
//                .set("borderColor", "#a9a9a9")
//                .set("borderWidth", "2px")
//                .set("padding", "20px")
//                .set("textAlign", "center");
//
//        // Create the "Bericht erstellen" button
//        createReportButton.setEnabled(false);
//
//        classicEditor = new VaadinCKEditorBuilder().with(builder -> {
//            builder.editorData = "<p>Experiment</p>";
//            builder.editorType = Constants.EditorType.CLASSIC;
//            builder.theme = Constants.ThemeType.LIGHT;
//            builder.width = "100%";
//            builder.height = "500px";
//        }).createVaadinCKEditor();
//
//        // Add the upload component to the layout
//        add(upload, titleField, createReportButton,classicEditor);
//        setWidth("100%");
//
//        login.addLoginEventListener(this);
//        //add(login);
//
//        urlField = new TextField("URL");
//        HorizontalLayout firstRow = new HorizontalLayout(urlField);
//        firstRow.setWidthFull();
//        firstRow.setSpacing(true);
//
//        apiKeyField = new PasswordField("API Key");
//
//        HorizontalLayout secondRow = new HorizontalLayout(apiKeyField);
//        secondRow.setSpacing(true);
//        secondRow.setWidthFull();
//        secondRow.getStyle().set("margin", "20px");
//
//        menuBar.setWidth("min-content");
//
//        menuBar.addItem("Verbindungstest", event -> {
//            try{
//                testUrl();
//            } catch (Exception e){
//                Notification.show("Error: " + e.getMessage());
//            }
//        });
//        menuBar.addItem("Login", event -> getInfo());
//        menuBar.addItem("Logout", event -> deleteLogin());
//        menuBar.getItems().get(2).setEnabled(false);
//        menuBar.getStyle().set("margin-bottom", "80px");
//
//        setWidth("100%");
//        getStyle().set("flex-grow", "1");
//        //add(firstRow, secondRow, menuBar);
//
//        upload.setVisible(false);
//        titleField.setVisible(false);
//        createReportButton.setVisible(false);
//        classicEditor.setVisible(false);
//
//    }
//
//    /*-----------------------------------------------Hilfsmethoden-----------------------------------------------*/
//
//    /**
//     * Sets the credentials for the API.
//     * @param apiKey the API key
//     * @param url the URL of the API
//     */
//    @Override
//    public void setCredentials(String apiKey, String url) {
//        this.apiKey = apiKey;
//        this.url = url;
//        if(apiKey != null && !apiKey.isEmpty()) {
//            this.buttonAllowed = true;
//        }
//    }
//
//    /**
//     * Processes the uploaded file.
//     * @param fileName the name of the uploaded file
//     * @param inputStream the input stream of the uploaded file
//     * @param mimeType the MIME type of the uploaded file
//     */
//    private void processUploadedFile(String fileName, InputStream inputStream,
//                                     String mimeType) {
//        if ("application/xml".equals(mimeType) || fileName.endsWith(".xml")) {
//            try {
//                String xmlContent = new BufferedReader(new InputStreamReader(inputStream))
//                        .lines()
//                        .collect(Collectors.joining("\n"));
//                JSONObject json = XMLToJsonParser.parseXMLToJson(xmlContent);
//                Notification.show("XML file processed successfully.");
//                classicEditor.setValue(JsonToELabReportBody.convertJsonToHtml(json));
//            } catch (Exception e) {
//                Notification.show("Error processing XML file: " + e.getMessage());
//            }
//        } else {
//            Notification.show("Unsupported file type: " + mimeType);
//        }
//    }
//
//    /**
//     * Creates an experiment using the API.
//     */
//    private void createExperiment() {
//        String title = titleField.getValue();
//        Integer id;
//        if (titleField.isEmpty()) {
//            Notification.show("Bitte geben Sie einen Titel ein.");
//            return;
//        }
//        try { //TODO use ApiClient
//            id = apiInstance.getExperimentsClient(apiKey, url).createExperimentCURL(apiKey, url, title);
//            if (!classicEditor.getValue().isEmpty()) {
//                apiInstance.getExperimentsClient(apiKey, url).modifyExperimentCURL(apiKey, url, id, title, classicEditor.getValue());
//            }
//        } catch (RestClientException e) {
//            Notification.show("Undefinierter Fehler beim Speichern der Änderungen.");
//            Notification.show(e.toString());
//            return;
//        }
//        Notification.show("Experiment " + "[ID: " + id + "]" + " erfolgreich erstellt.");
//    }
//
//    private void setupUpload() {
//        upload.setDropLabel(new Html("<div>Drop files here</div>"));
//        upload.setWidth("100%");
//        upload.setMaxFiles(5);
//        upload.setMaxFileSize(10 * 1024 * 1024);
//
//        // Your existing upload configuration and listeners...
//
//        // Add the explicit drag and drop styling
//        upload.getElement().getStyle()
//                .set("borderStyle", "dashed")
//                .set("borderColor", "#a9a9a9")
//                .set("borderWidth", "2px")
//                .set("padding", "20px")
//                .set("textAlign", "center");
//    }
//
//    public void onLogin(LoginEvent event) {
//        url = event.getUrl();
//        event.getApiKey();
//    }
//
//
//
//
//
//
//
//
//    /**
//     * Tests the provided URL to check if the eLab is reachable.
//     *
//     * @throws IOException if an I/O error occurs
//     */
//    private void testUrl() throws IOException {
//        String url = urlField.getValue();
//        if (url == null || url.isEmpty()) {
//            Notification.show("Bitte URL eingeben.");
//            return;
//        }
//
//        if (!url.endsWith("/api/v2/info")) {
//            url = url.endsWith("/") ? url + "api/v2/info" : url + "/api/v2/info";
//        }
//
//        HTTPController httpController = new HTTPController();
//        ResponseEntity<String> checkURL = httpController.checkURL(url);
//        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection() || checkURL.getStatusCode().value() == 401) {
//            Notification.show("eLab ist erreichbar.");
//        } else {
//            Notification.show("eLab ist nicht erreichbar: " + checkURL);
//        }
//    }
//    /**
//     * Retrieves information from the eLab using the provided API key and URL.
//     */
//    private void getInfo() {
//        String apiKey = apiKeyField.getValue();
//        String url = urlField.getValue();
//
//        if ((apiKey == null || apiKey.isEmpty()) && (url == null || url.isEmpty())) {
//            Notification.show("Bitte einen API-Schlüssel und eine URL eingeben.");
//            return;
//        }
//        if (apiKey == null || apiKey.isEmpty()) {
//            Notification.show("Bitte einen API-Schlüssel eingeben.");
//            return;
//        }
//        if (url == null || url.isEmpty()) {
//            Notification.show("Bitte eine URL eingeben.");
//            return;
//        }
//
//        try {
//            Info info = eLabClient.getClient(apiKey, url).getInfo();
//            String version = (info != null && info.getElabftwVersion() != null && !info.getElabftwVersion().isEmpty()) ? info.getElabftwVersion() : "unbekannt";
//            Notification.show("Anmeldung erfolgreich. eLab-Version: " + version);
//            menuBar.getItems().get(1).setEnabled(false);
//            menuBar.getItems().get(2).setEnabled(true);
//            fireLoginEvent();
//        } catch (Exception e) {
//            Notification.show("Fehler bei der Anmeldung: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Clears the login fields and resets the menu bar.
//     */
//    private void deleteLogin() {
//        urlField.clear();
//        apiKeyField.clear();
//        menuBar.getItems().get(1).setEnabled(true);
//        menuBar.getItems().get(2).setEnabled(false);
//        fireLoginEvent();
//    }
//
//    /**
//     * Adds a login event listener.
//     *
//     * @param listener the listener to add
//     */
//    public void addLoginEventListener(LoginEventListener listener) {
//        listeners.add(listener);
//    }
//
//    /**
//     * Removes a login event listener.
//     *
//     * @param listener the listener to remove
//     */
//    public void removeLoginEventListener(LoginEventListener listener) {
//        listeners.remove(listener);
//    }
//
//    /**
//     * Fires a login event to all registered listeners.
//     */
//    private void fireLoginEvent() {
//        String url = urlField.getValue();
//        String apiKey = apiKeyField.getValue();
//        LoginEvent event = new LoginEvent(this, url, apiKey);
//        for (LoginEventListener listener : listeners) {
//            listener.onLogin(event);
//        }
//    }
//}