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
@TableName("catalog")
@Data
public class Catalog {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("img_url")
	private String imgUrl;

	@TableField("name")
	private String name;

	@TableField("short_desc")
	private String shortDesc;

}
