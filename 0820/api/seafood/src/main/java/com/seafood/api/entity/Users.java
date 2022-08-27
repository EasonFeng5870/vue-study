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
@TableName("users")
@Data
public class Users {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("email")
	private String email;

	@TableField("id_authority")
	private String idAuthority;

}
