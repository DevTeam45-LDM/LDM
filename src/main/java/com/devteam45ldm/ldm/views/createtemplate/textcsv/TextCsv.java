package com.devteam45ldm.ldm.views.createtemplate.textcsv;

import com.devteam45ldm.ldm.views.createtemplate.parserTemplate.ParserTemplate;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Text CSV")
@Route("text-csv")
public class TextCsv extends Composite<VerticalLayout> {

    private final TextField fileExtension;
    private final TextField skipLineMetadata;
    private final TextField skipLineData;
    private final TextField lineBeginMetadata;
    private final TextField lineBeginData;
    private final TextField assignmentsMetadata;
    private final TextField assignmentsData;
    private final TextField delimiterMetadata;
    private final TextField delimiterData;
    private final TextField terminatorMetadata;
    private final TextField terminatorData;
    private final Select<ParserType> parserDropdown;

    public enum ParserType {
        JSON,
        XML,
        CSV,
        TEXT,
        CUSTOM,
        _CSV,
        _ELAB;
    }

    public TextCsv() {
        fileExtension = new TextField();
        skipLineMetadata = new TextField();
        skipLineData = new TextField();
        lineBeginMetadata = new TextField();
        lineBeginData = new TextField();
        assignmentsMetadata = new TextField();
        assignmentsData = new TextField();
        delimiterMetadata = new TextField();
        delimiterData = new TextField();
        terminatorMetadata = new TextField();
        terminatorData = new TextField();

        parserDropdown = new Select<>();
        parserDropdown.setItems(ParserType.values());

        HorizontalLayout headerLayout = new HorizontalLayout(new Span("Parser"), parserDropdown);
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
                headerLayout,
                fileExtensionLayout,
                metadataDataHeader,
                createAlignedRowLayout("Skip Line", skipLineMetadata, skipLineData),
                createAlignedRowLayout("Line Begin", lineBeginMetadata, lineBeginData),
                createAlignedRowLayout("Assignments", assignmentsMetadata, assignmentsData),
                createAlignedRowLayout("Delimiter", delimiterMetadata, delimiterData),
                createAlignedRowLayout("Terminator", terminatorMetadata, terminatorData)
        );

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
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
