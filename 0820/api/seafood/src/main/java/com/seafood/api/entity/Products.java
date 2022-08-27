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
@TableName("products")
@Data
public class Products {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("catalog_id")
	private Long catalogId;

	@TableField("category_id")
	private Long categoryId;

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

	@TableField("short_desc")
	private String shortDesc;
}
