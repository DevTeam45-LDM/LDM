package com.devteam45ldm.ldm.repositories;

import com.devteam45ldm.ldm.models.JsonTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonTemplateRepository extends MongoRepository<JsonTemplate, String> {
}