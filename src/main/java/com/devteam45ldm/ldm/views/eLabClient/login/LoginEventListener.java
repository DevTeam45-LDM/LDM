package com.devteam45ldm.ldm.views.eLabClient.login;

import java.util.EventListener;

public interface LoginEventListener extends EventListener {
    void onLogin(LoginEvent event);
}