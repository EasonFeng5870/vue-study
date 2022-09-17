package com.seafood.api.vo;

import java.io.Serializable;

import com.seafood.api.entity.OrderLineItem;
import com.seafood.api.entity.Product;
import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/09/10
 **/
@Data
public class LineItemVo extends OrderLineItem implements Serializable {

	private ProductVo product;

}
