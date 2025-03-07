package com.devteam45ldm.ldm.views.createtemplate.textcsv;


import com.devteam45ldm.ldm.views.createtemplate.parserTemplate.ParserTemplate;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
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
public class TextCsv extends Composite<VerticalLayout> {

    private final ParserTemplate parserTemplate = new ParserTemplate();
    private final TextField fileExtension = new TextField();
    private final TextField skipLine = new TextField();
    private final TextField lineBegin = new TextField();
    private final TextField Assignments = new TextField();
    private final TextField Delimiter = new TextField();
    private final TextField Terminator = new TextField();

    public TextCsv() {
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.add(new Span("Parser"), parserTemplate);



//        Icon infoIcon = VaadinIcon.INFO_CIRCLE_O.create();
//        infoIcon.getElement().setAttribute("style", "cursor: pointer; color: #007bff;"); // 파란색 클릭 가능 스타일 적용
//
//        // Tooltip 추가
//        Tooltip tooltip = Tooltip.forComponent(infoIcon);
//        tooltip.setText("Information about File Extension");
//        tooltip.setPosition(Tooltip.TooltipPosition.TOP); // 툴팁 위치 설정
//
//        // 아이콘 클릭 시 툴팁을 토글하는 버튼 추가 (옵션)
//        Button toggleTooltip = new Button(infoIcon, event -> {
//            tooltip.setOpened(!tooltip.isOpened()); // 툴팁 토글 기능
//        });
//        toggleTooltip.getStyle().set("border", "none").set("background", "none").set("padding", "0");

        // Labels and Input Fields
        HorizontalLayout fileExtensionLayout = new HorizontalLayout();
        fileExtensionLayout.setWidthFull();
        fileExtensionLayout.add(new Span("File Extension"),fileExtension);

        HorizontalLayout skipLineLayout = new HorizontalLayout();
        skipLineLayout.setWidthFull();
        skipLineLayout.add(new Span("Skip Line"),createLabeledTextField("Skip line "), skipLine);


        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(headerLayout,fileExtensionLayout,skipLineLayout);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(verticalLayout);
    }
    private Icon createLabeledTextField(String label) {

        // Info 아이콘 생성
        Icon infoIcon = new Icon(VaadinIcon.INFO_CIRCLE_O);
        infoIcon.getElement().setAttribute("style", "cursor: pointer; color: #007bff;");

        // Dialog 생성 (아이콘 클릭 시 표시될 정보 창)
        Dialog infoDialog = new Dialog();
        infoDialog.add(new Span("Information about " + label));

        // 아이콘 클릭 시 다이얼로그 열기
        infoIcon.addClickListener(event -> infoDialog.open());


        // 다이얼로그 추가 (화면 어디서든 열릴 수 있도록)
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(infoDialog);

        return infoIcon;
    }

//    private TextField createLabeledTextField(String label) {
//        TextField textField = new TextField(label);
//        Icon infoIcon = new Icon(VaadinIcon.INFO_CIRCLE);
//        Tooltip.forComponent(infoIcon).setText("Information about " + label);
//        infoIcon.getElement().setAttribute("style", "cursor: pointer; margin-left: 5px;");
//
//        VerticalLayout container = new VerticalLayout(textField, infoIcon);
//        container.setSpacing(false);
//        return textField;
//    }
}
