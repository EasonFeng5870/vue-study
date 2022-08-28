package com.seafood.api.vo;

import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/25
 **/
@Data
public class ProductVo {

	private long id;

	private String name;

	private Double price;

	private String unit;

	private int inventory;

}
