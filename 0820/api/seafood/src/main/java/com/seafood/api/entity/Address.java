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
 * @date 2022/08/27
 **/
@TableName("address")
@Data
public class Address {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("user_id")
	private Long userId;

	@TableField("apt_num")
	private String aptNum;

	@TableField("city")
	private String city;

	@TableField("state")
	private String state;

	@TableField("street1")
	private String street1;

	@TableField("street2")
	private String street2;

	@TableField("country")
	private String country;

	@TableField("zipcode")
	private String zipcode;

	@TableField("create_time")
	private Date createTime;

	@TableField("update_time")
	private Date updateTime;

}
