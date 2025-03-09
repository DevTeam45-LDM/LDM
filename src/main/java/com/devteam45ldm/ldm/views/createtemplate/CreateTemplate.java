package com.devteam45ldm.ldm.views.createtemplate;

import com.devteam45ldm.ldm.views.createtemplate.custom.Custom;
import com.devteam45ldm.ldm.views.createtemplate.insertpath.InsertPath;
import com.devteam45ldm.ldm.views.createtemplate.jsonxml.JsonXml;
import com.devteam45ldm.ldm.views.createtemplate.textcsv.TextCsv;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
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
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Composite;
import java.util.stream.Collectors;


/**
 * The CreateTemplate view allows users to create a new template.
 * It provides a form with a select component to choose a template and a button to open a dialog for creating a new template.
 */
@PageTitle("Create Template")
@Route("create-template")
@Menu(order = 2, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@UIScope
public class CreateTemplate extends Composite<VerticalLayout> {
    private final JsonXml JsonAndXmlView;
    private final TextCsv TextAndCsvView;
    private final Custom CustomView;
    private final Select<ParserType> parserDropdown;

    public enum ParserType {
        JSON,
        XML,
        CSV,
        TEXT,
        CUSTOM,
        _CSV,
        _ELAB;
    }


    /**
     * Constructs a new CreateTemplate view.
     * Initializes the layout, select component, and button.
     */
    public CreateTemplate() {
//        TabSheet tabSheet = new TabSheet();
//        tabSheet.setWidth("100%");
//        setTabSheetContent(tabSheet);
        JsonAndXmlView = new JsonXml();
        TextAndCsvView = new TextCsv();
        CustomView = new Custom();

        JsonAndXmlView.setVisible(false);
        TextAndCsvView.setVisible(false);
        CustomView.setVisible(false);

        parserDropdown = new Select<>();
        parserDropdown.setItems(
                Arrays.stream(ParserType.values())
                        .filter(type -> !type.name().startsWith("_"))
                        .collect(Collectors.toList())
        );

        HorizontalLayout headerLayout = new HorizontalLayout(new Span("Parser"), parserDropdown);
//        headerLayout.setWidthFull();
//        headerLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
//        headerLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        parserDropdown.addValueChangeListener(event -> {
            try {
                ParserType selectedValue = event.getValue();
                updateUIForSelection(selectedValue);
            } catch (Exception e) {
                Notification.show("Error: " + e.getMessage());
            }
        });

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(headerLayout, JsonAndXmlView, TextAndCsvView, CustomView);


    }


//        getContent().add(tabSheet,headerLayout);
    }

//    private void setTabSheetContent(TabSheet tabSheet) {
//        tabSheet.add("Json/XML", JsonAndXmlView);
//        tabSheet.add("Text/CSV", TextAndCsvView);
//        tabSheet.add("Custom", CustomView);
//    }


    private void updateUIForSelection(ParserType selectedValue) {
        JsonAndXmlView.setVisible(false);
        TextAndCsvView.setVisible(false);
        CustomView.setVisible(false);

        JsonAndXmlView.getInsertPathComponent().clearAllFields();
        TextAndCsvView.clearAllFields();
        CustomView.clearAllFields();

        switch (selectedValue) {
            case JSON:
            case XML:
                JsonAndXmlView.setVisible(true);
                break;

            case CSV:
            case TEXT:
                TextAndCsvView.setVisible(true);
                break;

            case CUSTOM:
                CustomView.setVisible(true);
                break;

            default:
                break;
        }
    }

}
