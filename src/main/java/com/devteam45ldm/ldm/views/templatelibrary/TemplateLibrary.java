package com.devteam45ldm.ldm.views.templatelibrary;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.devteam45ldm.ldm.parser.templates.Metadata;

@PageTitle("Template Library")
@Route("template-library")
@Menu(order = 3, icon = "line-awesome/svg/filter-solid.svg")
public class TemplateLibrary extends Composite<VerticalLayout> {

    private Grid<YourDataModel> grid;

    public TemplateLibrary() {
        addClassName("data-table-view");
        getContent().setSizeFull();
        configureGrid();
        getContent().add(grid);
    }

    private void configureGrid() {
        grid = new Grid<>(YourDataModel.class);
        grid.addClassName("data-table");
        grid.setSizeFull();

        // Remove default columns that are automatically generated from the entity properties
        grid.removeAllColumns();

        // Add columns manually for better control - these are just examples
        // Replace with your actual properties and customize as needed
        grid.addColumn(YourDataModel::getId)
                .setHeader("ID")
                .setSortable(true)
                .setAutoWidth(true)
                .setFlexGrow(0);

        grid.addColumn(YourDataModel::getName)
                .setHeader("Version")
                .setSortable(true)
                .setAutoWidth(true);

        grid.addColumn(YourDataModel::getName)
                .setHeader("createdBy")
                .setSortable(true)
                .setAutoWidth(true);

        grid.addColumn(YourDataModel::getName)
                .setHeader("createdAt")
                .setSortable(true)
                .setAutoWidth(true);

        grid.addColumn(YourDataModel::getName)
                .setHeader("lastModifiedBy")
                .setSortable(true)
                .setAutoWidth(true);

        grid.addColumn(YourDataModel::getName)
                .setHeader("lastModifiedAt")
                .setSortable(true)
                .setAutoWidth(true);

        grid.addColumn(YourDataModel::getName)
                .setHeader("datatype")
                .setSortable(true)
                .setAutoWidth(true);

        grid.addColumn(YourDataModel::getName)
                .setHeader("parserType")
                .setSortable(true)
                .setAutoWidth(true);
    }

    // Method to set data to the grid once you have it from your database
    public void updateList(java.util.List<YourDataModel> items) {
        grid.setItems(items);
    }

    // Placeholder for your data model
    // Replace with your actual entity class or create a separate file
    public static class YourDataModel {
        private Long id;
        private String name;
        // Add more properties as needed

        // Constructor
        public YourDataModel() {
        }

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Add more getters and setters for additional properties
    }
}
