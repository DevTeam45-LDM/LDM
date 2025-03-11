package com.devteam45ldm.ldm.views.createtemplate.jsonxml;

import com.devteam45ldm.ldm.views.createtemplate.insertpath.InsertPath;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The `JsonXml` class represents a UI component for creating a JSON or XML template.
 * It provides a form with fields for metadata and data paths.
 */
public class JsonXml extends Composite<VerticalLayout> {

    private InsertPath insertPathToMetadata;
    private InsertPath insertPathToData;

    /**
     * Constructs a new `JsonXml` instance.
     * Initializes the layout and form fields.
     */
    public JsonXml() {
        VerticalLayout contentLayout = getContent();
        contentLayout.setPadding(true);
        contentLayout.setSpacing(false);

        insertPathToMetadata = new InsertPath("Path to Metadata");
        insertPathToData = new InsertPath("Path to Data");
        contentLayout.add(insertPathToMetadata, insertPathToData);
    }

    /**
     * Clears all the fields in the form.
     */
    public void clearAllFields() {
        insertPathToMetadata.clearAllFields();
        insertPathToData.clearAllFields();
    }
}