package com.devteam45ldm.ldm.views.eLabClient.createReport;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<CreateReport.FileDocument, String> {
}