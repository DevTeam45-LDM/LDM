package com.devteam45ldm.ldm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/test/mongo-connection")
    public ResponseEntity<String> testMongoConnection() {
        if (mongoTemplate.getDb().getName().equals("ldm")) {
            return ResponseEntity.ok("MongoDB connection is successful.");
        } else {
            return ResponseEntity.status(500).body("MongoDB connection failed.");
        }
    }
}