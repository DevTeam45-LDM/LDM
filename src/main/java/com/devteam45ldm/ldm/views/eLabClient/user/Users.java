package com.devteam45ldm.ldm.views.eLabClient.user;

import com.devteam45ldm.ldm.views.eLabClient.login.CredentialsAware;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class Users implements CredentialsAware {

    private final TextField urlField;
    private final PasswordField apiKeyField;

    public Users() {
        urlField = new TextField("URL");
        apiKeyField = new PasswordField("API Key");
    }

    @Override
    public void setCredentials(String apiKey, String url) {
        this.apiKeyField.setValue(apiKey);
        this.apiKeyField.setReadOnly(apiKey!=null && !(apiKey.isEmpty()));
        this.urlField.setValue(url);
        this.urlField.setReadOnly(url!=null && !(url.isEmpty()));
    }
}
