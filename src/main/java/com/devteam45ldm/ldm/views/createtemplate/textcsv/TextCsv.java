package com.devteam45ldm.ldm.views.createtemplate.textcsv;

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

@PageTitle("Text CSV")
@Route("text-csv")
public class TextCsv extends Composite<VerticalLayout> {

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

    public TextCsv() {
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
                createAlignedRowLayout("Skip Line", skipLineMetadata, skipLineData),
                createAlignedRowLayout("Line Begin", lineBeginMetadata, lineBeginData),
                createAlignedRowLayout("Assignments", assignmentsMetadata, assignmentsData),
                createAlignedRowLayout("Delimiter", delimiterMetadata, delimiterData),
                createAlignedRowLayout("Terminator", terminatorMetadata, terminatorData)
        );

//        verticalLayout.getStyle().set("border", "2px solid black");
//        verticalLayout.getStyle().set("padding", "20px");
//        verticalLayout.getStyle().set("border-radius", "10px");
//        verticalLayout.getStyle().set("width", "fit-content");
//        verticalLayout.getStyle().set("display", "inline-block");

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
    }
    private HorizontalLayout createAlignedRowLayout(String label, TextField metadataField, TextField dataField) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        Span labelSpan = new Span(label);
        labelSpan.setWidth("100px");

        Icon infoIcon = createInfoIcon(label);
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
        infoDialog.add(new Span("Information about " + label));
        infoIcon.addClickListener(event -> infoDialog.open());
        getContent().add(infoDialog);
        return infoIcon;
    }
}
