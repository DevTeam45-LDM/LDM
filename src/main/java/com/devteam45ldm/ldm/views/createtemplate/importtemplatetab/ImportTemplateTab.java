package com.devteam45ldm.ldm.views.createtemplate.importtemplatetab;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class ImportTemplateTab extends Composite<VerticalLayout> { // ✅ Component 확장
    private final ImportedData importedData;
    private final ImportMappings importMappings;
    private final ImportParserMappings importParserMappings;
    private final ImportTemplateTab importTemplate;

    public ImportTemplateTab() {
        importedData = new ImportedData();
        importMappings = new ImportMappings();
        importParserMappings = new ImportParserMappings();
        importTemplate = new ImportTemplateTab();



    }
}
