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
<<<<<<< HEAD
    
    public void delete(String filename);
=======
>>>>>>> f2fe5796daaa33ee077f2ad12c46f184a55764d6
}
