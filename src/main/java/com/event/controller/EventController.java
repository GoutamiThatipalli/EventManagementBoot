package com.event.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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

@CrossOrigin("*")
@RequestMapping(value = "events")
public class EventController {
	 @Context
	    HttpHeaders headers;
	@Autowired
	StorageService storageService;

	@Autowired
	EventService eventService;

	List<String> files = new ArrayList<String>();
	
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
	@RequestMapping(value = "updatevents/{id}",method = RequestMethod.PUT, consumes= {"application/json"} )
	public  int updatevent1(@PathVariable("id") String id,@RequestBody EventDto event){
		return eventService.updatevent(event,id);
		}

	@RequestMapping(value = "getAllEvents")
	public List<EventDto> findAll() {
		return eventService.findAll();
	}

	@RequestMapping(value = "auth", method = RequestMethod.POST, consumes = { "application/json" })
	public  ResponseEntity<String> login(@RequestBody Logininfo user, HttpServletResponse response) {
		if (eventService.login(user) == true) {
			String uuid = UUID.randomUUID().toString();
	        response.addCookie(new Cookie("x-auth-token", uuid));
	        return new ResponseEntity<String>(uuid,HttpStatus.OK);    

		}
		else{
			return new ResponseEntity<String>("",HttpStatus.OK);    
		}
	}
	@RequestMapping(value = "getAllCategories")
	@Transactional(readOnly = true)
	public List<CategoryDto> AllCategories(HttpServletRequest request) {
		return eventService.AllCategories();
	}

	@RequestMapping(value = "upcomming")
	@Transactional(readOnly = true)
	public List<EventDto> Upcomming() {
		return eventService.Upcomming();
	}

	@RequestMapping(value = "getAllUsers")
	@Transactional(readOnly = true)
	public List<UserDto> getAllUsers() {
		return eventService.getAllUsers();
	}

	@RequestMapping(value = "getCategoryById/{id}")
	@Transactional(readOnly = true)
	public CategoryDto getCategory(@PathVariable("id") String id) {
		return eventService.getCategory(id);
	}
	
	@RequestMapping(value = "getEventById/{id}")
	@Transactional(readOnly = true)
	public EventDto getEventById(@PathVariable("id") String id) {
		return eventService.getEventById(id);
	}
}
