package com.devteam45ldm.ldm.views.createtemplate;

import com.devteam45ldm.ldm.views.createtemplate.custom.Custom;
import com.devteam45ldm.ldm.views.createtemplate.jsonxml.JsonXml;
import com.devteam45ldm.ldm.views.createtemplate.textcsv.TextCsv;
import com.devteam45ldm.ldm.views.eLabClient.createReport.CreateReport;
import com.devteam45ldm.ldm.views.eLabClient.experiments.ExperimentTemplates;
import com.devteam45ldm.ldm.views.eLabClient.experiments.Experiments;
import com.devteam45ldm.ldm.views.eLabClient.login.Login;
import com.devteam45ldm.ldm.views.eLabClient.tags.Tags;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;

/**
 * The CreateTemplate view allows users to create a new template.
 * It provides a form with a select component to choose a template and a button to open a dialog for creating a new template.
 */
@PageTitle("Create Template")
@Route("create-template")
@Menu(order = 2, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@UIScope
public class CreateTemplate extends Composite<VerticalLayout> {

    private final JsonXml JsonAndXmlView = new JsonXml();
    private final TextCsv TextAndCsvView = new TextCsv();
    private final Custom CustomView = new Custom();

    /**
     * Constructs a new CreateTemplate view.
     * Initializes the layout, select component, and button.
     */
    public CreateTemplate() {
        TabSheet tabSheet = new TabSheet();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        tabSheet.setWidth("100%");
        setTabSheetContent(tabSheet);
        getContent().add(tabSheet);
    }

    private void setTabSheetContent(TabSheet tabSheet) {
        tabSheet.add("Json/XML", JsonAndXmlView);
        tabSheet.add("Text/CSV", TextAndCsvView);
        tabSheet.add("Custom", CustomView);
    }





}