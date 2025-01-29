package com.devteam45ldm.ldm.repositories;

import com.devteam45ldm.ldm.models.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JsonTemplateRepository extends MongoRepository<Template, String> {
}