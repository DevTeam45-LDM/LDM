package io.swagger.client.model;

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

        assertEquals(1, experimentTemplate.getId());
        assertEquals("Test Title", experimentTemplate.getTitle());
        assertEquals("Test Body", experimentTemplate.getBody());
        assertEquals("Test Category", experimentTemplate.getCategory());
        assertEquals("Test Category Title", experimentTemplate.getCategoryTitle());
        assertEquals("Test Category Color", experimentTemplate.getCategoryColor());
        assertEquals(123, experimentTemplate.getUserid());
        assertTrue(experimentTemplate.getCanread());
        assertTrue(experimentTemplate.getCanwrite());
        assertFalse(experimentTemplate.getLocked());
        assertEquals("User", experimentTemplate.getLockedby());
        assertEquals("2025-01-28T12:37:39", experimentTemplate.getLockedAt());
        assertEquals("Full Name", experimentTemplate.getFullname());
        assertEquals("Metadata", experimentTemplate.getMetadata());
        assertEquals("Team ID", experimentTemplate.getTeamsId());
        assertTrue(experimentTemplate.getIsPinned());
        assertEquals("Status", experimentTemplate.getStatus());
        assertEquals("Status Title", experimentTemplate.getStatusTitle());
        assertEquals("Status Color", experimentTemplate.getStatusColor());
        assertEquals("Tags", experimentTemplate.getTags());
        assertEquals("Tags ID", experimentTemplate.getTagsId());
        assertEquals("2025-01-28T12:37:39", experimentTemplate.getCreatedAt());
        assertEquals("2025-01-28T12:37:39", experimentTemplate.getModifiedAt());
        assertEquals(1, experimentTemplate.getOrdering());
        assertTrue(experimentTemplate.getCanReadTarget());
        assertTrue(experimentTemplate.getCanWriteTarget());
        assertEquals("Content Type", experimentTemplate.getContentType());
        assertEquals("State", experimentTemplate.getState());
        assertEquals("Next Step", experimentTemplate.getNextStep());
        assertEquals("First Name", experimentTemplate.getFirstname());
        assertEquals("Last Name", experimentTemplate.getLastname());
        assertEquals("Orc ID", experimentTemplate.getOrcId());
        assertEquals("Team Name", experimentTemplate.getTeamName());
        assertEquals("Up Item ID", experimentTemplate.getUpItemId());
        assertEquals("Has Attachment", experimentTemplate.getHasAttachment());
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

        String expectedString = "class ExperimentTemplate {\n" +
                "    id: 1\n" +
                "    title: Test Title\n" +
                "    body: null\n" +
                "    category: null\n" +
                "    categoryTitle: null\n" +
                "    categoryColor: null\n" +
                "    userid: null\n" +
                "    canread: null\n" +
                "    canwrite: null\n" +
                "    locked: null\n" +
                "    lockedby: null\n" +
                "    lockedAt: null\n" +
                "    fullname: null\n" +
                "    metadata: null\n" +
                "    teamsId: null\n" +
                "    isPinned: null\n" +
                "    status: null\n" +
                "    statusTitle: null\n" +
                "    statusColor: null\n" +
                "    tags: null\n" +
                "    tagsId: null\n" +
                "    createdAt: null\n" +
                "    modifiedAt: null\n" +
                "    ordering: null\n" +
                "    canReadTarget: null\n" +
                "    canWriteTarget: null\n" +
                "    contentType: null\n" +
                "    state: null\n" +
                "    nextStep: null\n" +
                "    firstname: null\n" +
                "    lastname: null\n" +
                "    orcId: null\n" +
                "    teamName: null\n" +
                "    upItemId: null\n" +
                "    hasAttachment: null\n" +
                "}";
        assertEquals(expectedString, experimentTemplate.toString());
    }
}