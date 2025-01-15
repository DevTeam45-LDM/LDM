package com.devteam45ldm.ldm.views.filedrop;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.io.InputStream;

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

        // Customize the drag and drop area
        upload.setDropLabel(new Html("<div>Drag and drop files here</div>"));

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

    }
}
