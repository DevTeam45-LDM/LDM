package com.devteam45ldm.ldm.views.createtemplate.jsonxml;

import com.devteam45ldm.ldm.views.createtemplate.insertpath.InsertPath;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;

public class JsonXml extends Composite<VerticalLayout> {

    private InsertPath insertPathComponent;

    public JsonXml() {

        VerticalLayout contentLayout = getContent();
        contentLayout.setPadding(true);
        contentLayout.setSpacing(false);

        insertPathComponent = new InsertPath();
        contentLayout.add(insertPathComponent);

    }

    public InsertPath getInsertPathComponent() {
        return insertPathComponent;
    }
}