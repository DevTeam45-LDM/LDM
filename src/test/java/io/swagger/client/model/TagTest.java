package io.swagger.client.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TagTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createTagWithId() {
        Tag tag = new Tag().id(1);
        assertEquals(1, tag.getId());
    }

    @Test
    void createTagWithTag() {
        Tag tag = new Tag().tag("example");
        assertEquals("example", tag.getTag());
    }

    @Test
    void createTagWithItemCount() {
        Tag tag = new Tag().itemCount(10);
        assertEquals(10, tag.getItemCount());
    }

    @Test
    void createTagWithIsFavorite() {
        Tag tag = new Tag().isFavorite(1);
        assertEquals(1, tag.getIsFavorite());
    }

    @Test
    void tagsWithSamePropertiesAreEqual() {
        Tag tag1 = new Tag().id(1).tag("example").itemCount(10).isFavorite(1);
        Tag tag2 = new Tag().id(1).tag("example").itemCount(10).isFavorite(1);
        assertEquals(tag1, tag2);
    }

    @Test
    void tagsWithDifferentPropertiesAreNotEqual() {
        Tag tag1 = new Tag().id(1).tag("example").itemCount(10).isFavorite(1);
        Tag tag2 = new Tag().id(2).tag("different").itemCount(5).isFavorite(0);
        assertNotEquals(tag1, tag2);
    }

    @Test
    void hashCodeIsConsistentWithEquals() {
        Tag tag1 = new Tag().id(1).tag("example").itemCount(10).isFavorite(1);
        Tag tag2 = new Tag().id(1).tag("example").itemCount(10).isFavorite(1);
        assertEquals(tag1.hashCode(), tag2.hashCode());
    }

    @Test
    void toStringContainsAllProperties() {
        Tag tag = new Tag().id(1).tag("example").itemCount(10).isFavorite(1);
        String expected = "{\n" +
                          "    id: 1\n" +
                          "    tag: example\n" +
                          "    itemCount: 10\n" +
                          "    isFavorite: 1\n" +
                          "}";
        assertEquals(expected, tag.toString());
    }

    @Test
    void parseJsonWithDashTag() throws IOException {
        String json = "{\"tag\": \"-\", \"id\": 378, \"item_count\": 1, \"is_favorite\": 1}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("-", tag.getTag());
        assertEquals(378, tag.getId());
        assertEquals(1, tag.getItemCount());
        assertEquals(1, tag.getIsFavorite());
    }

    @Test
    void parseJsonWithQuotesInTag() throws IOException {
        String json = "{\"tag\": \"\\\"Magnetism first\\\"\", \"id\": 589, \"item_count\": 47, \"is_favorite\": 1}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("\"Magnetism first\"", tag.getTag());
        assertEquals(589, tag.getId());
        assertEquals(47, tag.getItemCount());
        assertEquals(1, tag.getIsFavorite());
    }

    @Test
    void parseJsonWithParenthesesInTag() throws IOException {
        String json = "{\"tag\": \"(Cr,Mn)2GaC\", \"id\": 394, \"item_count\": 78, \"is_favorite\": 0}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("(Cr,Mn)2GaC", tag.getTag());
        assertEquals(394, tag.getId());
        assertEquals(78, tag.getItemCount());
        assertEquals(0, tag.getIsFavorite());
    }

    @Test
    void parseJsonWithColonInTag() throws IOException {
        String json = "{\"tag\": \"1:13\", \"id\": 511, \"item_count\": 1, \"is_favorite\": 0}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("1:13", tag.getTag());
        assertEquals(511, tag.getId());
        assertEquals(1, tag.getItemCount());
        assertEquals(0, tag.getIsFavorite());
    }

    @Test
    void parseJsonWithCommaInTag() throws IOException {
        String json = "{\"tag\": \"1.4301, rotary swaging\", \"id\": 276, \"item_count\": 2, \"is_favorite\": 0}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("1.4301, rotary swaging", tag.getTag());
        assertEquals(276, tag.getId());
        assertEquals(2, tag.getItemCount());
        assertEquals(0, tag.getIsFavorite());
    }

    @Test
    void parseJsonWithNumbersInTag() throws IOException {
        String json = "{\"tag\": \"57Fe\", \"id\": 418, \"item_count\": 136, \"is_favorite\": 0}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("57Fe", tag.getTag());
        assertEquals(418, tag.getId());
        assertEquals(136, tag.getItemCount());
        assertEquals(0, tag.getIsFavorite());
    }

    @Test
    void parseJsonWithLettersAndNumbersInTag() throws IOException {
        String json = "{\"tag\": \"A01\", \"id\": 278, \"item_count\": 37, \"is_favorite\": 0}";
        Tag tag = objectMapper.readValue(json, Tag.class);
        assertEquals("A01", tag.getTag());
        assertEquals(278, tag.getId());
        assertEquals(37, tag.getItemCount());
        assertEquals(0, tag.getIsFavorite());
    }
}