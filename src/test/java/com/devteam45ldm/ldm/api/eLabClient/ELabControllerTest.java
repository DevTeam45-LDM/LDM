package com.devteam45ldm.ldm.api.eLabClient;

import io.swagger.client.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ELabControllerTest {

    /**
     * Tests if the getTagsClient method returns a non-null TagsApi client
     * when provided with a valid API key and URL.
     */
    @Test
    void getTagsClient_withValidApiKeyAndUrl_returnsTagsApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        TagsApi apiClient = controller.getTagsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getTagsClient method throws an IllegalArgumentException
     * when provided with an empty API key.
     */
    @Test
    void getTagsClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("", "https://valid.url/api/v2");
        assertThrows(IllegalArgumentException.class, controller::getTagsClient);
    }

    /**
     * Tests if the getTagsClient method throws an IllegalArgumentException
     * when provided with an empty URL.
     */
    @Test
    void getTagsClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("validApiKey", "");
        assertThrows(IllegalArgumentException.class, controller::getTagsClient);
    }

    /**
     * Tests if the getExperimentsClient method returns a non-null ExperimentsApi client
     * when provided with a valid API key and URL.
     */
    @Test
    void getExperimentsClient_withValidApiKeyAndUrl_returnsExperimentsApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        ExperimentsApi apiClient = controller.getExperimentsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentsClient method throws an IllegalArgumentException
     * when provided with an empty API key.
     */
    @Test
    void getExperimentsClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("", "https://valid.url/api/v2");
        assertThrows(IllegalArgumentException.class, controller::getExperimentsClient);
    }

    /**
     * Tests if the getExperimentsClient method throws an IllegalArgumentException
     * when provided with an empty URL.
     */
    @Test
    void getExperimentsClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("validApiKey", "");
        assertThrows(IllegalArgumentException.class, controller::getExperimentsClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method returns a non-null ExperimentsTemplatesApi client
     * when provided with a valid API key and URL.
     */
    @Test
    void getExperimentTemplatesClient_withValidApiKeyAndUrl_returnsExperimentsTemplatesApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        ExperimentsTemplatesApi apiClient = controller.getExperimentTemplatesClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method throws an IllegalArgumentException
     * when provided with an empty API key.
     */
    @Test
    void getExperimentTemplatesClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("", "https://valid.url/api/v2");
        assertThrows(IllegalArgumentException.class, controller::getExperimentTemplatesClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method throws an IllegalArgumentException
     * when provided with an empty URL.
     */
    @Test
    void getExperimentTemplatesClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("validApiKey", "");
        assertThrows(IllegalArgumentException.class, controller::getExperimentTemplatesClient);
    }

    /**
     * Tests if the getUsersClient method returns a non-null UsersApi client
     * when provided with a valid API key and URL.
     */
    @Test
    void getUsersClient_withValidApiKeyAndUrl_returnsUsersApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        UsersApi apiClient = controller.getUsersClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getUsersClient method throws an IllegalArgumentException
     * when provided with an empty API key.
     */
    @Test
    void getUsersClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("", "https://valid.url/api/v2");
        assertThrows(IllegalArgumentException.class, controller::getUsersClient);
    }

    /**
     * Tests if the getUsersClient method throws an IllegalArgumentException
     * when provided with an empty URL.
     */
    @Test
    void getUsersClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("validApiKey", "");
        assertThrows(IllegalArgumentException.class, controller::getUsersClient);
    }

    /**
     * Tests if the getInfoClient method returns a non-null InfoApi client
     * when provided with a valid API key and URL.
     */
    @Test
    void getInfoClient_withValidApiKeyAndUrl_returnsInfoApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        InfoApi apiClient = controller.getInfoClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getInfoClient method throws an IllegalArgumentException
     * when provided with an empty API key.
     */
    @Test
    void getInfoClient_withEmptyApiKey_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("", "https://valid.url/api/v2");
        assertThrows(IllegalArgumentException.class, controller::getInfoClient);
    }

    /**
     * Tests if the getInfoClient method throws an IllegalArgumentException
     * when provided with an empty URL.
     */
    @Test
    void getInfoClient_withEmptyUrl_throwsIllegalArgumentException() {
        ELabController controller = new ELabController("validApiKey", "");
        assertThrows(IllegalArgumentException.class, controller::getInfoClient);
    }

    /**
     * Tests if the getTagsClient method returns a non-null TagsApi client
     * when API key and URL are set via constructor.
     */
    @Test
    void getTagsClient_withConstructorSetApiKeyAndUrl_returnsTagsApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        TagsApi apiClient = controller.getTagsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getTagsClient method returns a non-null TagsApi client
     * when API key and URL are set via methods.
     */
    @Test
    void getTagsClient_withMethodSetApiKeyAndUrl_returnsTagsApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        TagsApi apiClient = controller.getTagsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getTagsClient method returns a non-null TagsApi client
     * when API key and URL are set via constructor and then retrieved without parameters.
     */
    @Test
    void getTagsClient_withConstructorSetApiKeyAndUrl_thenGetWithoutParams_returnsTagsApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        controller.getTagsClient("validApiKey", "https://valid.url/api/v2");
        TagsApi apiClient = controller.getTagsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getTagsClient method returns a non-null TagsApi client
     * when API key and URL are set via methods and then retrieved without parameters.
     */
    @Test
    void getTagsClient_withMethodSetApiKeyAndUrl_thenGetWithoutParams_returnsTagsApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        controller.getTagsClient("validApiKey", "https://valid.url/api/v2");
        TagsApi apiClient = controller.getTagsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentsClient method returns a non-null ExperimentsApi client
     * when API key and URL are set via constructor.
     */
    @Test
    void getExperimentsClient_withConstructorSetApiKeyAndUrl_returnsExperimentsApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        ExperimentsApi apiClient = controller.getExperimentsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentsClient method returns a non-null ExperimentsApi client
     * when API key and URL are set via methods.
     */
    @Test
    void getExperimentsClient_withMethodSetApiKeyAndUrl_returnsExperimentsApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        ExperimentsApi apiClient = controller.getExperimentsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentsClient method returns a non-null ExperimentsApi client
     * when API key and URL are set via constructor and then retrieved without parameters.
     */
    @Test
    void getExperimentsClient_withConstructorSetApiKeyAndUrl_thenGetWithoutParams_returnsExperimentsApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        controller.getExperimentsClient("validApiKey", "https://valid.url/api/v2");
        ExperimentsApi apiClient = controller.getExperimentsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentsClient method returns a non-null ExperimentsApi client
     * when API key and URL are set via methods and then retrieved without parameters.
     */
    @Test
    void getExperimentsClient_withMethodSetApiKeyAndUrl_thenGetWithoutParams_returnsExperimentsApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        controller.getExperimentsClient("validApiKey", "https://valid.url/api/v2");
        ExperimentsApi apiClient = controller.getExperimentsClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method returns a non-null ExperimentsTemplatesApi client
     * when API key and URL are set via constructor.
     */
    @Test
    void getExperimentTemplatesClient_withConstructorSetApiKeyAndUrl_returnsExperimentsTemplatesApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        ExperimentsTemplatesApi apiClient = controller.getExperimentTemplatesClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method returns a non-null ExperimentsTemplatesApi client
     * when API key and URL are set via methods.
     */
    @Test
    void getExperimentTemplatesClient_withMethodSetApiKeyAndUrl_returnsExperimentsTemplatesApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        ExperimentsTemplatesApi apiClient = controller.getExperimentTemplatesClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method returns a non-null ExperimentsTemplatesApi client
     * when API key and URL are set via constructor and then retrieved without parameters.
     */
    @Test
    void getExperimentTemplatesClient_withConstructorSetApiKeyAndUrl_thenGetWithoutParams_returnsExperimentsTemplatesApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        controller.getExperimentTemplatesClient("validApiKey", "https://valid.url/api/v2");
        ExperimentsTemplatesApi apiClient = controller.getExperimentTemplatesClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getExperimentTemplatesClient method returns a non-null ExperimentsTemplatesApi client
     * when API key and URL are set via methods and then retrieved without parameters.
     */
    @Test
    void getExperimentTemplatesClient_withMethodSetApiKeyAndUrl_thenGetWithoutParams_returnsExperimentsTemplatesApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        controller.getExperimentTemplatesClient("validApiKey", "https://valid.url/api/v2");
        ExperimentsTemplatesApi apiClient = controller.getExperimentTemplatesClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getUsersClient method returns a non-null UsersApi client
     * when API key and URL are set via constructor.
     */
    @Test
    void getUsersClient_withConstructorSetApiKeyAndUrl_returnsUsersApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        UsersApi apiClient = controller.getUsersClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getUsersClient method returns a non-null UsersApi client
     * when API key and URL are set via methods.
     */
    @Test
    void getUsersClient_withMethodSetApiKeyAndUrl_returnsUsersApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        UsersApi apiClient = controller.getUsersClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getUsersClient method returns a non-null UsersApi client
     * when API key and URL are set via constructor and then retrieved without parameters.
     */
    @Test
    void getUsersClient_withConstructorSetApiKeyAndUrl_thenGetWithoutParams_returnsUsersApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        controller.getUsersClient("validApiKey", "https://valid.url/api/v2");
        UsersApi apiClient = controller.getUsersClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getUsersClient method returns a non-null UsersApi client
     * when API key and URL are set via methods and then retrieved without parameters.
     */
    @Test
    void getUsersClient_withMethodSetApiKeyAndUrl_thenGetWithoutParams_returnsUsersApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        controller.getUsersClient("validApiKey", "https://valid.url/api/v2");
        UsersApi apiClient = controller.getUsersClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getInfoClient method returns a non-null InfoApi client
     * when API key and URL are set via constructor.
     */
    @Test
    void getInfoClient_withConstructorSetApiKeyAndUrl_returnsInfoApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        InfoApi apiClient = controller.getInfoClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getInfoClient method returns a non-null InfoApi client
     * when API key and URL are set via methods.
     */
    @Test
    void getInfoClient_withMethodSetApiKeyAndUrl_returnsInfoApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        InfoApi apiClient = controller.getInfoClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getInfoClient method returns a non-null InfoApi client
     * when API key and URL are set via constructor and then retrieved without parameters.
     */
    @Test
    void getInfoClient_withConstructorSetApiKeyAndUrl_thenGetWithoutParams_returnsInfoApiClient() {
        ELabController controller = new ELabController("validApiKey", "https://valid.url/api/v2");
        controller.getInfoClient("validApiKey", "https://valid.url/api/v2");
        InfoApi apiClient = controller.getInfoClient();
        assertNotNull(apiClient);
    }

    /**
     * Tests if the getInfoClient method returns a non-null InfoApi client
     * when API key and URL are set via methods and then retrieved without parameters.
     */
    @Test
    void getInfoClient_withMethodSetApiKeyAndUrl_thenGetWithoutParams_returnsInfoApiClient() {
        ELabController controller = new ELabController();
        controller.setApiKey("validApiKey");
        controller.setUrl("https://valid.url/api/v2");
        controller.getInfoClient("validApiKey", "https://valid.url/api/v2");
        InfoApi apiClient = controller.getInfoClient();
        assertNotNull(apiClient);
    }
}