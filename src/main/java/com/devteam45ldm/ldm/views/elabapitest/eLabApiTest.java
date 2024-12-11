package com.devteam45ldm.ldm.views.elabapitest;

import com.squareup.okhttp.Call;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

import io.swagger.client.ApiClient;

import java.util.Collections;
import java.util.List;

@PageTitle("eLab API Test")
@Route("elab-api-test")
@Menu(order = 10, icon = "line-awesome/svg/filter-solid.svg")
@UIScope
public class eLabApiTest extends Div {

    private PasswordField apiKeyField;
    private Button sendRequestButton;
    private ComboBox<String> responseDropdown;

    public eLabApiTest() {

        apiKeyField = new PasswordField("API Key");
        sendRequestButton = new Button("Send GET-Request");
        responseDropdown = new ComboBox<>("Response");

        sendRequestButton.addClickListener(event -> handleApiRequest());

        HorizontalLayout topLayout = new HorizontalLayout(apiKeyField, sendRequestButton);
        topLayout.setWidthFull();
        topLayout.setAlignItems(HorizontalLayout.Alignment.START);
        topLayout.setSpacing(true);

        VerticalLayout mainLayout = new VerticalLayout(topLayout, responseDropdown);
        mainLayout.setSizeFull();
        mainLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        responseDropdown.setWidth("300px");
        responseDropdown.setPlaceholder("Waiting for response...");

        add(mainLayout);
    }

    private void handleApiRequest() {
        String apiKey = apiKeyField.getValue();
        if (apiKey == null || apiKey.isEmpty()) {
            responseDropdown.setPlaceholder("Please enter an API key.");
            return;
        }

        try {
            List<String> apiResponse = callExternalApi(apiKey);

            responseDropdown.setItems(apiResponse);
            responseDropdown.setPlaceholder("Data loaded.");
        } catch (Exception e) {
            responseDropdown.setPlaceholder("Error: " + e.getMessage());
        }
    }

    private List<String> callExternalApi(String apiKey) throws Exception {
        ApiClient client = new ApiClient();
        client.setBasePath("https://sfb270eln.physik.uni-due.de/api/v2/");
        client.setApiKey(apiKey);
        Call call = client.buildCall("teams/5/tags", "GET", Collections.emptyList(), Collections.emptyList(), null, null, null, Collections.emptyList().toArray(new String[0]), null);
        Object response =  client.execute(call).getData();
        return Collections.singletonList(response.toString());
    }
}