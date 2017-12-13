package com.event.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
@Component
public interface EventService {
	public int addEvents(EventDto event);
	public List<EventDto> findAll();
	public List<CategoryDto> AllCategories();
	public List<EventDto> Upcomming();
}
