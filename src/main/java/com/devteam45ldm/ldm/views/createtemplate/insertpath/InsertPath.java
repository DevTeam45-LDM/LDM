package com.devteam45ldm.ldm.views.createtemplate.insertpath;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Composite;

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

        // Add this line to push the checkboxes to the right side
        rightColumn.setAlignItems(FlexComponent.Alignment.END);

        // Create text fields with labels
        pathToMetadataField = getLabeledTextfield(leftColumn, "Path to Metadata");
        pathToDataField = getLabeledTextfield(leftColumn, "Path to Data");

        // Create checkboxes with labels
        includeSubPathsMetadata = getLabeledCheckbox(rightColumn, "Include Sub Paths");
        includeSubPathsData = getLabeledCheckbox(rightColumn, "Include Sub Paths");

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

        // Create label
        Div label = new Div();
        label.setText(labelName);
        label.getStyle().set("min-width", "150px");

        TextField t1 = new TextField();
        t1.setWidthFull();

        layout.add(label, t1);

        v.add(layout);

        return t1;
    }

    private Checkbox getLabeledCheckbox(VerticalLayout v, String labelName) {
        // Create horizontal layout for the label and checkbox
        HorizontalLayout layout = new HorizontalLayout();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        // Create label
        Div label = new Div();
        label.setText(labelName);
        label.getStyle().set("min-width", "150px");

        // Create checkbox
        Checkbox checkbox = new Checkbox();

        // Add label and checkbox to the layout
        layout.add(label, checkbox);

        v.add(layout);

        return checkbox;
    }

    private void applyStyles(VerticalLayout leftColumn, VerticalLayout rightColumn, HorizontalLayout mainLayout) {
        // Apply styles to columns for better alignment
        leftColumn.setWidth("50%");
        rightColumn.setWidth("50%");

        // Add a border to the main layout to match the screenshot
        mainLayout.getStyle()
                .set("border", "1px solid #B0C4DE")
                .set("border-radius", "8px")
                .set("padding", "20px");
    }
}
