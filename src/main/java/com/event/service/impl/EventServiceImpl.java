package com.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.event.dao.EventDao;
import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
import com.event.service.EventService;
@Component
@Repository("EventService")
public class EventServiceImpl implements EventService {
	@Autowired
	EventDao eventDao;
	
	@Override
	public int addEvents(EventDto event) {
		// TODO Auto-generated method stub
		return eventDao.addEvents(event);
	}
	@Override
	public List<EventDto> findAll() {
		// TODO Auto-generated method stub
		return eventDao.findAll();
	}
	@Override
	public List<CategoryDto> AllCategories() {
		// TODO Auto-generated method stub
		return eventDao.AllCategories();
	}
	@Override
	public List<EventDto> Upcomming() {
		// TODO Auto-generated method stub
		return eventDao.Upcomming();
	}

}
