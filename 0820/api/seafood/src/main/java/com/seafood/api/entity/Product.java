package com.seafood.api.entity;

import java.util.Date;

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
@TableName("products")
@Data
public class Product {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("catalog_id")
	private Long catalogId;

	@TableField("category_id")
	private Long categoryId;

	@TableField("short_desc")
	private String shortDesc;

	@TableField("full_desc")
	private String fullDesc;

	@TableField("icon_url")
	private String iconUrl;

	@TableField("img_url")
	private String imgUrl;

	@TableField("name")
	private String name;

	@TableField("max_order_units")
	private Long maxOrderUnits;

	@TableField("min_order_units")
	private Long mixOrderUnits;

	@TableField("measuring_unit")
	private String measuringUnit;

	@TableField("order_step_units")
	private Long orderStepUnits;

	@TableField("create_time")
	private Date createTime;

	@TableField("update_time")
	private Date updateTime;
}
