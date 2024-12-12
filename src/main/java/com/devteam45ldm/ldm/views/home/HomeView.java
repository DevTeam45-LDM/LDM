package com.devteam45ldm.ldm.views.home;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Startseite diesmal getestet")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/globe-solid.svg")
public class HomeView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public HomeView() {
        name = new TextField("Sag mir, wie Du heißt, und ich sag Dir, wie Du heißt");
        sayHello = new Button("Say GutenTag");
        sayHello.addClickListener(e -> {
            Notification.show("GutenTag " + name.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

}
