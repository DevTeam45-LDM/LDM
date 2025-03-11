package com.devteam45ldm.ldm.views.createtemplate.text;

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

@PageTitle("Text")
@Route("text")
public class Text extends Composite<VerticalLayout> {

    private final TextField fileExtension = new TextField();
    private final TextField skipLineMetadata = new TextField();
    private final TextField skipLineData = new TextField();
    private final TextField lineBeginMetadata = new TextField();
    private final TextField lineBeginData = new TextField();
    private final TextField assignmentsMetadata = new TextField();
    private final TextField assignmentsData = new TextField();
    private final TextField delimiterMetadata = new TextField();
    private final TextField delimiterData = new TextField();
    private final TextField terminatorMetadata = new TextField();
    private final TextField terminatorData = new TextField();

    public Text() {
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
                createAlignedRowLayout("Line Starter", "String which every line starts with.", lineBeginMetadata, lineBeginData),
                createAlignedRowLayout("Terminator", "Terminator for data e.g. a csv terminator like a newline.", terminatorMetadata, terminatorData),
                createAlignedRowLayout("Assignments",
                        "Assignment operators e.g. in txt files.\n" +
                                "Example: \"key: value\" -> \":\" is the assignment operator.\n" +
                                "If set, the data will be treated as key-value pairs, optionally with a delimiter for multiple values within a line.", assignmentsMetadata, assignmentsData),
                createAlignedRowLayout("Delimiter", "Delimiter for data e.g. a csv delimiter.", delimiterMetadata, delimiterData),
                createAlignedRowLayout("Skip Lines", "Amount of lines to skip after the headline (pattern).", skipLineMetadata, skipLineData)
        );

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }

    public void clearAllFields() {
        fileExtension.clear();
        skipLineMetadata.clear();
        skipLineData.clear();
        lineBeginMetadata.clear();
        lineBeginData.clear();
        assignmentsMetadata.clear();
        assignmentsData.clear();
        delimiterMetadata.clear();
        delimiterData.clear();
        terminatorMetadata.clear();
        terminatorData.clear();
    }

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
