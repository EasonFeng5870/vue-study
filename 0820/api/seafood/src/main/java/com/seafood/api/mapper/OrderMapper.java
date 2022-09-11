package com.seafood.api.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seafood.api.entity.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;

/**
 *
 * @author eason
 * @date 2022/08/27
 **/
@Repository
public interface OrderMapper extends BaseMapper<Order> {

	/**
	 * get the order
	 * @param userId user id
	 * @param orderId order id
	 * @return the order
	 */
	@Select("select * from orders where user_id=#{userId} and id=#{orderId}")
	Order getTheOrder(long userId, long orderId);

	/**
	 * get orders by user id
	 * @param userId user id
	 * @return orders
	 */
	@Select("select * from orders where user_id=#{userId}")
	List<Order> getOrdersByUserId(long userId);

	/**
	 * cancel order, only status is 1
	 * @param orderId order id
	 * @param userId user id
	 * @return effect rows.
	 */
	@Update("update orders set status=2 where id=#{orderId} and user_id=#{userId} and status=1")
	int updateByIdWithUserId(long orderId, long userId);
}
