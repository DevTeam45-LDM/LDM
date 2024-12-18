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
        configureLayouts(topLayout, selectLayout);

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
        templateGrid.addColumn(TemplateData::getCategory).setHeader("Category").setSortable(true);
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
        visibilityField.setItems(
                "Everyone including anonymous users",
                "Everyone with an account",
                "Only members of the team",
                "Only owner and admins",
                "Only owner"
        );

        TextField templateName = new TextField("Template Name");
        TextField templateDescription = new TextField("Description");

        Button saveButton = new Button("Save", e -> {
                saveTemplate();
                dialog.close();
        });
        Button cancelButton = new Button("Cancel", e -> dialog.close());

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, cancelButton);
        buttonLayout.setJustifyContentMode(JustifyContentMode.END);
        buttonLayout.setWidthFull();

        dialogLayout.add(
                templateName,
                templateDescription,
                categoryType,
                customIdField,
                statusField,
                visibilityField,
                buttonLayout
        );

        dialog.add(dialogLayout);
        dialog.open();
    }

    private void saveTemplate() {
        if (validateForm()) {
            TemplateData template = new TemplateData(
                    null,
                    customIdField.getValue(),
                    categoryType.getValue(),
                    statusField.getValue(),
                    null, // createdAt will be set by service
                    null, // lastModified will be set by service
                    new ArrayList<>(), // tags
                    visibilityField.getValue(),
                    new ArrayList<>() // userGroups
            );

            templateService.createTemplate(template);
            Notification.show("Template saved successfully!");
            loadTemplateData();
        }
    }

    private boolean validateForm() {
        if (categoryType.isEmpty()) {
            Notification.show("Please select a category type");
            return false;
        }
        if (customIdField.isEmpty()) {
            Notification.show("Please enter a template ID");
            return false;
        }
        return true;
    }

    private void editTemplate(TemplateData template) {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Edit Template");

        VerticalLayout dialogLayout = new VerticalLayout();

        ComboBox<String> categoryType = new ComboBox<>("Category");
        categoryType.setItems(template.getPossibleCategroies());
        categoryType.setValue(template.getCategory());

        TextField customIdField = new TextField("Template ID");
        customIdField.setValue(template.getCustomId());

        ComboBox<String> statusField = new ComboBox<>("Status");
        statusField.setItems("Not set", "Active", "Completed");
        statusField.setValue(template.getStatus());

        Button saveButton = new Button("Save", e -> {
            // Update template logic
            templateService.updateTemplate(template.getId(),
                    new TemplateData(
                            template.getId(),
                            customIdField.getValue(),
                            categoryType.getValue(),
                            statusField.getValue(),
                            template.getCreatedAt(),
                            null, // lastModified will be updated by service
                            template.getTags(),
                            template.getBaseAccess(),
                            template.getUserGroups()
                    )
            );
            dialog.close();
            loadTemplateData();
        });

        Button cancelButton = new Button("Cancel", e -> dialog.close());

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, cancelButton);
        dialogLayout.add(categoryType, customIdField, statusField, buttonLayout);

        dialog.add(dialogLayout);
        dialog.open();
    }

    private void loadTemplateData() {
        templateGrid.setItems(templateService.getAllTemplates());
    }
}
