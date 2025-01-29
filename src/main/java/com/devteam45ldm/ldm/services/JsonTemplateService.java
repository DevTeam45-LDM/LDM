package com.devteam45ldm.ldm.services;

import com.devteam45ldm.ldm.models.Template;
import com.devteam45ldm.ldm.repositories.JsonTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JsonTemplateService {
    @Autowired
    private JsonTemplateRepository repository;

    public List<Template> findAll() {
        return repository.findAll();
    }

    public Template save(Template template) {
        if (template.getCreatedAt() == null) {
            template.setCreatedAt(LocalDateTime.now());
        }
        return repository.save(template);
    }
}