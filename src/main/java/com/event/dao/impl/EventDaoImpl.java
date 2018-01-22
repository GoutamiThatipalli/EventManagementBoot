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
import com.event.dto.Logininfo;
import com.event.dto.UserDto;
import com.event.util.CategoryRowMapper;
import com.event.util.EventRowMapper;
import com.event.util.LoginRowMapper;
import com.event.util.UsersRowMapper;
@Repository("EventDao")
public class EventDaoImpl implements EventDao{
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	public int addEvents(EventDto event){
		String query = "insert into events values(:id,:name,:desc,:image,:fromdate,:todate,:catid,:emailid)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", event.getEventId());
		map.put("name", event.getEventName());
		map.put("desc", event.getEventDesc());
		map.put("image", event.getEventImage());
		map.put("fromdate", event.getFromDate());
		map.put("todate", event.getToDate());
		map.put("catid",event.getCategory_id());
		map.put("emailid",event.getEmailId());		
		return jdbcTemplate.update(query, map);
	}

	public int updatevent(EventDto event,String id){
		String query = "update events set eventName=:name, eventDescription=:desc, eventImage=:image,fromDate=:from,toDate=:date where eventId=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", event.getEventName());
		map.put("desc", event.getEventDesc());
		map.put("image", event.getEventImage());
		map.put("from", event.getFromDate());
		map.put("date", event.getToDate());
		map.put("id",id);
		return jdbcTemplate.update(query, map);
		
	}
	public Boolean login(String userName,String password){
		 String query = "select * from users where userName=:user and password=:pass";
		 Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", userName);
			map.put("pass", password);	
			List<Logininfo> Logininfo=jdbcTemplate.query(query,map,new LoginRowMapper());
		    return Logininfo.isEmpty() ? false:true; 
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
	public List<UserDto> getAllUsers(){
		String query = "select * from users";
		return jdbc.query(query, new UsersRowMapper());
		
	}
	public EventDto getEventById(String id){
		String query = "select * from events where eventId=?";	
		
		return jdbc.queryForObject(query, new Object[]{id}, new EventRowMapper());		
	}
	public CategoryDto getCategory(String id){
		String query = "select * from categories where category_id=?";	
		return jdbc.queryForObject(query, new Object[]{id}, new CategoryRowMapper());		
	}
}
