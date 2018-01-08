package com.event.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
import com.event.dto.Logininfo;
import com.event.dto.UserDto;
import com.event.service.EventService;
import com.event.service.StorageService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "events")
public class EventController {
	@Autowired
	StorageService storageService;

	@Autowired
	EventService eventService;

	List<String> files = new ArrayList<String>();

	@CrossOrigin
	@RequestMapping(value = "addevents", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<String> addEvents(@RequestPart("file") MultipartFile file, @RequestPart("data") EventDto event) {
		String message = "";
		try {
			storageService.store(file);
			eventService.addEvents(event);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@CrossOrigin
	@RequestMapping(value = "getAllEvents")
	public List<EventDto> findAll() {
		return eventService.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "auth", method = RequestMethod.POST, consumes = { "application/json" })
	public boolean login(@RequestBody Logininfo user,HttpServletRequest request,HttpServletResponse response) {
	
		String uuid = UUID.randomUUID().toString();
		response.addCookie(new Cookie("x-auth-token", uuid));	
		return eventService.login(user);
	}

	@CrossOrigin
	@RequestMapping(value = "getAllCategories")
	@Transactional(readOnly = true)
	public List<CategoryDto> AllCategories() {
		//System.out.println("cookie value is"+cookievalue);
		return eventService.AllCategories();
	}

	@CrossOrigin
	@RequestMapping(value = "upcomming")
	@Transactional(readOnly = true)
	public List<EventDto> Upcomming() {
		return eventService.Upcomming();
	}

	@CrossOrigin
	@RequestMapping(value = "getAllUsers")
	@Transactional(readOnly = true)
	public List<UserDto> getAllUsers() {
		return eventService.getAllUsers();
	}

	@CrossOrigin
	@RequestMapping(value = "getCategoryById/{id}")
	@Transactional(readOnly = true)
	public CategoryDto getCategory(@PathVariable("id") String id) {
		return eventService.getCategory(id);
	}
}
