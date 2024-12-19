package com.devteam45ldm.ldm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private VaultTemplate vaultTemplate;

    @GetMapping("/test/mongo-connection")
    public ResponseEntity<String> testMongoConnection() {
        if (mongoTemplate.getDb().getName().equals("ldm")) {
            return ResponseEntity.ok("MongoDB connection is successful.");
        } else {
            return ResponseEntity.status(500).body("MongoDB connection failed.");
        }
    }

    @GetMapping("/test/vault-connection")
    public ResponseEntity<String> testVaultConnection() {
        try {
            vaultTemplate.opsForSys().health();
            return ResponseEntity.ok("Hashicorp Vault connection is successful.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Hashicorp Vault connection failed: " + e.getMessage());
        }
    }
}