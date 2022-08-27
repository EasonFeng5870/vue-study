package com.seafood.api.vo;

import java.util.List;

import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
@Data
public class CatalogVo {

	private long id;

	private String name;

	private String desc;

	private List<ProductCategory> productCategories;

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

	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}
}
