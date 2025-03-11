package com.devteam45ldm.ldm.views.createtemplate.parserTemplate;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.InputStream;

@PageTitle("File Upload")
@Route("file-upload")
public class ParserTemplate extends VerticalLayout {

    public ParserTemplate() {
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
        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            String mimeType = event.getMIMEType();
            long contentLength = event.getContentLength();

            try {
                // Get the input stream of the uploaded file
                InputStream inputStream = buffer.getInputStream();

                // Process the file here (e.g., save to disk, database, etc.)
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