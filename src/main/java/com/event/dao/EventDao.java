package com.event.dao;

import java.util.List;

import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
import com.event.dto.UserDto;

public interface EventDao {
	public int addEvents(EventDto event);
	public List<EventDto> findAll();
	public List<CategoryDto> AllCategories();
	public List<EventDto> Upcomming();
	public List<UserDto> getAllUsers();
	public CategoryDto getCategory(String id);
	public Boolean login(String username,String password);
<<<<<<< HEAD
	public int updatevent(EventDto event,String id);
=======
	public int updatevent(EventDto event);
>>>>>>> f2fe5796daaa33ee077f2ad12c46f184a55764d6
	public EventDto getEventById(String id);
}
