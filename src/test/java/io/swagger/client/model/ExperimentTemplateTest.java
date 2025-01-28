package io.swagger.client.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExperimentTemplateTest {

    @Test
    public void testExperimentTemplateConstructor() {
        ExperimentTemplate experimentTemplate = new ExperimentTemplate();
        assertNotNull(experimentTemplate);
    }

    @Test
    public void testGettersAndSetters() {
        ExperimentTemplate experimentTemplate = new ExperimentTemplate();
        experimentTemplate.setId(123);
        experimentTemplate.setTitle("Test Title");
        experimentTemplate.setBody("Test Body");
        experimentTemplate.setCategory(123);
        experimentTemplate.setCategoryTitle("Test Category Title");
        experimentTemplate.setCategoryColor("Test Category Color");
        experimentTemplate.setUserid(123);
        experimentTemplate.setCanread("true");
        experimentTemplate.setCanwrite("true");
        experimentTemplate.setLocked(1);
        experimentTemplate.setLockedby(123);
        experimentTemplate.setLockedAt("2025-01-28T12:37:39");
        experimentTemplate.setFullname("Full Name");
        experimentTemplate.setMetadata("Metadata");
        experimentTemplate.setTeamsId(123);
        experimentTemplate.setIsPinned(1);
        experimentTemplate.setStatus(123);
        experimentTemplate.setStatusTitle("Status Title");
        experimentTemplate.setStatusColor("Status Color");
        experimentTemplate.setTags("Tags");
        experimentTemplate.setTagsId("Tags ID");
        experimentTemplate.setCreatedAt("2025-01-28T12:37:39");
        experimentTemplate.setModifiedAt("2025-01-28T12:37:39");
        experimentTemplate.setOrdering("Ordering");
        experimentTemplate.setCanReadTarget("true");
        experimentTemplate.setCanWriteTarget("true");
        experimentTemplate.setContentType(123);
        experimentTemplate.setState(123);
        experimentTemplate.setNextStep("Next Step");
        experimentTemplate.setFirstname("First Name");
        experimentTemplate.setLastname("Last Name");
        experimentTemplate.setOrcId("Orc ID");
        experimentTemplate.setTeamName("Team Name");
        experimentTemplate.setUpItemId("Up Item ID");
        experimentTemplate.setHasAttachment("Has Attachment");
        experimentTemplate.setExclusiveEditMode(new ExclusiveEditMode());

        assertEquals(123, experimentTemplate.getId());
        assertEquals("Test Title", experimentTemplate.getTitle());
        assertEquals("Test Body", experimentTemplate.getBody());
        assertEquals(123, experimentTemplate.getCategory());
        assertEquals("Test Category Title", experimentTemplate.getCategoryTitle());
        assertEquals("Test Category Color", experimentTemplate.getCategoryColor());
        assertEquals(123, experimentTemplate.getUserid());
        assertEquals("true", experimentTemplate.getCanread());
        assertEquals("true", experimentTemplate.getCanwrite());
        assertEquals(1, experimentTemplate.getLocked());
        assertEquals(123, experimentTemplate.getLockedby());
        assertEquals("2025-01-28T12:37:39", experimentTemplate.getLockedAt());
        assertEquals("Full Name", experimentTemplate.getFullname());
        assertEquals("Metadata", experimentTemplate.getMetadata());
        assertEquals(123, experimentTemplate.getTeamsId());
        assertEquals(1, experimentTemplate.getIsPinned());
        assertEquals(123, experimentTemplate.getStatus());
        assertEquals("Status Title", experimentTemplate.getStatusTitle());
        assertEquals("Status Color", experimentTemplate.getStatusColor());
        assertEquals("Tags", experimentTemplate.getTags());
        assertEquals("Tags ID", experimentTemplate.getTagsId());
        assertEquals("2025-01-28T12:37:39", experimentTemplate.getCreatedAt());
        assertEquals("2025-01-28T12:37:39", experimentTemplate.getModifiedAt());
        assertEquals("Ordering", experimentTemplate.getOrdering());
        assertEquals("true", experimentTemplate.getCanReadTarget());
        assertEquals("true", experimentTemplate.getCanWriteTarget());
        assertEquals(123, experimentTemplate.getContentType());
        assertEquals(123, experimentTemplate.getState());
        assertEquals("Next Step", experimentTemplate.getNextStep());
        assertEquals("First Name", experimentTemplate.getFirstname());
        assertEquals("Last Name", experimentTemplate.getLastname());
        assertEquals("Orc ID", experimentTemplate.getOrcId());
        assertEquals("Team Name", experimentTemplate.getTeamName());
        assertEquals("Up Item ID", experimentTemplate.getUpItemId());
        assertEquals("Has Attachment", experimentTemplate.getHasAttachment());
        assertEquals(new ExclusiveEditMode(), experimentTemplate.getExclusiveEditMode());
    }

    @Test
    public void testEqualsAndHashCode() {
        ExperimentTemplate experimentTemplate1 = new ExperimentTemplate();
        experimentTemplate1.setId(1);
        experimentTemplate1.setTitle("Test Title");

        ExperimentTemplate experimentTemplate2 = new ExperimentTemplate();
        experimentTemplate2.setId(1);
        experimentTemplate2.setTitle("Test Title");

        assertEquals(experimentTemplate1, experimentTemplate2);
        assertEquals(experimentTemplate1.hashCode(), experimentTemplate2.hashCode());
    }

    @Test
    public void testToString() {
        ExperimentTemplate experimentTemplate = new ExperimentTemplate();
        experimentTemplate.setId(1);
        experimentTemplate.setTitle("Test Title");

        String expectedString = """
                class ExperimentTemplate {
                    id: 1
                    title: Test Title
                    body: null
                    category: null
                    categoryTitle: null
                    categoryColor: null
                    userid: null
                    canread: null
                    canwrite: null
                    locked: null
                    lockedby: null
                    lockedAt: null
                    fullname: null
                    metadata: null
                    team: null
                    isPinned: null
                    status: null
                    statusTitle: null
                    statusColor: null
                    tags: null
                    tagsId: null
                    createdAt: null
                    modifiedAt: null
                    ordering: null
                    canReadTarget: null
                    canWriteTarget: null
                    contentType: null
                    state: null
                    nextStep: null
                    firstname: null
                    lastname: null
                    orcId: null
                    teamName: null
                    upItemId: null
                    hasAttachment: null
                    exclusiveEditMode: null
                }""";
        assertEquals(expectedString, experimentTemplate.toString());
    }

    @Test
    public void testJsonDeserialization() throws Exception {
        String json = "[{\"id\":75,\"userid\":136,\"created_at\":\"2025-01-20 20:01:35\",\"modified_at\":\"2025-01-24 15:39:32\",\"team\":5,\"title\":\"METIS Magnetometer TU-Da I\",\"status\":null,\"body\":\"<p>Description of the sample and measurement procedure.</p>\",\"category\":2,\"ordering\":null,\"canread\":\"{\\\"base\\\": 30, \\\"teams\\\": [], \\\"users\\\": [], \\\"teamgroups\\\": []}\",\"canwrite\":\"{\\\"base\\\": 20, \\\"teams\\\": [], \\\"users\\\": [], \\\"teamgroups\\\": []}\",\"canread_target\":\"{\\\"base\\\": 30, \\\"teams\\\": [], \\\"users\\\": [], \\\"teamgroups\\\": []}\",\"canwrite_target\":\"{\\\"base\\\": 20, \\\"teams\\\": [], \\\"users\\\": [], \\\"teamgroups\\\": []}\",\"content_type\":2,\"locked\":0,\"lockedby\":null,\"locked_at\":null,\"metadata\":\"{\\\"elabftw\\\":{\\\"extra_fields_groups\\\":[{\\\"id\\\":1,\\\"name\\\":\\\"Measurement Parameters\\\"}]},\\\"extra_fields\\\":{\\\"Pulse Magnetic Field Strength (in Tesla)\\\":{\\\"type\\\":\\\"text\\\",\\\"value\\\":\\\"\\\",\\\"required\\\":true,\\\"group_id\\\":1},\\\"Sample Temperature (in °C)\\\":{\\\"type\\\":\\\"text\\\",\\\"value\\\":\\\"RT\\\",\\\"required\\\":true,\\\"group_id\\\":1},\\\"Coil Diameter (in mm)\\\":{\\\"type\\\":\\\"text\\\",\\\"value\\\":\\\"\\\",\\\"required\\\":true,\\\"group_id\\\":1},\\\"Demagnetization Factor (N)\\\":{\\\"type\\\":\\\"text\\\",\\\"value\\\":\\\"-\\\",\\\"group_id\\\":1}}}\",\"state\":1,\"is_pinned\":0,\"status_title\":null,\"status_color\":null,\"category_title\":\"Experiment Analysis\",\"category_color\":\"bfbfff\",\"next_step\":null,\"firstname\":\"Myeongjong\",\"lastname\":\"Kim\",\"orcid\":null,\"fullname\":\"Myeongjong Kim\",\"team_name\":\"CRC/TRR 270\",\"up_item_id\":null,\"has_attachment\":null}]";
        ObjectMapper objectMapper = new ObjectMapper();
        ExperimentTemplate[] experimentTemplates = objectMapper.readValue(json, ExperimentTemplate[].class);
        ExperimentTemplate experimentTemplate = experimentTemplates[0];

        assertEquals(75, experimentTemplate.getId());
        assertEquals(136, experimentTemplate.getUserid());
        assertEquals("2025-01-20 20:01:35", experimentTemplate.getCreatedAt());
        assertEquals("2025-01-24 15:39:32", experimentTemplate.getModifiedAt());
        assertEquals(5, experimentTemplate.getTeamsId());
        assertEquals("METIS Magnetometer TU-Da I", experimentTemplate.getTitle());
        assertNull(experimentTemplate.getStatus());
        assertEquals("<p>Description of the sample and measurement procedure.</p>", experimentTemplate.getBody());
        assertEquals(2, experimentTemplate.getCategory());
        assertNull(experimentTemplate.getOrdering());
        assertEquals("{\"base\": 30, \"teams\": [], \"users\": [], \"teamgroups\": []}", experimentTemplate.getCanread());
        assertEquals("{\"base\": 20, \"teams\": [], \"users\": [], \"teamgroups\": []}", experimentTemplate.getCanwrite());
        assertEquals("{\"base\": 30, \"teams\": [], \"users\": [], \"teamgroups\": []}", experimentTemplate.getCanReadTarget());
        assertEquals("{\"base\": 20, \"teams\": [], \"users\": [], \"teamgroups\": []}", experimentTemplate.getCanWriteTarget());
        assertEquals(2, experimentTemplate.getContentType());
        assertEquals(0, experimentTemplate.getLocked());
        assertNull(experimentTemplate.getLockedby());
        assertNull(experimentTemplate.getLockedAt());
        assertEquals("{\"elabftw\":{\"extra_fields_groups\":[{\"id\":1,\"name\":\"Measurement Parameters\"}]},\"extra_fields\":{\"Pulse Magnetic Field Strength (in Tesla)\":{\"type\":\"text\",\"value\":\"\",\"required\":true,\"group_id\":1},\"Sample Temperature (in °C)\":{\"type\":\"text\",\"value\":\"RT\",\"required\":true,\"group_id\":1},\"Coil Diameter (in mm)\":{\"type\":\"text\",\"value\":\"\",\"required\":true,\"group_id\":1},\"Demagnetization Factor (N)\":{\"type\":\"text\",\"value\":\"-\",\"group_id\":1}}}", experimentTemplate.getMetadata());
        assertEquals(1, experimentTemplate.getState());
        assertEquals(0, experimentTemplate.getIsPinned());
        assertNull(experimentTemplate.getStatusTitle());
        assertNull(experimentTemplate.getStatusColor());
        assertEquals("Experiment Analysis", experimentTemplate.getCategoryTitle());
        assertEquals("bfbfff", experimentTemplate.getCategoryColor());
        assertNull(experimentTemplate.getNextStep());
        assertEquals("Myeongjong", experimentTemplate.getFirstname());
        assertEquals("Kim", experimentTemplate.getLastname());
        assertNull(experimentTemplate.getOrcId());
        assertEquals("Myeongjong Kim", experimentTemplate.getFullname());
        assertEquals("CRC/TRR 270", experimentTemplate.getTeamName());
        assertNull(experimentTemplate.getUpItemId());
        assertNull(experimentTemplate.getHasAttachment());
        assertNull(experimentTemplate.getExclusiveEditMode());
    }
}