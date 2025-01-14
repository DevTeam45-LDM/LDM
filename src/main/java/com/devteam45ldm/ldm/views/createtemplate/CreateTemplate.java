package com.devteam45ldm.ldm.views.createtemplate;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
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

@PageTitle("Create Template")
@Route("create-template")
@Menu(order = 2, icon = "line-awesome/svg/pencil-ruler-solid.svg")
public class CreateTemplate extends Composite<VerticalLayout> {


    public CreateTemplate() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        Select select = new Select();
        Button buttonSecondary = new Button();

        // Configure layouts
        configureLayouts(layoutRow, layoutRow2, select, buttonSecondary);

        // Configure select
        select.setLabel("Select Your Template");
        select.setWidth("min-content");
        setSelectSampleData(select);

        // Configure button and dialog
        buttonSecondary.setText("Create Template");
        buttonSecondary.setWidth("min-content");
        buttonSecondary.addClickListener(e -> showCreateTemplateDialog());

        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(select);
        layoutRow.add(buttonSecondary);
    }

    private void configureLayouts(HorizontalLayout layoutRow, HorizontalLayout layoutRow2, Select select, Button buttonSecondary) {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.addClassName(Padding.XSMALL);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.END);
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.addClassName(Padding.XSMALL);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        select.setLabel("Select Your Template");
        select.setWidth("min-content");
        setSelectSampleData(select);
        buttonSecondary.setText("Create Template");
        buttonSecondary.setWidth("min-content");
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(select);
        layoutRow.add(buttonSecondary);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "v1", null));
        sampleItems.add(new SampleItem("second", "v2", null));
        sampleItems.add(new SampleItem("third", "v3", null));
        sampleItems.add(new SampleItem("fourth", "v4", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }

    private void showCreateTemplateDialog() {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Create Template");

        VerticalLayout dialogLayout = new VerticalLayout();
        TextField templateName = new TextField("Template Name");
        TextField templateDescription = new TextField("Description");

        Button saveButton = new Button("Save", e -> {
                // Add save logic here
                dialog.close();
        });
        Button cancelButton = new Button("Cancel", e -> dialog.close());

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, cancelButton);
        dialogLayout.add(templateName, templateDescription, buttonLayout);

        dialog.add(dialogLayout);
        dialog.open();
    }
}
