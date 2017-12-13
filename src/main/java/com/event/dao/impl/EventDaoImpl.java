package com.event.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.event.dao.EventDao;
import com.event.dto.CategoryDto;
import com.event.dto.EventDto;
import com.event.util.CategoryRowMapper;
import com.event.util.EventRowMapper;
@Repository("EventDao")
public class EventDaoImpl implements EventDao{
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	public int addEvents(EventDto event){
		String query = "insert into events values(:id,:name,:desc,:image,:fromdate,:todate,:userid,:catid)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", event.getEventId());
		map.put("name", event.getEventName());
		map.put("desc", event.getEventDesc());
		map.put("image", event.getEventImage());
		map.put("fromdate", event.getFromDate());
		map.put("todate", event.getToDate());
		map.put("userid",event.getUserId());
		map.put("catid",event.getCategory_id());
		return jdbcTemplate.update(query, map);
	}
	public List<EventDto> findAll() {
		String query = "select * from events";
		return jdbc.query(query, new EventRowMapper());
	}
	public List<CategoryDto> AllCategories() {
		String query = "select * from categories";
		return jdbc.query(query, new CategoryRowMapper());
	}
	public List<EventDto> Upcomming(){
		String query= "select * from events where fromDate >= DATE(NOW())";
		return jdbc.query(query, new EventRowMapper());
	}
	
}
