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

	private List<ProductCategory> productcategories;

}
