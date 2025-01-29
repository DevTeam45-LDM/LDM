package com.devteam45ldm.ldm.services;

import com.devteam45ldm.ldm.models.JsonTemplate;
import com.devteam45ldm.ldm.repositories.JsonTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JsonTemplateService {
    @Autowired
    private JsonTemplateRepository repository;

    public List<JsonTemplate> getAllTemplates() {
        return repository.findAll();
    }

    public JsonTemplate saveTemplate(JsonTemplate template) {
        if (template.getCreatedAt() == null) {
            template.setCreatedAt(LocalDateTime.now());
        }
        return repository.save(template);
    }

    public void deleteTemplate(String id) {
        repository.deleteById(id);
    }
}