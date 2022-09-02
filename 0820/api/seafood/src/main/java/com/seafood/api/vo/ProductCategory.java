package com.seafood.api.vo;

import java.util.List;

import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
@Data
public class ProductCategory {

	private long id;

	private String name;

	private String description;

	private long parentId;

	private List<SubCategory> subcategories;

}
