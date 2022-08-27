package com.seafood.api.vo;

import java.util.List;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
public class ProductCategory {

	private int id;

	private String name;

	private String description;

	private List<SubCategory> subcategories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SubCategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}
}
