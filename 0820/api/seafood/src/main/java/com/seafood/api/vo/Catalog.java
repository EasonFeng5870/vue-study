package com.seafood.api.vo;

import java.util.List;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
public class Catalog {

	private int id;

	private String name;

	private String desc;

	private List<ProductCatagory> productCatagories;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<ProductCatagory> getProductCatagories() {
		return productCatagories;
	}

	public void setProductCatagories(List<ProductCatagory> productCatagories) {
		this.productCatagories = productCatagories;
	}
}
