package com.devteam45ldm.ldm.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "json_templates")
public class JsonTemplate {
    @Id
    private String id;
    private String templateName;
    private String category;
    private String status;
    private List<String> tags;
    private String machineName;
    private LocalDateTime createdAt;
    private List<FieldMapping> fieldMappings;

    // Getters
    public String getId() { return id; }
    public String getTemplateName() { return templateName; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public List<String> getTags() { return tags; }
    public String getMachineName() { return machineName; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<FieldMapping> getFieldMappings() { return fieldMappings; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setCategory(String category) { this.category = category; }
    public void setStatus(String status) { this.status = status; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public void setMachineName(String machineName) { this.machineName = machineName; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setFieldMappings(List<FieldMapping> fieldMappings) { this.fieldMappings = fieldMappings; }

    public static class FieldMapping {
        private String jsonPath;
        private String displayName;
        private String fieldType;

        // Getters
        public String getJsonPath() { return jsonPath; }
        public String getDisplayName() { return displayName; }
        public String getFieldType() { return fieldType; }

        // Setters
        public void setJsonPath(String jsonPath) { this.jsonPath = jsonPath; }
        public void setDisplayName(String displayName) { this.displayName = displayName; }
        public void setFieldType(String fieldType) { this.fieldType = fieldType; }
    }
}