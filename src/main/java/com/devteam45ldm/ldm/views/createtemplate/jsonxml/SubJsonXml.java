package com.devteam45ldm.ldm.views.createtemplate.jsonxml;

import com.devteam45ldm.ldm.views.createtemplate.insertpath.InsertPath;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The `SubJsonXml` class represents a UI component for creating a sub-JSON or sub-XML template.
 * It provides a form with fields for metadata and data paths.
 */
public class SubJsonXml extends Composite<VerticalLayout> {

    private InsertPath insertPath;

    /**
     * Constructs a new `SubJsonXml` instance.
     * Initializes the layout and form fields.
     *
     * @param string the label for the data section
     */
    public SubJsonXml(String string) {
        VerticalLayout contentLayout = getContent();
        contentLayout.setPadding(true);
        contentLayout.setSpacing(false);

        insertPath = new InsertPath(string);
        contentLayout.add(insertPath);
    }

    /**
     * Clears all the fields in the form.
     */
    public void clearAllFields() {
        insertPath.clearAllFields();
    }
}