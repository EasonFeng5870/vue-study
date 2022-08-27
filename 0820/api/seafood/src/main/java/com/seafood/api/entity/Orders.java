package com.seafood.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/28
 **/
@TableName("orders")
@Data
public class Orders {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("user_id")
	private Long userId;

	@TableField("order_amount")
	private Double orderAmount;

	@TableField("payment_info")
	private String paymentInfo;

	@TableField("order_total")
	private Double orderTotal;

	@TableField("shopping_address_id")
	private Long shoppingAddressId;

	@TableField("shopping_subtotal")
	private Double shoppingSubtotal;

	@TableField("tax_subtotal")
	private Double taxSubtotal;
}
