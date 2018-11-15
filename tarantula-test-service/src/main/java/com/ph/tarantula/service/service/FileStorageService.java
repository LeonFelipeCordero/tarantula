package com.ph.tarantula.service.service;

import com.ph.tarantula.service.config.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
    }

    public Resource loadFileAsResource(String fileName) throws FileNotFoundException, MalformedURLException {
//        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        URL url = getClass().getResource(fileName);
        Resource resource = new UrlResource(url);
        if (resource.exists()) {
            return resource;
        } else {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }

}
