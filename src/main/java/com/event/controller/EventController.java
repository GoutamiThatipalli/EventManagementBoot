package com.event.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
import com.event.dto.UserDto;
import com.event.service.EventService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "events")
public class EventController {
	@Autowired
	EventService eventService;
	@CrossOrigin
	@RequestMapping(value = "addevents", method = RequestMethod.POST, consumes = { "application/json" })
	public int addEvents(@RequestBody EventDto event){
		return eventService.addEvents(event);
	}
	@CrossOrigin
	@RequestMapping(value = "getAllEvents")
	@Transactional(readOnly = true)
	public List<EventDto> findAll() {
		return eventService.findAll();
	}
	@CrossOrigin
	@RequestMapping(value = "getAllCategories")
	@Transactional(readOnly = true)
	public List<CategoryDto> AllCategories() {
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
}
