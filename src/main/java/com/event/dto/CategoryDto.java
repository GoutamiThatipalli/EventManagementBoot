package com.event.dto;

public class CategoryDto {
	String category_id;
	String categoryName;
	String categoryDesc;
	String categoryLogo;
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getCategoryLogo() {
		return categoryLogo;
	}
	public void setCategoryLogo(String categoryLogo) {
		this.categoryLogo = categoryLogo;
	}

}
