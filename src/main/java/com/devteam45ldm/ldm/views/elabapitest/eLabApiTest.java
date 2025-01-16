package com.devteam45ldm.ldm.views.elabapitest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.TagsApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.Tag;
import com.devteam45ldm.ldm.controller.HTTPController;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@PageTitle("eLab API Test")
@Route("elab-api-test")
@Menu(order = 10, icon = "line-awesome/svg/globe-solid.svg")
@UIScope
public class eLabApiTest extends Div {

    private TextField urlField;
    private Button testButton;
    private PasswordField apiKeyField;
    private Button readTagsButton;
    private Div jsonResponseDiv;
    private Grid<Tag> responseGrid;

    public eLabApiTest() {
        // Erste Zeile: URL und Test-Button
        urlField = new TextField("URL");
        testButton = new Button("Test");

        testButton.addClickListener(event -> {
            try {
                testUrl();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        HorizontalLayout firstRow = new HorizontalLayout(urlField, testButton);
        firstRow.setWidthFull();
        firstRow.setSpacing(true);

        // Zweite Zeile: API-Key und Read Tags Button
        apiKeyField = new PasswordField("API Key");
        readTagsButton = new Button("Read Tags");

        readTagsButton.addClickListener(event -> readTags());

        HorizontalLayout secondRow = new HorizontalLayout(apiKeyField, readTagsButton);
        secondRow.setWidthFull();
        secondRow.setSpacing(true);

        // Dritte Zeile: JSON-Antwort
        jsonResponseDiv = new Div();
        jsonResponseDiv.getStyle().set("white-space", "pre-wrap");
        jsonResponseDiv.getStyle().set("overflow", "auto");
        jsonResponseDiv.setHeight("300px");
        jsonResponseDiv.setWidthFull();

        // Grid for displaying tags
        responseGrid = new Grid<>(Tag.class);
        responseGrid.setSizeFull();
        responseGrid.setColumns("id"); // Update with actual fields of Tag

        VerticalLayout mainLayout = new VerticalLayout(firstRow, secondRow, jsonResponseDiv, responseGrid);
        mainLayout.setSizeFull();
        add(mainLayout);
    }

    private void testUrl() throws IOException {
        String url = urlField.getValue();
        if (url == null || url.isEmpty()) {
            Notification.show("Please enter a URL.");
            return;
        }

        if (!url.endsWith("/api/v2/info")) {
            url = url.endsWith("/") ? url + "api/v2/info" : url + "/api/v2/info";
        }

        HTTPController httpController = new HTTPController();
        ResponseEntity<String> checkURL = httpController.checkURL(url);
        if (checkURL.getStatusCode().is2xxSuccessful() || checkURL.getStatusCode().is3xxRedirection() || checkURL.getStatusCode().value() == 401) {
            Notification.show("API is reachable.");
        } else {
            Notification.show("API is not reachable: " + checkURL.toString());
        }
    }

    private void readTags() {
        String apiKey = apiKeyField.getValue();
        String url = urlField.getValue();
        if (apiKey == null || apiKey.isEmpty()) {
            Notification.show("Please enter an API key.");
            return;
        }
        if (url == null || url.isEmpty()) {
            Notification.show("Please enter a URL.");
            return;
        }

        try {
            List<Tag> apiResponse = callExternalApi(apiKey, url);
            responseGrid.setItems(apiResponse);
        } catch (Exception e) {
            Notification.show("Error: " + e.getMessage());
        }
    }

    private List<Tag> callExternalApi(String apiKey, String url) throws ApiException {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        if (!url.endsWith("/api/v2")) {
            url = url.endsWith("/") ? url + "api/v2" : url + "/api/v2";
        }


        // Set up the API client
        ApiClient client = Configuration.getDefaultApiClient();
        //client.setVerifyingSsl(false);
        String certFilePath = "/usr/share/ca-certificates/local/crtsh_2475254782.crt";
        try (InputStream certInputStream = new FileInputStream(certFilePath)) {
            client.setSslCaCert(certInputStream);
        } catch (IOException e) {
            throw new ApiException(e);
        }
        client.setBasePath(url);
        client.setApiKey(apiKey);
//
//
//        // Use system-trusted certificates
//        SSLContext sslContext = null;
//        TrustManagerFactory tmf = null;
//        try {
//            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            tmf.init((KeyStore) null);
//            sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());
//
//        } catch (NoSuchAlgorithmException | KeyStoreException | java.security.KeyManagementException e) {
//            throw new ApiException(e);
//        }
//
//        client.getHttpClient().setSslSocketFactory(sslContext.getSocketFactory());

        // Set up ApiKeyAuth for authentication
        //piKeyAuth token = (ApiKeyAuth) client.getAuthentication("token");
        //token.setApiKey(apiKey);
        //if (token == null) {
        //    throw new IllegalStateException("ApiKeyAuth not configured in the ApiClient");
        //}

        TagsApi api = new TagsApi(client);
        Notification.show(client.getSslCaCert().toString());
        return api.readTags("teams", 5);
    }
}