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
	private double subTotal;

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

	@TableField("measuring_unit")
	private String measuringUnit;

	@TableField("units_ordered")
	private long unitsOrdered;

	@TableField("unit_price")
	private double unitPrice;

	@TableField("line_amount")
	private double lineAmount;

	@TableField("line_tax")
	private double lineTax;

	@TableField("line_total")
	private double lineTotal;

}
