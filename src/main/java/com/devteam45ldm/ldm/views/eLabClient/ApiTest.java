package com.devteam45ldm.ldm.views.eLabClient;

import com.devteam45ldm.ldm.views.eLabClient.experiments.ExperimentTemplates;
import com.devteam45ldm.ldm.views.eLabClient.experiments.Experiments;
import com.devteam45ldm.ldm.views.eLabClient.tags.Tags;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@PageTitle("API Tests")
@Route("api-test")
@Menu(order = 1, icon = "line-awesome/svg/flask-solid.svg")
@UIScope
public class ApiTest extends Composite<VerticalLayout> {

    public ApiTest() {
        TabSheet tabSheet = new TabSheet();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        tabSheet.setWidth("100%");
        setTabSheetContent(tabSheet);
        getContent().add(tabSheet);
    }

    private void setTabSheetContent(TabSheet tabSheet) {
        tabSheet.add("Tags", new Tags());
        tabSheet.add("ExperimentTemplates", new ExperimentTemplates());
        tabSheet.add("Experiments", new Experiments());
    }
}