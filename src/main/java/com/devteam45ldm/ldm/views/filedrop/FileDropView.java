package com.devteam45ldm.ldm.views.filedrop;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;

//new imports for extension
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

//additional imports for display of certain parameters
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.List;
import java.util.ArrayList;


/**
 * A Vaadin view component that provides file upload functionality with drag and drop support.
 * This view allows users to upload files through a customized interface with specific
 * constraints on file size and number of files.
 *
 * @author DevTeam45LDM
 */
@PageTitle("File Upload")
@Route("file-upload")
@Menu(order = 3, icon = "line-awesome/svg/arrow-alt-circle-down.svg")
public class FileDropView extends VerticalLayout {

    /**
     * Constructs a new FileDropView instance.
     * Initializes and configures the uploaded file with custom design,
     * file constraints, and messages for successful and failed uploads.
     */
    public FileDropView() {
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
        add(upload);

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
        add(topSection);

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
        add(barsSection);



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
                        case 3: barFields.get(i).setValue("붕신tR");
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
        add(grid);

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
}
