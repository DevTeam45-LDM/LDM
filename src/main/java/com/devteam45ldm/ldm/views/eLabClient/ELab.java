package com.devteam45ldm.ldm.views.eLabClient;

import com.devteam45ldm.ldm.views.eLabClient.experiments.ExperimentTemplates;
import com.devteam45ldm.ldm.views.eLabClient.experiments.Experiments;
import com.devteam45ldm.ldm.views.eLabClient.createReport.CreateReport;
import com.devteam45ldm.ldm.views.eLabClient.login.Login;
import com.devteam45ldm.ldm.views.eLabClient.login.LoginEvent;
import com.devteam45ldm.ldm.views.eLabClient.login.LoginEventListener;
import com.devteam45ldm.ldm.views.eLabClient.tags.Tags;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@PageTitle("eLab")
@Route("elab")
@Menu(order = 1, icon = "line-awesome/svg/flask-solid.svg")
@UIScope
public class ELab extends Composite<VerticalLayout> implements LoginEventListener {

    private final Login login;
    private final Tags tags;
    private final ExperimentTemplates experimentTemplates;
    private final Experiments experiments;
    private final CreateReport createReport;


    @Autowired
    public ELab(Login login, Tags tags, ExperimentTemplates experimentTemplates, Experiments experiments, CreateReport createReport) {
        this.login = login;
        this.tags = tags;
        this.experimentTemplates = experimentTemplates;
        this.experiments = experiments;
        this.createReport = createReport;

        TabSheet tabSheet = new TabSheet();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        tabSheet.setWidth("100%");
        setTabSheetContent(tabSheet);
        getContent().add(tabSheet);

        // Add the LoginEventListener to the Login instance
        login.addLoginEventListener(this);
    }

    private void setTabSheetContent(TabSheet tabSheet) {
        tabSheet.add("Login", login);
        tabSheet.add("Tags", tags);
        tabSheet.add("Experiment Templates", experimentTemplates);
        tabSheet.add("Experiments", experiments);
        tabSheet.add("Create Report", createReport);
    }

    @Override
    public void onLogin(LoginEvent event) {
        String url = event.getUrl();
        String apiKey = event.getApiKey();

        tags.setCredentials(apiKey, url);
        experimentTemplates.setCredentials(apiKey, url);
        experiments.setCredentials(apiKey, url);
        createReport.setCredentials(apiKey, url);
    }
}