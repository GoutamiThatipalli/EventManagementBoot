package com.event.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.event.dto.EventDto;


public class EventRowMapper implements RowMapper<EventDto> {

	@Override
	public EventDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventDto event =new EventDto();
		event.setEventId(rs.getString("eventId"));
		event.setEventName(rs.getString("eventName"));
		event.setEventDesc(rs.getString("eventDesc"));
		event.setEventImage(rs.getString("eventImage"));
		event.setFromDate(rs.getString("fromDate"));
		event.setToDate(rs.getString("toDate"));
		event.setUserId(rs.getString("userId"));
		event.setCategory_id(rs.getString("category_id"));
		return event;
	}

}
