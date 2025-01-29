package com.devteam45ldm.ldm.views.filedrop;

import com.devteam45ldm.ldm.services.JsonTemplateService;
import com.devteam45ldm.ldm.views.filedrop.uploadToELab.UploadtoELab;
import com.devteam45ldm.ldm.views.filedrop.conversion.Conversion;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.InputStream;
import java.util.ArrayList;

//new imports for extension
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

//additional imports for display of certain parameters
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Span;
import java.util.List;


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

public class FileDropView extends Composite<VerticalLayout> {

    private final JsonTemplateService templateService;
    /**
     * Constructs a new FileDropView instance.
     * Initializes and configures the uploaded file with custom design,
     * file constraints, and messages for successful and failed uploads.
     */
    public FileDropView(JsonTemplateService templateService) {
        this.templateService = templateService;
        // Create Tabs for conversion and file upload
        getContent().setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        setTabSheetContent(tabSheet);

        getContent().add(tabSheet);
        getContent().setFlexGrow(1, tabSheet);
        getContent().setAlignItems(FlexComponent.Alignment.STRETCH);

    }

    private void setTabSheetContent(TabSheet tabSheet) {
        UploadtoELab uploadTab = new UploadtoELab(templateService);
        uploadTab.getContent().setSizeFull();

        Conversion conversionTab = new Conversion();
        conversionTab.getContent().setSizeFull();

        tabSheet.add("Conversion", conversionTab);
        tabSheet.add("Upload", uploadTab);
    }
}