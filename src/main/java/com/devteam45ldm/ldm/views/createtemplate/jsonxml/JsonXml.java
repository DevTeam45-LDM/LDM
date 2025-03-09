package com.devteam45ldm.ldm.views.createtemplate.jsonxml;

import com.devteam45ldm.ldm.views.createtemplate.insertpath.InsertPath;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;

public class JsonXml extends Composite<VerticalLayout> {

    private InsertPath insertPathToMetadata;
    private InsertPath insertPathToData;

    public JsonXml() {

        VerticalLayout contentLayout = getContent();
        contentLayout.setPadding(true);
        contentLayout.setSpacing(false);

        insertPathToMetadata = new InsertPath("Path to Metadata");
        insertPathToData = new InsertPath("Path to Data");
        contentLayout.add(insertPathToMetadata, insertPathToData);

    }

    public InsertPath getInsertPathToMetadata() {
        return insertPathToMetadata;
    }
    public InsertPath getInsertPathToData() {
        return insertPathToData;
    }
}