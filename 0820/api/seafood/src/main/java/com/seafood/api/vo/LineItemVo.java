package com.seafood.api.vo;

import java.io.Serializable;

import com.seafood.api.entity.Product;
import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/09/10
 **/
@Data
public class LineItemVo implements Serializable {

	private long id;

	private Product product;

	private int quantity;

	private double subtotal;

	private String expressNumber;

	private String expressCompany;

	private int expressType;
}
