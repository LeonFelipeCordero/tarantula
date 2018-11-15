package com.ph.tarantula.service.controller;

import com.ph.tarantula.service.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
public class SitemapController {

    private final FileStorageService fileStorageService;

    @Autowired
    public SitemapController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping(value = "/sitemap{extension}")
    public ResponseEntity<Resource> sitemap(@PathVariable String extension,
                                            HttpServletRequest httpServletRequest) throws IOException {
        Resource resource;
        if (".xml".equals(extension)) {
            resource = fileStorageService.loadFileAsResource("/sitemap/sitemap.xml");
        } else if (".xml.gz".equals(extension)) {
            resource = fileStorageService.loadFileAsResource("/sitemap/sitemap.xml.gz");
        } else {
            throw new FileNotFoundException("File extension not allowed");
        }

        String contentType;
        contentType = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping(value = "/sitemap/{subSitemap}")
    public ResponseEntity<Resource> subSitemap(@PathVariable final String subSitemap,
                                               HttpServletRequest httpServletRequest) throws IOException {
        Resource resource;
        resource = fileStorageService.loadFileAsResource(String.format("/sitemap/sitemap_" + subSitemap, subSitemap));
//        if (subSitemap.contains(".xml.gz")) {
//            resource = fileStorageService.loadFileAsResource(String.format("/sitemap/%s.xml.gz", subSitemap));
//        } else if (subSitemap.contains(".xml")) {
//            resource = fileStorageService.loadFileAsResource(String.format("/sitemap/%s.xml", subSitemap));
//        } else {
//            throw new FileNotFoundException("The mentioned siteam does not exist");
//        }

        String contentType;
        contentType = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
