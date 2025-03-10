package com.devteam45ldm.ldm.views.createtemplate.custom;

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
    private final SubText subTextMetadata = new SubText("Metadata");
    private final SubText subTextData = new SubText("Data");

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

        setDropdownItems(metadataParserDropdown);
        setDropdownItems(dataParserDropdown);

        metadataParserDropdown.addValueChangeListener(event -> {
            try {
                updateVisibility(event.getValue(), "Metadata");
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });
        dataParserDropdown.addValueChangeListener(event -> {
            try {
                updateVisibility(event.getValue(), "data");
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        subTextMetadata.setVisible(false);
        subTextData.setVisible(false);

        VerticalLayout verticalLayout = new VerticalLayout(
                fileExtensionLayout,
                createAlignedRowLayout("Metadata Parser", metadataParserDropdown),
                subTextMetadata,
                createAlignedRowLayout("Data Parser", dataParserDropdown),
                subTextData
        );

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }

    private void updateVisibility(ParserType selectedValue, String type) {

        if (selectedValue == ParserType.CSV || selectedValue == ParserType.TEXT) {
            if (type.equals("Metadata")) {
                subTextMetadata.setVisible(true);
            } else {
                subTextData.setVisible(true);
            }
        }
    }

    public void clearAllFields() {
        fileExtension.clear();
        metadataParserDropdown.clear();
        dataParserDropdown.clear();
//        subTextMetadata.setVisible(false);
//        subTextData.setVisible(false);
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
