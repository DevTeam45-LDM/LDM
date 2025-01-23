package com.devteam45ldm.ldm.views.importFiles;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Import Files")
@Route("import-files")
@Menu(order = 2, icon = "line-awesome/svg/filter-solid.svg")
public class ImportFilesView extends Composite<VerticalLayout> {

    public ImportFilesView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        ComboBox comboBox3 = new ComboBox();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        comboBox.setLabel("Messgerät");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        comboBox2.setLabel("Template");
        comboBox2.setWidth("min-content");
        setComboBoxSampleData(comboBox2);
        comboBox3.setLabel("Template Version");
        comboBox3.setWidth("min-content");
        setComboBoxSampleData(comboBox3);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(comboBox);
        layoutColumn3.add(comboBox2);
        layoutColumn3.add(comboBox3);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("MeasureDevice1", "MeasureDevice1", null));
        sampleItems.add(new SampleItem("MeasureDevice2", "MeasureDevice2", null));
        sampleItems.add(new SampleItem("MeasureDevice3", "MeasureDevice3", Boolean.TRUE));
        sampleItems.add(new SampleItem("MeasureDevice4", "MeasureDevice4", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
