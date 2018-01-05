package com.event.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.event.dto.UserDto;

public class UsersRowMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto user=new UserDto();
		user.setUserId(rs.getString("userId"));
		user.setUserName(rs.getString("userName"));
		user.setFirstName(rs.getString("firstName"));
		user.setMiddleName(rs.getString("middleName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("emailId"));
		user.setMobile(rs.getString("mobile"));
		user.setCreatedOn(rs.getString("createdOn"));
		user.setPassword(rs.getString("password"));
		return user;
	}
}
