package com.devteam45ldm.ldm.views.home;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * The {@code HomeView} class represents the home page of the application.
 * This view contains a text field for user input and a button to display a greeting notification.
 */
@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/globe-solid.svg")
public class HomeView extends HorizontalLayout {

    /**
     * Text field for entering the user's name.
     */
    private TextField name;

    /**
     * Button to trigger the greeting notification.
     */
    private Button sayHello;

    /**
     * Constructs the {@code HomeView} and initializes the components.
     * The view includes a text field for the user's name and a button that,
     * when clicked or activated by pressing the Enter key, shows a greeting notification.
     */
    public HomeView() {
        // Initialize the text field with a label "Your name".
        name = new TextField("Your name");

        // Initialize the button with the label "Say hello".
        sayHello = new Button("Say hello");

        // Add a click listener to the button to show a notification with the entered name.
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });

        // Add a keyboard shortcut (Enter key) for the button.
        sayHello.addClickShortcut(Key.ENTER);

        // Set layout margin and alignment for components.
        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        // Add the components to the layout.
        add(name, sayHello);
    }
}
