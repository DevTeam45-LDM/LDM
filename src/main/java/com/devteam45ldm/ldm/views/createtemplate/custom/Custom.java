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

    public enum ParserType {
        JSON,
        XML,
        CSV,
        TEXT,
        CUSTOM,
        _CSV,
        _ELAB;
    }

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

    private void updateVisibility(ParserType selectedValue, String type) {
//        if(selectedValue == null){
//            Notification.show("No Parser Selected");
//            return;
//        }


        boolean isMetadata = "Metadata".equals(type);

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
                if(isMetadata) {
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
                subJsonXmlMetadata.setVisible(false);
                subJsonXmlData.setVisible(false);
                subTextMetadata.setVisible(false);
                subTextData.setVisible(false);
                subCsvMetadata.setVisible(false);
                subCsvData.setVisible(false);
                subFieldsClear();
                break;
        }
    }

    public void clearAllFields() {
        fileExtension.clear();
        subTextMetadata.clearAllFields();
        subTextData.clearAllFields();
        subJsonXmlMetadata.getInsertPath().clearAllFields();
        subJsonXmlData.getInsertPath().clearAllFields();
        subCsvMetadata.clearAllFields();
        subCsvData.clearAllFields();
    }

    public void subFieldsClear() {
        subTextMetadata.clearAllFields();
        subTextData.clearAllFields();
        subJsonXmlMetadata.getInsertPath().clearAllFields();
        subJsonXmlData.getInsertPath().clearAllFields();
        subCsvMetadata.clearAllFields();
        subCsvData.clearAllFields();
    }

//    public void dropdownClear() {
//        metadataParserDropdown.clear();
//        dataParserDropdown.clear();
//    }

    public void allVisibleFalse() {
        subJsonXmlMetadata.setVisible(false);
        subJsonXmlData.setVisible(false);
        subTextMetadata.setVisible(false);
        subTextData.setVisible(false);
        subCsvMetadata.setVisible(false);
        subCsvData.setVisible(false);
    }

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

    private void setDropdownItems(Select<ParserType> dropdown) {
        List<ParserType> filteredItems = Arrays.stream(ParserType.values())
                .filter(type -> type != ParserType.CUSTOM)
                .filter(type -> !type.name().startsWith("_"))
                .collect(Collectors.toList());
        dropdown.setItems(filteredItems);
    }
}
