package com.event.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.event.dto.Logininfo;

public class LoginRowMapper implements RowMapper<Logininfo> {

	@Override
	public Logininfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Logininfo login =new Logininfo();
		login.setUserName(rs.getString("userName"));
		login.setPassword(rs.getString("password"));
		return login;	
	}

}
