package com.seafood.api.vo;

import java.util.List;

import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/25
 **/
@Data
public class SubCategory {

	private long id;

	private String name;

	private String description;

	private List<ProductVo> products;

}
