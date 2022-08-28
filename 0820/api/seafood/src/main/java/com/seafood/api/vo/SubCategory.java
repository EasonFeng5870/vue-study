package com.seafood.api.vo;

import java.util.List;

/**
 *
 * @author eason
 * @date 2022/08/25
 **/
public class SubCategory {

	private int id;

	private String name;

	private String description;

	private List<ProductVo> products;

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

	public List<ProductVo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVo> products) {
		this.products = products;
	}
}
