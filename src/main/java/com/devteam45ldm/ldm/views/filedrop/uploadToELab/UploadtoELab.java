package com.devteam45ldm.ldm.views.filedrop.uploadToELab;

import com.devteam45ldm.ldm.views.filedrop.Template;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.annotation.UIScope;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// add new for mongodb
import org.springframework.stereotype.Component;
import com.devteam45ldm.ldm.models.JsonTemplate;
import com.devteam45ldm.ldm.services.JsonTemplateService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.format.DateTimeFormatter;

@PageTitle("Upload to eLab")
@UIScope
@Component
public class UploadtoELab extends Composite<VerticalLayout> {
    @Autowired
    private JsonTemplateService templateService;
    private Grid<JsonTemplate> templateGrid;

    public UploadtoELab() {

        getContent().setSizeFull();
        // Create a memory buffer to store uploaded files
        MemoryBuffer buffer = new MemoryBuffer();


        // Create an Upload component with the buffer
        Upload upload = new Upload(buffer);

        upload.setWidth("90%");

        // Customize the drag and drop area
        upload.setDropLabel(new Html("<div>Drag and drop files here</div>"));

        // Set some additional configurations
        upload.setMaxFiles(5);  // Limit to 5 files
        upload.setMaxFileSize(10 * 1024 * 1024);  // 10MB max file size

        // Optional: Customize the drop zone styling
        upload.getElement().getStyle()
                .set("borderStyle", "dashed")
                .set("borderColor", "#a9a9a9")
                .set("borderWidth", "2px")
                .set("padding", "20px")
                .set("textAlign", "center");

        // Add the upload component to the layout
        getContent().add(upload);

        // Create a horizontal layout for upload and dropdowns
        HorizontalLayout topSection = new HorizontalLayout();

        // Create a vertical layout for the two dropdowns
        VerticalLayout dropdownSection = new VerticalLayout();

        // Create the first dropdown
        Select<String> field1 = new Select<>();
        field1.setLabel("Field 1");
        field1.setPlaceholder("Select option");
        //items can be added later on -----------------


        VerticalLayout buttonSection = new VerticalLayout();

        Button convertButton = new Button("Convert to JSON");
        buttonSection.setAlignItems(FlexComponent.Alignment.CENTER); // Centers horizontally
        buttonSection.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER); // Centers vertically

        // Add both upload and button section to the horizontal layout
        buttonSection.add(convertButton);

        // Add dropdowns to their 'container'/'block'
        dropdownSection.add(field1);

        // Add both upload and dropdown section to the horizontal layout (right next to each other)
        topSection.add(upload, buttonSection, dropdownSection);
        topSection.setAlignItems(FlexComponent.Alignment.CENTER);

        // Add the horizontal layout to the main view -> every major 'block'/'container' is vertically layered
        getContent().add(topSection);

        //-------------------------------------new Vertical Layout Component------------------------------------

        final List<Span> barLabels = new ArrayList<Span>();  // Add this as a class field
        //final List<TextField> barFields = new ArrayList<TextField>();  // Optional: for the text fields too
        final List<TextField> barFields = new ArrayList<>();

        // Create bars section
        VerticalLayout barsSection = new VerticalLayout();
        barsSection.setSpacing(true);
        barsSection.setPadding(true);

        // Create 4 bars with labels
        for (int i = 1; i <= 4; i++) {
            HorizontalLayout barLayout = new HorizontalLayout();

            // Create span instead of label
            Span label = new Span("Bar " + i);
            label.setWidth("80px"); // Fixed width for labels
            barLabels.add(label);  // adjustment

            // Rest of your code remains the same
            TextField textField = new TextField();
            textField.setWidth("400px");
            textField.setReadOnly(true);  // Make it read-only initially
            barFields.add(textField);  // adjustment

            barLayout.add(label, textField);
            barLayout.setAlignItems(FlexComponent.Alignment.CENTER);

            barsSection.add(barLayout);
        }
        getContent().add(barsSection);



        // Add event listeners for upload events
        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            String mimeType = event.getMIMEType();
            long contentLength = event.getContentLength();

