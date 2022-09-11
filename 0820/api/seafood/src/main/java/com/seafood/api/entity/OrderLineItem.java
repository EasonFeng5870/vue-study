package com.seafood.api.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author eason
 * @date 2022/08/28
 **/
@TableName("order_line_items")
@Data
public class OrderLineItem {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("order_id")
	private Long orderId;

	@TableField("product_id")
	private Long productId;

	@TableField("quantity")
	private Integer quantity;

	@TableField("subtotal")
	private Double subTotal;

	@TableField("express_number")
	private String expressNumber;

	@TableField("express_company")
	private String expressCompany;

	@TableField("express_type")
	private int expressType;

	@TableField("create_time")
	private Date createTime;

	@TableField("update_time")
	private Date updateTime;

}
