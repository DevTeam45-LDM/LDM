package com.devteam45ldm.ldm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.net.InetAddress;

@RestController
public class PingController {
    @GetMapping("/ping/mongo-container")
    public ResponseEntity<String> pingMongoContainer() {
        try {
            InetAddress address = InetAddress.getByName("mongo");
            boolean reachable = address.isReachable(5000); // Timeout in milliseconds
            if (reachable) {
                return ResponseEntity.ok("MongoDB container is reachable.");
            } else {
                return ResponseEntity.status(500).body("MongoDB container is not reachable.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while pinging the MongoDB container: " + e.getMessage());
        }
    }

    @GetMapping("/ping/vault-container")
    public ResponseEntity<String> pingVaultContainer() {
        try {
            InetAddress address = InetAddress.getByName("vault");
            boolean reachable = address.isReachable(5000); // Timeout in milliseconds
            if (reachable) {
                return ResponseEntity.ok("Hashicorp Vault container is reachable.");
            } else {
                return ResponseEntity.status(500).body("Hashicorp Vault container is not reachable.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while pinging the Hashicorp Vault container: " + e.getMessage());
        }
    }

    @GetMapping("/ping/keycloak-container")
    public ResponseEntity<String> pingKeycloakContainer() {
        try {
            InetAddress address = InetAddress.getByName("keycloak");
            boolean reachable = address.isReachable(5000); // Timeout in milliseconds
            if (reachable) {
                return ResponseEntity.ok("Keycloak container is reachable.");
            } else {
                return ResponseEntity.status(500).body("Keycloak container is not reachable.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while pinging the Keycloak container: " + e.getMessage());
        }
    }
}