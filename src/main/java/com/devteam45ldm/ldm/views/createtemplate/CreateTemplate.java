package com.devteam45ldm.ldm.views.createtemplate;

import com.devteam45ldm.ldm.data.TemplateData;
import com.devteam45ldm.ldm.services.TemplateService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Create Template")
@Route("create-template")
@Menu(order = 2, icon = "line-awesome/svg/pencil-ruler-solid.svg")
public class CreateTemplate extends Composite<VerticalLayout> {

    private final TemplateService templateService;
    private final Grid<TemplateData> templateGrid;
    private ComboBox<String> categoryType;
    private TextField customIdField;
    private ComboBox<String> statusField;
    private ComboBox<String> visibilityField;

    public CreateTemplate() {
        this.templateService = new TemplateService();
        this.templateGrid = new Grid<>();

        // Top section
        HorizontalLayout topLayout = new HorizontalLayout();
        HorizontalLayout selectLayout = new HorizontalLayout();
        Select select = new Select();
        Button createButton = new Button();

        // Configure layouts
        configureLayouts(layoutRow, layoutRow2);

        // Configure select
        select.setLabel("Select Your Template");
        select.setWidth("min-content");
        setSelectSampleData(select);

        // Configure button and dialog
        createButton.setText("Create Template");
        createButton.setWidth("min-content");
        createButton.addClickListener(e -> showCreateTemplateDialog());

        // Configure grid
        configureTemplateGrid();

        getContent().add(topLayout);
        topLayout.add(selectLayout);
        selectLayout.add(select);
        topLayout.add(createButton);
        getContent().add(createButton);

        // Load initial data
        loadTemplateData();
    }

    private void configureTemplateGrid() {
        templateGrid.addColumn(TemplateData::getCustomId).setHeader("ID").setSortable(true);
        templateGrid.addColumn(TemplateData::getCategoryType).setHeader("Type").setSortable(true);
        templateGrid.addColumn(TemplateData::getStatus).setHeader("Status").setSortable(true);
        templateGrid.addColumn(TemplateData::getCreatedAt).setHeader("Created").setSortable(true);
        templateGrid.addColumn(TemplateData::getLastModified).setHeader("Modified").setSortable(true);

        templateGrid.addComponentColumn(template -> {
            Button editButton = new Button("Edit");
            editButton.addClickListener(e -> editTemplate(template));
            return editButton;
        });

        //templateGrid.setHeightByRows(true);
        templateGrid.addClassName(Padding.MEDIUM);
    }

    private void configureLayouts(HorizontalLayout layoutRow, HorizontalLayout layoutRow2) {
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

        // Initialize form components
        categoryType = new ComboBox<>("Category Type");
        categoryType.setItems(List.of(
                "Not set",
                "TRR270 Cluster Meetings",
                "Sub-Project",
                "Publication",
                "Equipment",
                "Technique",
                "Material",
                "Sample"));
        customIdField = new TextField("Template ID");

        statusField = new ComboBox<>("Status");
        statusField.setItems("Not set", "Active", "completed");

        visibilityField = new ComboBox<>("Visibility");
        visibilityField.setItems();

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
