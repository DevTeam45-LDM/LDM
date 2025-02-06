package com.devteam45ldm.ldm.controller;

import com.devteam45ldm.ldm.views.eLabClient.createReport.CreateReport;
import com.devteam45ldm.ldm.views.eLabClient.createReport.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/files/{id}")
    public String getFile(@PathVariable String id) {
        CreateReport.FileDocument fileDocument = fileRepository.findById(id).orElseThrow(() -> new RuntimeException("File not found"));
        return fileDocument.getContent();
    }
}
