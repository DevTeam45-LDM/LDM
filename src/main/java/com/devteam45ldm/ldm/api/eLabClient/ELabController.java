package com.devteam45ldm.ldm.api.eLabClient;


import io.swagger.client.api.*;

public class ELabController {
    private ELabClient<?> elabClient;
    private String apiKey;
    private String url;

    public ELabController() {
    }

    public ELabController(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ELabController apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ELabController url(String url) {
        this.url = url;
        return this;
    }

    public TagsApi getTagsClient() {
        return getTagsClient(this.apiKey, this.url);
    }

    public TagsApi getTagsClient(String apiKey, String url) {
        elabClient = new ELabClient<>(TagsApi.class);
        return (TagsApi) elabClient.getClient(apiKey, url);
    }

    public ExperimentsApi getExperimentsClient() {
        return getExperimentsClient(this.apiKey, this.url);
    }

    public ExperimentsApi getExperimentsClient(String apiKey, String url) {
        elabClient = new ELabClient<>(ExperimentsApi.class);
        return (ExperimentsApi) elabClient.getClient(apiKey, url);
    }

    public ExperimentsTemplatesApi getExperimentTemplatesClient() {
        return getExperimentTemplatesClient(this.apiKey, this.url);
    }

    public ExperimentsTemplatesApi getExperimentTemplatesClient(String apiKey, String url) {
        elabClient = new ELabClient<>(ExperimentsTemplatesApi.class);
        return (ExperimentsTemplatesApi) elabClient.getClient(apiKey, url);
    }

    public UsersApi getUsersClient() {
        return getUsersClient(this.apiKey, this.url);
    }

    public UsersApi getUsersClient(String apiKey, String url) {
        elabClient = new ELabClient<>(UsersApi.class);
        return (UsersApi) elabClient.getClient(apiKey, url);
    }

    public InfoApi getInfoClient() {
        return getInfoClient(this.apiKey, this.url);
    }

    public InfoApi getInfoClient(String apiKey, String url) {
        elabClient = new ELabClient<>(InfoApi.class);
        return (InfoApi) elabClient.getClient(apiKey, url);
    }
}
