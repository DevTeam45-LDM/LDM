package com.devteam45ldm.ldm.views.createtemplate.csv;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("SUBCSV")
@Route("subcsv")
public class SubCsv extends Composite<VerticalLayout> {

    private final TextField skipLineMetadata = new TextField();
    private final TextField skipLineData = new TextField();
    private final TextField totalColumnsMetadata = new TextField();
    private final TextField totalColumnsData = new TextField();
    private final TextField hasHeadlineMetadata = new TextField();
    private final TextField hasHeadlineData = new TextField();
    private final TextField delimiterMetadata = new TextField();
    private final TextField delimiterData = new TextField();

    public SubCsv(String string) {

        HorizontalLayout metadataDataHeader = new HorizontalLayout();
        metadataDataHeader.setWidthFull();
        metadataDataHeader.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        metadataDataHeader.getStyle().set("font-weight", "bold");

        Span dataLabel = new Span(string);
        dataLabel.getStyle().set("margin-left", "200px");

        metadataDataHeader.add(dataLabel);

        VerticalLayout verticalLayout = new VerticalLayout(
                metadataDataHeader,
                createAlignedRowLayout("Has Headline", "Is there a line to be treated as a headline?\n" +
                        "Lines with only spaces and \\n are ignored.",hasHeadlineMetadata),
                createAlignedRowLayout("Total Columns", "Total amount of columns in the data.",totalColumnsMetadata),
                createAlignedRowLayout("Delimiter", "Delimiter for data e.g. a csv delimiter.",delimiterMetadata),
                createAlignedRowLayout("Skip Lines", "Amount of lines to skip after the headline (pattern).",skipLineMetadata)
        );

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }
    public void clearAllFields() {
        skipLineMetadata.clear();
        skipLineData.clear();
        totalColumnsMetadata.clear();
        totalColumnsData.clear();
        hasHeadlineMetadata.clear();
        hasHeadlineData.clear();
        delimiterMetadata.clear();
        delimiterData.clear();
    }
    private HorizontalLayout createAlignedRowLayout(String label, String infoLabel,TextField metadataField) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        Span labelSpan = new Span(label);
        labelSpan.setWidth("100px");

        Icon infoIcon = createInfoIcon(infoLabel);
        infoIcon.getStyle().set("margin-right", "10px");

        metadataField.setWidth("250px");

        layout.add(labelSpan, infoIcon, metadataField);
        return layout;
    }

    private Icon createInfoIcon(String label) {
        Icon infoIcon = new Icon(VaadinIcon.INFO_CIRCLE_O);
        infoIcon.getElement().setAttribute("style", "cursor: pointer; color: #007bff;");
        Dialog infoDialog = new Dialog();
        infoDialog.add(new Span(label));
        infoIcon.addClickListener(event -> infoDialog.open());
        getContent().add(infoDialog);
        return infoIcon;
    }
}
