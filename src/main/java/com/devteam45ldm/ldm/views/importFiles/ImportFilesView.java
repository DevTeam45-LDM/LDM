package com.devteam45ldm.ldm.views.importFiles;

import com.devteam45ldm.ldm.api.eLabClient.ELabController;
import com.devteam45ldm.ldm.parser.JsonToELabReportBody;
import com.devteam45ldm.ldm.parser.XMLToJsonParser;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.wontlost.ckeditor.Constants;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Import Files")
@Route("import-files")
@Menu(order = 2, icon = "line-awesome/svg/filter-solid.svg")
public class ImportFilesView extends VerticalLayout {

    public ImportFilesView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        ComboBox comboBox3 = new ComboBox();
        setWidth("100%");
        getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        comboBox.setLabel("Messgerät");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        comboBox2.setLabel("Template");
        comboBox2.setWidth("min-content");
        setComboBoxSampleData(comboBox2);
        comboBox3.setLabel("Template Version");
        comboBox3.setWidth("min-content");
        setComboBoxSampleData(comboBox3);
        add(layoutRow);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(comboBox);
        layoutColumn3.add(comboBox2);
        layoutColumn3.add(comboBox3);

        //Create a memory buffer to store uploaded files
        MemoryBuffer buffer = new MemoryBuffer();

        // Create an Upload component with the buffer
        Upload upload = new Upload(buffer);
        upload.setDropAllowed(true);

        // Customize the drag and drop area
        upload.setDropLabel(new Html("<div>Drop files here</div>"));

        // Set some additional configurations
        upload.setMaxFiles(5);  // Limit to 5 files
        upload.setMaxFileSize(10 * 1024 * 1024);  // 10MB max file size

        // Add event listeners for upload events
        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            String mimeType = event.getMIMEType();
            long contentLength = event.getContentLength();

            try {
                // Get the input stream of the uploaded file
                InputStream inputStream = buffer.getInputStream();

                processUploadedFile(fileName, inputStream, mimeType, contentLength);
            } catch (Exception e) {
                // Handle any upload errors
                e.printStackTrace();
            }
        });

        upload.addFailedListener(event -> {
            // Handle upload failures
            System.err.println("Upload failed: " + event.getReason());
        });

        // Optional: Customize the drop zone styling
        upload.getElement().getStyle()
                .set("borderStyle", "dashed")
                .set("borderColor", "#a9a9a9")
                .set("borderWidth", "2px")
                .set("padding", "20px")
                .set("textAlign", "center");

        // Add the upload component to the layout
        add(upload);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("MeasureDevice1", "MeasureDevice1", null));
        sampleItems.add(new SampleItem("MeasureDevice2", "MeasureDevice2", null));
        sampleItems.add(new SampleItem("MeasureDevice3", "MeasureDevice3", Boolean.TRUE));
        sampleItems.add(new SampleItem("MeasureDevice4", "MeasureDevice4", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

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
