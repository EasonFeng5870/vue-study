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
@TableName("user")
@Data
public class User {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("email")
	private String email;

	/**
	 * user source, set aws is 0, google is 1, github is 2
	 */
	@TableField("id_type")
	private int idType;

	/**
	 * user id from type
	 */
	@TableField("id_authority")
	private String idAuthority;

	@TableField("user_img")
	private String userImg;

	@TableField("create_time")
	private Date createTime;

	@TableField("update_time")
	private Date updateTime;

}
