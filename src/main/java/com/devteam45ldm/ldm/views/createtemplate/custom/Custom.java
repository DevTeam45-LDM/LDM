package com.devteam45ldm.ldm.views.createtemplate.custom;

import com.devteam45ldm.ldm.views.createtemplate.csv.SubCsv;
import com.devteam45ldm.ldm.views.createtemplate.jsonxml.SubJsonXml;
import com.devteam45ldm.ldm.views.createtemplate.text.SubText;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The `Custom` class represents a UI component for creating a custom template.
 * It provides a form with various fields for metadata and data configuration.
 */
@PageTitle("Custom")
@Route("custom")
public class Custom extends Composite<VerticalLayout> {

    private final TextField fileExtension = new TextField();
    private final Select<ParserType> metadataParserDropdown = new Select<>();
    private final Select<ParserType> dataParserDropdown = new Select<>();
    private final SubJsonXml subJsonXmlMetadata = new SubJsonXml("Path to Metadata");
    private final SubJsonXml subJsonXmlData = new SubJsonXml("Path to Data");
    private final SubText subTextMetadata = new SubText("Metadata");
    private final SubText subTextData = new SubText("Data");
    private final SubCsv subCsvMetadata = new SubCsv("Metadata");
    private final SubCsv subCsvData = new SubCsv("Data");

    /**
     * Enum representing the types of parsers available.
     */
    public enum ParserType {
        JSON,
        XML,
        CSV,
        TEXT,
        CUSTOM,
        _CSV,
        _ELAB;
    }

    /**
     * Constructs a new `Custom` instance.
     * Initializes the layout and form fields.
     */
    public Custom() {
        fileExtension.getStyle().set("width", "250px");
        fileExtension.getStyle().set("margin-left", "50px");

        HorizontalLayout fileExtensionLayout = new HorizontalLayout(new Span("File Extension"), fileExtension);
        fileExtensionLayout.setWidthFull();
        fileExtensionLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        subJsonXmlMetadata.setVisible(false);
        subJsonXmlData.setVisible(false);
        subTextMetadata.setVisible(false);
        subTextData.setVisible(false);
        subCsvMetadata.setVisible(false);
        subCsvData.setVisible(false);

        setDropdownItems(metadataParserDropdown);
        setDropdownItems(dataParserDropdown);

        metadataParserDropdown.addValueChangeListener(event -> {
            try {
                ParserType selectedValue = event.getValue();
                updateVisibility(selectedValue, "Metadata");
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        dataParserDropdown.addValueChangeListener(event -> {
            try {
                ParserType selectedValue = event.getValue();
                updateVisibility(selectedValue, "data");
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        VerticalLayout verticalLayout = new VerticalLayout(
                fileExtensionLayout,
                createAlignedRowLayout("Metadata Parser", metadataParserDropdown),
                subJsonXmlMetadata,
                subTextMetadata,
                subCsvMetadata,
                createAlignedRowLayout("Data Parser", dataParserDropdown),
                subJsonXmlData,
                subTextData,
                subCsvData
        );

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }

    /**
     * Updates the visibility of sub-components based on the selected parser type.
     *
     * @param selectedValue the selected parser type
     * @param type the type of parser (Metadata or data)
     */
    private void updateVisibility(ParserType selectedValue, String type) {
        boolean isMetadata = "Metadata".equals(type);
        subFieldsClear(type);

        switch (selectedValue) {
            case JSON:
            case XML:
                if (isMetadata) {
                    subJsonXmlMetadata.setVisible(true);
                    subTextMetadata.setVisible(false);
                    subCsvMetadata.setVisible(false);
                } else {
                    subJsonXmlData.setVisible(true);
                    subTextData.setVisible(false);
                    subCsvData.setVisible(false);
                }
                break;
            case CSV:
                if (isMetadata) {
                    subCsvMetadata.setVisible(true);
                    subJsonXmlMetadata.setVisible(false);
                    subTextMetadata.setVisible(false);
                } else {
                    subCsvData.setVisible(true);
                    subJsonXmlData.setVisible(false);
                    subTextData.setVisible(false);
                }
                break;
            case TEXT:
                if (isMetadata) {
                    subTextMetadata.setVisible(true);
                    subJsonXmlMetadata.setVisible(false);
                    subCsvMetadata.setVisible(false);
                } else {
                    subTextData.setVisible(true);
                    subJsonXmlData.setVisible(false);
                    subCsvData.setVisible(false);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Clears all the fields in the form.
     */
    public void clearAllFields() {
        fileExtension.clear();
        subTextMetadata.clearAllFields();
        subTextData.clearAllFields();
        subJsonXmlMetadata.clearAllFields();
        subJsonXmlData.clearAllFields();
        subCsvMetadata.clearAllFields();
        subCsvData.clearAllFields();
    }

    /**
     * Clears the fields of the sub-components based on the type.
     *
     * @param type the type of parser (Metadata or data)
     */
    public void subFieldsClear(String type) {
        switch (type) {
            case "Metadata":
                subTextMetadata.clearAllFields();
                subJsonXmlMetadata.clearAllFields();
                subCsvMetadata.clearAllFields();
                break;
            case "data":
                subTextData.clearAllFields();
                subJsonXmlData.clearAllFields();
                subCsvData.clearAllFields();
                break;
        }
    }

    /**
     * Sets all sub-components to be invisible.
     */
    public void allVisibleFalse() {
        subJsonXmlMetadata.setVisible(false);
        subJsonXmlData.setVisible(false);
        subTextMetadata.setVisible(false);
        subTextData.setVisible(false);
        subCsvMetadata.setVisible(false);
        subCsvData.setVisible(false);
    }

    /**
     * Creates a horizontal layout with aligned components for a row in the form.
     *
     * @param label the label for the row
     * @param dropdown the dropdown for parser selection
     * @return the created horizontal layout
     */
    private HorizontalLayout createAlignedRowLayout(String label, Select<ParserType> dropdown) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        Span labelSpan = new Span(label);
        labelSpan.getStyle().set("width", "150px");

        dropdown.setWidth("250px");

        layout.add(labelSpan, dropdown);
        return layout;
    }

    /**
     * Sets the items for the dropdown, filtering out certain parser types.
     *
     * @param dropdown the dropdown to set items for
     */
    private void setDropdownItems(Select<ParserType> dropdown) {
        List<ParserType> filteredItems = Arrays.stream(ParserType.values())
                .filter(type -> type != ParserType.CUSTOM)
                .filter(type -> !type.name().startsWith("_"))
                .collect(Collectors.toList());
        dropdown.setItems(filteredItems);
    }
}