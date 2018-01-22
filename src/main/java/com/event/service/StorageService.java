package com.event.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public interface StorageService {

    void store(MultipartFile file);

    public Resource loadFile(String filename);
    
    public void deleteAll();
    
    public void init();
}
