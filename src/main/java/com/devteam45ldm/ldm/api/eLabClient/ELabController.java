package com.devteam45ldm.ldm.api.eLabClient;


import io.swagger.client.api.*;

/**
 * The ELabController class provides methods to interact with various eLab API clients.
 * It allows setting API keys and URLs, and retrieving specific API clients.
 */
public class ELabController {
    private ELabClient<?> elabClient;
    private String apiKey;
    private String url;

    /**
     * Default constructor.
     */
    public ELabController() {
    }

    /**
     * Constructor with API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     */
    public ELabController(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    /**
     * Gets the API key.
     *
     * @return the API key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the API key.
     *
     * @param apiKey the API key to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Sets the API key and returns the current instance.
     *
     * @param apiKey the API key to set
     * @return the current instance of ELabController
     */
    public ELabController apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Gets the URL.
     *
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL.
     *
     * @param url the URL to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Sets the URL and returns the current instance.
     *
     * @param url the URL to set
     * @return the current instance of ELabController
     */
    public ELabController url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the TagsApi client using the current API key and URL.
     *
     * @return the TagsApi client
     */
    public TagsApi getTagsClient() {
        return getTagsClient(this.apiKey, this.url);
    }

    /**
     * Gets the TagsApi client using the specified API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     * @return the TagsApi client
     */
    public TagsApi getTagsClient(String apiKey, String url) {
        setApiKey(apiKey);
        setUrl(url);
        elabClient = new ELabClient<>(TagsApi.class);
        return (TagsApi) elabClient.getClient(apiKey, url);
    }

    /**
     * Gets the TeamTagsApi client using the current API key and URL.
     *
     * @return the TeamTagsApi client
     */
    public TeamTagsApi getTeamTagsClient() {
        return getTeamTagsClient(this.apiKey, this.url);
    }

    /**
     * Gets the TeamTagsApi client using the specified API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     * @return the TeamTagsApi client
     */
    public TeamTagsApi getTeamTagsClient(String apiKey, String url) {
        setApiKey(apiKey);
        setUrl(url);
        elabClient = new ELabClient<>(TeamTagsApi.class);
        return (TeamTagsApi) elabClient.getClient(apiKey, url);
    }

    /**
     * Gets the ExperimentsApi client using the current API key and URL.
     *
     * @return the ExperimentsApi client
     */
    public ExperimentsApi getExperimentsClient() {
        return getExperimentsClient(this.apiKey, this.url);
    }

    /**
     * Gets the ExperimentsApi client using the specified API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     * @return the ExperimentsApi client
     */
    public ExperimentsApi getExperimentsClient(String apiKey, String url) {
        setApiKey(apiKey);
        setUrl(url);
        elabClient = new ELabClient<>(ExperimentsApi.class);
        return (ExperimentsApi) elabClient.getClient(apiKey, url);
    }

    /**
     * Gets the ExperimentsTemplatesApi client using the current API key and URL.
     *
     * @return the ExperimentsTemplatesApi client
     */
    public ExperimentsTemplatesApi getExperimentTemplatesClient() {
        return getExperimentTemplatesClient(this.apiKey, this.url);
    }

    /**
     * Gets the ExperimentsTemplatesApi client using the specified API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     * @return the ExperimentsTemplatesApi client
     */
    public ExperimentsTemplatesApi getExperimentTemplatesClient(String apiKey, String url) {
        setApiKey(apiKey);
        setUrl(url);
        elabClient = new ELabClient<>(ExperimentsTemplatesApi.class);
        return (ExperimentsTemplatesApi) elabClient.getClient(apiKey, url);
    }

    /**
     * Gets the UsersApi client using the current API key and URL.
     *
     * @return the UsersApi client
     */
    public UsersApi getUsersClient() {
        return getUsersClient(this.apiKey, this.url);
    }

    /**
     * Gets the UsersApi client using the specified API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     * @return the UsersApi client
     */
    public UsersApi getUsersClient(String apiKey, String url) {
        setApiKey(apiKey);
        setUrl(url);
        elabClient = new ELabClient<>(UsersApi.class);
        return (UsersApi) elabClient.getClient(apiKey, url);
    }

    /**
     * Gets the InfoApi client using the current API key and URL.
     *
     * @return the InfoApi client
     */
    public InfoApi getInfoClient() {
        return getInfoClient(this.apiKey, this.url);
    }

    /**
     * Gets the InfoApi client using the specified API key and URL.
     *
     * @param apiKey the API key to use
     * @param url the URL to use
     * @return the InfoApi client
     */
    public InfoApi getInfoClient(String apiKey, String url) {
        setApiKey(apiKey);
        setUrl(url);
        elabClient = new ELabClient<>(InfoApi.class);
        return (InfoApi) elabClient.getClient(apiKey, url);
    }
}
