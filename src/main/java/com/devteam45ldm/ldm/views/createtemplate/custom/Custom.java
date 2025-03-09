package com.devteam45ldm.ldm.views.createtemplate.custom;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
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

@PageTitle("Text CSV")
@Route("text-csv")
public class Custom extends Composite<VerticalLayout> {

    private final TextField fileExtension;
    private final Select<ParserType> metadataParserDropdown;
    private final Select<ParserType> dataParserDropdown;

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
        fileExtension = new TextField();
        metadataParserDropdown = new Select<>();
        dataParserDropdown = new Select<>();

        setDropdownItems(metadataParserDropdown);
        setDropdownItems(dataParserDropdown);

        HorizontalLayout fileExtensionLayout = createAlignedRowLayout("File Extension", fileExtension);
        HorizontalLayout metadataParserLayout = createAlignedRowLayout("Metadata Parser", metadataParserDropdown);
        HorizontalLayout dataParserLayout = createAlignedRowLayout("Data Parser", dataParserDropdown);

        VerticalLayout verticalLayout = new VerticalLayout(
                fileExtensionLayout,
                metadataParserLayout,
                dataParserLayout
        );

        verticalLayout.getStyle().set("border", "2px solid black");
        verticalLayout.getStyle().set("padding", "20px");
        verticalLayout.getStyle().set("border-radius", "10px");
        verticalLayout.getStyle().set("width", "fit-content");
        verticalLayout.getStyle().set("display", "inline-block");

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }

    private void setDropdownItems(Select<ParserType> dropdown) {
        List<ParserType> filteredItems = Arrays.stream(ParserType.values())
                .filter(type -> type != ParserType.CUSTOM)
                .collect(Collectors.toList());
        dropdown.setItems(filteredItems);
    }

    private HorizontalLayout createAlignedRowLayout(String label, com.vaadin.flow.component.Component component) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        Span labelSpan = new Span(label);
        labelSpan.getStyle().set("width", "150px");
        layout.add(labelSpan, component);

        return layout;
    }
}