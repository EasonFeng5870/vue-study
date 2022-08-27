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
@TableName("order_line_itmes")
@Data
public class OrderLineItems {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@TableField("order_id")
	private Long orderId;

	@TableField("product_id")
	private Long productId;

}
