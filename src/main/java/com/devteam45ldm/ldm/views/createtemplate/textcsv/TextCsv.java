package com.devteam45ldm.ldm.views.createtemplate.textcsv;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

@PageTitle("Text CSV")
@Route("text-csv")
@Menu(order = 2, icon = "line-awesome/svg/file-csv-solid.svg")
public class TextCsv extends Composite<VerticalLayout> {

    public TextCsv() {
        // Parser Dropdown
        ComboBox<String> parserDropdown = new ComboBox<>("Parser");
        parserDropdown.setItems("Type 1", "Type 2", "Type 3"); // 예제 데이터

        // File Extension
        TextField fileExtensionField = new TextField("File Extension");

        // Form Layout
        FormLayout formLayout = new FormLayout();

        // Metadata and Data sections
        TextField skipLineField = createLabeledTextField("Skip Line");
        TextField lineBeginField = createLabeledTextField("Line Begin");
        TextField assignmentsField = createLabeledTextField("Assignments");
        TextField delimiterField = createLabeledTextField("Delimiter");
        TextField terminatorField = createLabeledTextField("Terminator");

        TextField metadataField = new TextField();
        metadataField.setPlaceholder("Metadata Input");

        TextField dataField = new TextField();
        dataField.setPlaceholder("Data Input");

        formLayout.add(skipLineField, metadataField, dataField);
        formLayout.add(lineBeginField, new TextField(), new TextField());
        formLayout.add(assignmentsField, new TextField(), new TextField());
        formLayout.add(delimiterField, new TextField(), new TextField());
        formLayout.add(terminatorField, new TextField(), new TextField());

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(parserDropdown, fileExtensionField, formLayout);
    }

    private TextField createLabeledTextField(String label) {
        TextField textField = new TextField(label);
        Icon infoIcon = new Icon(VaadinIcon.INFO_CIRCLE);
        Tooltip.forComponent(infoIcon).setText("Information about " + label);
        infoIcon.getElement().setAttribute("style", "cursor: pointer; margin-left: 5px;");

        VerticalLayout container = new VerticalLayout(textField, infoIcon);
        container.setSpacing(false);
        return textField;
    }
}