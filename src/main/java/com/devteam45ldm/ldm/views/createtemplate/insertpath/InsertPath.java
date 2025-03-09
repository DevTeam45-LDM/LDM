package com.devteam45ldm.ldm.views.createtemplate.insertpath;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class InsertPath extends HorizontalLayout {

    private TextField pathToMetadataField;
    private TextField pathToDataField;
    private Checkbox includeSubPathsMetadata;
    private Checkbox includeSubPathsData;

    public InsertPath() {
        setWidthFull();
        setSpacing(true);

        // Create left column for text fields
        VerticalLayout leftColumn = new VerticalLayout();
        leftColumn.setPadding(false);
        leftColumn.setSpacing(true);
        leftColumn.setWidth("50%");

        // Create right column for checkboxes
        VerticalLayout rightColumn = new VerticalLayout();
        rightColumn.setPadding(false);
        rightColumn.setSpacing(true);
        rightColumn.setWidth("50%");

        // REMOVE THIS LINE - it's causing the alignment issue
        // rightColumn.setAlignItems(FlexComponent.Alignment.END);

        // Create text fields with labels
        pathToMetadataField = getLabeledTextfield(leftColumn, "Path to Metadata");
        pathToDataField = getLabeledTextfield(leftColumn, "Path to Data");

        // Create checkboxes with labels
        includeSubPathsMetadata = getLabeledCheckbox(rightColumn, "Include Sub Paths");
        includeSubPathsData = getLabeledCheckbox(rightColumn, "Include Sub Paths");

        // Set explicit horizontal alignment for checkboxes and their layouts to START
        rightColumn.setHorizontalComponentAlignment(FlexComponent.Alignment.START, includeSubPathsMetadata);
        rightColumn.setHorizontalComponentAlignment(FlexComponent.Alignment.START, includeSubPathsData);

        // Add both columns to this layout
        add(leftColumn, rightColumn);

        // Apply styling
        getStyle()
                .set("border", "1px solid #B0C4DE")
                .set("border-radius", "8px")
                .set("padding", "20px");
    }

    private TextField getLabeledTextfield(VerticalLayout v, String labelName) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setWidthFull(); // Make layout take full width of the column

        // Create label
        Div label = new Div();
        label.setText(labelName);
        label.getStyle().set("min-width", "150px");

        TextField t1 = new TextField();
        t1.setWidth("50%");

        layout.add(label, t1);
        v.add(layout);

        return t1;
    }

    private Checkbox getLabeledCheckbox(VerticalLayout v, String labelName) {
        // Create horizontal layout for the label and checkbox
        HorizontalLayout layout = new HorizontalLayout();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setSpacing(true);
        layout.setWidthFull(); // Make it take full width

        // This is crucial - align items to the start (left)
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        // Create label
        Div label = new Div();
        label.setText(labelName);
        label.getStyle().set("min-width", "150px");

        // Create checkbox
        Checkbox checkbox = new Checkbox();

        // Add label and checkbox to the layout
        layout.add(label, checkbox);

        v.add(layout);

        // Apply START alignment to this specific layout
        v.setHorizontalComponentAlignment(FlexComponent.Alignment.START, layout);

        return checkbox;
    }
}