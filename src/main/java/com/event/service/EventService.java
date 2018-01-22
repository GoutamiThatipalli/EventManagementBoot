package com.event.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
import com.event.dto.Logininfo;
import com.event.dto.UserDto;
@Component
public interface EventService {
	public int addEvents(EventDto event);
	public List<EventDto> findAll();
	public List<CategoryDto> AllCategories();
	public List<EventDto> Upcomming();
	public List<UserDto> getAllUsers();
	public CategoryDto getCategory(String id);
	public Boolean login(Logininfo login);
<<<<<<< HEAD
	public int updatevent(EventDto event,String id);
=======
	public int updatevent(EventDto event);
>>>>>>> f2fe5796daaa33ee077f2ad12c46f184a55764d6
	public EventDto getEventById(String id);
}
