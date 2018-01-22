package com.event.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.event.dto.CategoryDto;

public class CategoryRowMapper implements RowMapper<CategoryDto> {

	@Override
	public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryDto category =new CategoryDto();
		category.setCategory_id(rs.getString("category_id"));
		category.setCategoryName(rs.getString("categoryName"));
		category.setCategoryDesc(rs.getString("categoryDesc"));
		category.setCategoryLogo(rs.getString("categoryLogo"));
		return category;
	}
}
