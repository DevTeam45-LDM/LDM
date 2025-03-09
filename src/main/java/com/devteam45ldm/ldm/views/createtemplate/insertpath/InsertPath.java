package com.devteam45ldm.ldm.views.createtemplate.insertpath;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class InsertPath extends VerticalLayout {

    private TextField pathToMetadataField;
    private TextField pathToDataField;
    private Checkbox includeSubPathsMetadata;
    private Checkbox includeSubPathsData;

    // Lists to store the entered paths
    private List<String> metadataPaths = new ArrayList<>();
    private List<String> dataPaths = new ArrayList<>();

    // Divs to display the entered paths
    private Div metadataPathsDisplay;
    private Div dataPathsDisplay;

    public InsertPath() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        // Create metadata section
        add(createPathSection("Path to Metadata", (checkbox) -> includeSubPathsMetadata = checkbox,
                (textField) -> pathToMetadataField = textField,
                (display) -> metadataPathsDisplay = display,
                metadataPaths));

        // Create data section
        add(createPathSection("Path to Data", (checkbox) -> includeSubPathsData = checkbox,
                (textField) -> pathToDataField = textField,
                (display) -> dataPathsDisplay = display,
                dataPaths));

        // Apply styling to the main component
        getStyle()
                .set("border", "1px solid #B0C4DE")
                .set("border-radius", "8px");
    }

    // Interface for setting components
    private interface CheckboxSetter { void set(Checkbox checkbox); }
    private interface TextFieldSetter { void set(TextField textField); }
    private interface DisplaySetter { void set(Div display); }

    public void clearAllFields() {
        pathToMetadataField.clear();
        pathToDataField.clear();
    }
    private VerticalLayout createPathSection(String labelText, CheckboxSetter checkboxSetter,
                                             TextFieldSetter textFieldSetter,
                                             DisplaySetter displaySetter,
                                             List<String> pathsList) {
        VerticalLayout section = new VerticalLayout();
        section.setPadding(false);
        section.setSpacing(false);
        section.setWidthFull();

        // Create header with label and checkbox
        HorizontalLayout header = new HorizontalLayout();
        header.setWidthFull();
        header.setPadding(false);

        Span label = new Span(labelText);
        label.getStyle()
                .set("font-weight", "500")
                .set("min-width", "150px");

        Checkbox checkbox = new Checkbox("Include Sub Paths");
        checkboxSetter.set(checkbox); // Set the reference through the interface

        // Push checkbox to right side
        header.add(label, checkbox);
        header.setFlexGrow(1, label);
        header.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        // Create text field for input
        TextField textField = new TextField();
        textField.setWidthFull();
        textFieldSetter.set(textField); // Set the reference

        // Create display for entered paths
        Div pathsDisplay = new Div();
        pathsDisplay.setWidthFull();
        pathsDisplay.getStyle()
                .set("background-color", "var(--lumo-contrast-5pct)")
                .set("border-radius", "4px")
                .set("padding", "8px")
                .set("min-height", "40px")
                .set("margin-top", "4px")
                .set("overflow", "auto"); // Enable scrolling if needed

        displaySetter.set(pathsDisplay); // Set the reference

        // Set up the text field behavior
        setupMultiPathTextField(textField, pathsList, pathsDisplay);

        // Add components to section
        section.add(header, textField, pathsDisplay);

        return section;
    }

    private void setupMultiPathTextField(TextField textField, List<String> pathsList, Div pathsDisplay) {
        // Add key listeners to handle Enter as separator
        textField.addKeyDownListener(Key.ENTER, event -> {
            addPath(textField, pathsList, pathsDisplay);
            textField.focus();
        });

        // Handle comma via value change listener
        textField.addValueChangeListener(event -> {
            String value = event.getValue();
            if (value.contains(",")) {
                // Get parts before the comma(s)
                String[] parts = value.split(",");

                // Process all non-empty parts before the last comma
                for (int i = 0; i < parts.length - 1; i++) {
                    String part = parts[i].trim();
                    if (!part.isEmpty() && !pathsList.contains(part)) {
                        pathsList.add(part);
                    }
                }

                // Keep only the part after the last comma in the textfield
                textField.setValue(parts[parts.length - 1]);

                // Update the display
                updatePathsDisplay(pathsList, pathsDisplay, textField);
            }
        });
    }

    private void addPath(TextField textField, List<String> pathsList, Div pathsDisplay) {
        String path = textField.getValue().trim();

        // Only add non-empty paths that don't already exist
        if (!path.isEmpty() && !pathsList.contains(path)) {
            pathsList.add(path);
            updatePathsDisplay(pathsList, pathsDisplay, textField);
            textField.clear();
        }
    }

    private void updatePathsDisplay(List<String> pathsList, Div pathsDisplay, TextField associatedField) {
        pathsDisplay.removeAll();

        if (pathsList.isEmpty()) {
            return;
        }

        // Create a layout for the path tags - using vertical layout for better handling of long paths
        VerticalLayout tagsContainer = new VerticalLayout();
        tagsContainer.setPadding(false);
        tagsContainer.setSpacing(true);
        tagsContainer.setWidthFull();
        tagsContainer.getStyle().set("gap", "8px");

        // Add each path as a tag with delete button
        for (String path : pathsList) {
            // Create tag layout
            HorizontalLayout tagLayout = new HorizontalLayout();
            tagLayout.setWidthFull();
            tagLayout.setSpacing(false);
            tagLayout.setPadding(false);
            tagLayout.getStyle()
                    .set("background", "var(--lumo-contrast-10pct)")
                    .set("border-radius", "4px")
                    .set("padding", "6px 8px")
                    .set("align-items", "center");

            // Create path label with ellipsis for overflow
            Div pathLabel = new Div();
            pathLabel.setText(path);
            pathLabel.getStyle()
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("overflow", "hidden")
                    .set("text-overflow", "ellipsis")
                    .set("white-space", "nowrap")
                    .set("flex-grow", "1")
                    .set("cursor", "pointer");

            // Add tooltip for the full path
            pathLabel.getElement().setAttribute("title", path);

            // Create delete button
            Button deleteButton = new Button(new Icon(VaadinIcon.CLOSE_SMALL));
            deleteButton.getElement().setAttribute("aria-label", "Remove " + path);
            deleteButton.getStyle()
                    .set("min-width", "24px")
                    .set("width", "24px")
                    .set("height", "24px")
                    .set("padding", "0")
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("margin-left", "8px")
                    .set("flex-shrink", "0");

            // delete button
            deleteButton.addClickListener(event -> {
                pathsList.remove(path);
                updatePathsDisplay(pathsList, pathsDisplay, associatedField);
                associatedField.focus();
            });

            // delete tags
            pathLabel.getElement().addEventListener("click", event -> {
                pathsList.remove(path);
                updatePathsDisplay(pathsList, pathsDisplay, associatedField);
                associatedField.focus();
            });

            // Add hover effect
            String hoverStyle = "this.style.backgroundColor='var(--lumo-contrast-20pct)'";
            String leaveStyle = "this.style.backgroundColor='var(--lumo-contrast-10pct)'";
            tagLayout.getElement().executeJs("this.onmouseover = function() {" + hoverStyle + "};");
            tagLayout.getElement().executeJs("this.onmouseout = function() {" + leaveStyle + "};");

            tagLayout.add(pathLabel, deleteButton);
            tagsContainer.add(tagLayout);
        }

        pathsDisplay.add(tagsContainer);
    }

    // Getter methods to access the paths and checkbox values
    public List<String> getMetadataPaths() {
        return new ArrayList<>(metadataPaths);
    }

    public List<String> getDataPaths() {
        return new ArrayList<>(dataPaths);
    }

    public boolean isIncludeSubPathsMetadata() {
        return includeSubPathsMetadata.getValue();
    }

    public boolean isIncludeSubPathsData() {
        return includeSubPathsData.getValue();
    }
}