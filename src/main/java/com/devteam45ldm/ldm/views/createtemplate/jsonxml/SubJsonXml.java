package com.devteam45ldm.ldm.views.createtemplate.jsonxml;

import com.devteam45ldm.ldm.views.createtemplate.insertpath.InsertPath;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;

public class SubJsonXml extends Composite<VerticalLayout> {

    private InsertPath insertPath;

    public SubJsonXml(String string) {

        VerticalLayout contentLayout = getContent();
        contentLayout.setPadding(true);
        contentLayout.setSpacing(false);

        insertPath = new InsertPath(string);
        contentLayout.add(insertPath);

    }

    public InsertPath getInsertPath() {
        return insertPath;
    }

}