            try {
                // Get the input stream of the uploaded file
                InputStream inputStream = buffer.getInputStream();

                // Process the file here (e.g., save to disk, database, etc.)
                processUploadedFile(fileName, inputStream, mimeType, contentLength);

                convertButton.addClickListener(event2 -> {
                    // add the processing logic later
                    Notification.show(buffer.getFileName() + " is being processed!");
                });

                for(int i = 0; i < 4; i++) {
                    switch(i){
                        case 0:
                            barFields.get(i).setValue(fileName);
                            break;
                        case 1:
                            barFields.get(i).setValue(mimeType);
                            break;
                        case 2:
                            barFields.get(i).setValue(contentLength + "");
                            break;
                        case 3: barFields.get(i).setValue("empty parameter");
                            break;
                        default:
                            break;
                    }
                }

            } catch (Exception e) {
                // Handle any upload errors
                e.printStackTrace();
            }
        });

        //in case upload fails
        upload.addFailedListener(event -> {
            System.err.println("Upload failed: " + event.getReason());
        });

        //-------------------------------------new Vertical Layout Component------------------------------------

        // Create the grid for database content
        Grid<Template> grid = new Grid<>(Template.class);

        // Configure grid columns to match your sketch
        grid.setColumns(); // Clear default columns
        grid.addColumn("templateId").setHeader("Template ID");
        grid.addColumn("templateName").setHeader("Template Name");
        grid.addColumn("param1").setHeader("Category");
        grid.addColumn("param2").setHeader("Status");
        grid.addColumn("param3").setHeader("Tags");
        grid.addColumn("param4").setHeader("Machine Name");
        grid.addColumn("param5").setHeader("Created At");

        // Set grid height and make it scrollable
        grid.setHeight("300px");

        // Add the grid to the main layout
        getContent().add(grid);

        //add table for mongodb
        addTemplateManagementSection();
    }

    /**
     * Processes an uploaded file by handling its metadata and content.
     * This method is called after a successful file upload and performs the necessary
     * processing of the uploaded file's content and metadata.
     *
     * @param fileName      The name of the uploaded file
     * @param inputStream   The input stream containing the file's content
     * @param mimeType      The MIME type of the uploaded file
     * @param contentLength The size of the uploaded file in bytes
     *
     * @throws RuntimeException if there's an error processing the file
     */
    private void processUploadedFile(String fileName, InputStream inputStream,
                                     String mimeType, long contentLength) {
        // Implement your file processing logic here
        System.out.println("File uploaded: " + fileName);
        System.out.println("MIME Type: " + mimeType);
        System.out.println("File Size: " + contentLength + " bytes");

        // Example: You might want to save the file, process it, or store its details
        // This is where you'd add your specific file handling logic
    }

    private void updateTemplateGrid() {
        templateGrid.setItems(templateService.getAllTemplates());
    }

    private void saveTemplate(JsonTemplate template, TextField nameField,
                              TextField categoryField, ComboBox<String> statusField,
                              TextField machineNameField) {
        template.setTemplateName(nameField.getValue());
        template.setCategory(categoryField.getValue());
        template.setStatus(statusField.getValue());
        template.setMachineName(machineNameField.getValue());

        templateService.saveTemplate(template);
    }

    private void deleteTemplate(JsonTemplate template) {
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setHeader("Delete Template");
        dialog.setText("Are you sure you want to delete this template?");

        dialog.setCancelable(true);
        dialog.setConfirmText("Delete");
        dialog.setConfirmButtonTheme("error primary");

        dialog.addConfirmListener(event -> {
            templateService.deleteTemplate(template.getId());
            updateTemplateGrid();
        });

        dialog.open();
    }

    private void addTemplateManagementSection() {
        H3 templateTitle = new H3("JSON Templates");

        templateGrid = new Grid<>(JsonTemplate.class);
        templateGrid.setHeight("auto");
        templateGrid.setMinHeight("200px");
        templateGrid.setMaxHeight("400px");

        templateGrid.setColumns();
        templateGrid.addColumn(JsonTemplate::getTemplateName).setHeader("Template Name");
        templateGrid.addColumn(JsonTemplate::getCategory).setHeader("Category");
        templateGrid.addColumn(JsonTemplate::getStatus).setHeader("Status");
        templateGrid.addColumn(template ->
                        template.getTags() != null ? String.join(", ", template.getTags()) : "")
                .setHeader("Tags");
        templateGrid.addColumn(JsonTemplate::getMachineName).setHeader("Machine Name");
        templateGrid.addColumn(template ->
                        template.getCreatedAt() != null ?
                                template.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) : "")
                .setHeader("Created At");

        templateGrid.addComponentColumn(template -> {
            HorizontalLayout buttons = new HorizontalLayout();

            Button editButton = new Button(new Icon(VaadinIcon.EDIT));
            editButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
            editButton.addClickListener(e -> openTemplateEditor(template));

            Button deleteButton = new Button(new Icon(VaadinIcon.TRASH));
            deleteButton.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_ERROR);
            deleteButton.addClickListener(e -> deleteTemplate(template));

            buttons.add(editButton, deleteButton);
            return buttons;
        }).setHeader("Actions");

        Button addTemplateButton = new Button("Add Template", new Icon(VaadinIcon.PLUS));
        addTemplateButton.addClickListener(e -> openTemplateEditor(new JsonTemplate()));

        VerticalLayout templateSection = new VerticalLayout();
        templateSection.add(templateTitle, addTemplateButton, templateGrid);

        getContent().add(templateSection);
        updateTemplateGrid();
    }

    private void openTemplateEditor(JsonTemplate template) {
        Dialog editor = new Dialog();
        editor.setModal(true);
        editor.setWidth("600px");

        FormLayout form = new FormLayout();

        TextField nameField = new TextField("Template Name");
        nameField.setValue(template.getTemplateName() != null ? template.getTemplateName() : "");

        TextField categoryField = new TextField("Category");
        categoryField.setValue(template.getCategory() != null ? template.getCategory() : "");

        ComboBox<String> statusField = new ComboBox<>("Status");
        statusField.setItems("Active", "Inactive", "Draft");
        statusField.setValue(template.getStatus() != null ? template.getStatus() : "Draft");

        TextField machineNameField = new TextField("Machine Name");
        machineNameField.setValue(template.getMachineName() != null ? template.getMachineName() : "");

        Button saveButton = new Button("Save", e -> {
            saveTemplate(template, nameField, categoryField, statusField, machineNameField);
            editor.close();
            updateTemplateGrid();
        });

        Button cancelButton = new Button("Cancel", e -> editor.close());

        form.add(nameField, categoryField, statusField, machineNameField);

        HorizontalLayout buttons = new HorizontalLayout(saveButton, cancelButton);
        buttons.setSpacing(true);

        VerticalLayout dialogLayout = new VerticalLayout(form, buttons);
        dialogLayout.setPadding(true);
        dialogLayout.setSpacing(true);

        editor.add(dialogLayout);
        editor.open();
    }
}
