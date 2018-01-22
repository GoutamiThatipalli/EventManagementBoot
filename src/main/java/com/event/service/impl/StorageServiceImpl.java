package com.event.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.event.service.StorageService;
@Component
@Repository("StorageService")
public class StorageServiceImpl implements StorageService {
<<<<<<< HEAD
	private final Path rootLocation = Paths.get("/home/goutamit/Event-Management-master/src/assets/img/fileupload");
=======
	private final Path rootLocation = Paths.get("/home/goutamit/eventManagement/src/assets/img/fileupload");
>>>>>>> f2fe5796daaa33ee077f2ad12c46f184a55764d6

	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));

		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			} 
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
 
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
<<<<<<< HEAD
	public void delete(String filename){
		java.io.File file = new java.io.File("rootLocation/filename");
		 file.delete();
		 }
=======
>>>>>>> f2fe5796daaa33ee077f2ad12c46f184a55764d6
 
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
