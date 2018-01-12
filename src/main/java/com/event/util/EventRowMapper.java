package com.event.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.event.dto.EventDto;
import com.event.service.StorageService;


public class EventRowMapper implements RowMapper<EventDto> {
	@Autowired
	StorageService storageService;
	@Override
	public EventDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventDto event =new EventDto();
		event.setEventId(rs.getString("eventId"));
		event.setEventName(rs.getString("eventName"));
		event.setEventDesc(rs.getString("eventDescription"));
		event.setEventImage(rs.getString("eventImage"));
		event.setFromDate(rs.getString("fromDate"));
		event.setToDate(rs.getString("toDate"));
		event.setEmailId(rs.getString("emailId"));
		event.setCategory_id(rs.getString("category_id"));
		return event;
	}

}
