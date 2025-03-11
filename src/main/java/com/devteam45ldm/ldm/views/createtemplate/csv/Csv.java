package com.devteam45ldm.ldm.views.createtemplate.csv;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * The `Csv` class represents a UI component for creating a CSV template.
 * It provides a form with various fields for metadata and data configuration.
 */
@PageTitle("CSV")
@Route("csv")
public class Csv extends Composite<VerticalLayout> {

    private final TextField fileExtension = new TextField();
    private final TextField skipLineMetadata = new TextField();
    private final TextField skipLineData = new TextField();
    private final TextField totalColumnsMetadata = new TextField();
    private final TextField totalColumnsData = new TextField();
    private final TextField hasHeadlineMetadata = new TextField();
    private final TextField hasHeadlineData = new TextField();
    private final TextField delimiterMetadata = new TextField();
    private final TextField delimiterData = new TextField();

    /**
     * Constructs a new `Csv` instance.
     * Initializes the layout and form fields.
     */
    public Csv() {
        HorizontalLayout fileExtensionLayout = new HorizontalLayout(new Span("File Extension"), fileExtension);
        fileExtensionLayout.setWidthFull();
        fileExtensionLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        HorizontalLayout metadataDataHeader = new HorizontalLayout();
        metadataDataHeader.setWidthFull();
        metadataDataHeader.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        metadataDataHeader.getStyle().set("font-weight", "bold");

        Span metadataLabel = new Span("Metadata");
        Span dataLabel = new Span("Data");
        metadataLabel.getStyle().set("margin-left", "250px");
        dataLabel.getStyle().set("margin-left", "200px");

        metadataDataHeader.add(metadataLabel, dataLabel);

        VerticalLayout verticalLayout = new VerticalLayout(
                fileExtensionLayout,
                metadataDataHeader,
                createAlignedRowLayout("Has Headline", "Is there a line to be treated as a headline?\n" +
                        "Lines with only spaces and \\n are ignored.", hasHeadlineMetadata, hasHeadlineData),
                createAlignedRowLayout("Total Columns", "Total amount of columns in the data.", totalColumnsMetadata, totalColumnsData),
                createAlignedRowLayout("Delimiter", "Delimiter for data e.g. a csv delimiter.", delimiterMetadata, delimiterData),
                createAlignedRowLayout("Skip Lines", "Amount of lines to skip after the headline (pattern).", skipLineMetadata, skipLineData)
        );

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }

    /**
     * Clears all the fields in the form.
     */
    public void clearAllFields() {
        fileExtension.clear();
        skipLineMetadata.clear();
        skipLineData.clear();
        totalColumnsMetadata.clear();
        totalColumnsData.clear();
        hasHeadlineMetadata.clear();
        hasHeadlineData.clear();
        delimiterMetadata.clear();
        delimiterData.clear();
    }

    /**
     * Creates a horizontal layout with aligned components for a row in the form.
     *
     * @param label the label for the row
     * @param infoLabel the information label for the row
     * @param metadataField the text field for metadata input
     * @param dataField the text field for data input
     * @return the created horizontal layout
     */
    private HorizontalLayout createAlignedRowLayout(String label, String infoLabel, TextField metadataField, TextField dataField) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        Span labelSpan = new Span(label);
        labelSpan.setWidth("100px");

        Icon infoIcon = createInfoIcon(infoLabel);
        infoIcon.getStyle().set("margin-right", "10px");

        metadataField.setWidth("250px");
        dataField.setWidth("250px");

        layout.add(labelSpan, infoIcon, metadataField, dataField);
        return layout;
    }

    /**
     * Creates an information icon with a dialog displaying the provided label.
     *
     * @param label the label to display in the dialog
     * @return the created information icon
     */
    private Icon createInfoIcon(String label) {
        Icon infoIcon = new Icon(VaadinIcon.INFO_CIRCLE_O);
        infoIcon.getElement().setAttribute("style", "cursor: pointer; color: #007bff;");
        Dialog infoDialog = new Dialog();
        infoDialog.add(new Span(label));
        infoIcon.addClickListener(event -> infoDialog.open());
        getContent().add(infoDialog);
        return infoIcon;
    }
}