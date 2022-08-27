package com.seafood.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 * @author eason
 * @date 2022/08/27
 **/
@TableName("categories")
@Data
public class Categories {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("catalog_id")
	private Long catalogId;

	@TableField("full_desc")
	private String fullDesc;

	@TableField("icon_url")
	private String iconUrl;

	@TableField("img_url")
	private String imgUrl;

	@TableField("name")
	private String name;

	@TableField("parent_id")
	private Long parentId;

	@TableField("short_desc")
	private String shortDesc;

}
