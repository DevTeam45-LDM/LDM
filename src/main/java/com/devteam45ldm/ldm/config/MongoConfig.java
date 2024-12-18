package com.devteam45ldm.ldm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.devteam45ldm.ldm")
public class MongoConfig {
}

