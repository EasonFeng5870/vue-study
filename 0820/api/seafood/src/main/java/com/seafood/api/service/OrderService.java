package com.seafood.api.service;

import java.util.List;

import com.seafood.api.entity.Orders;
import com.seafood.api.mapper.OrdersMapper;

import org.springframework.stereotype.Service;

/**
 *
 * @author eason
 * @date 2022/08/28
 **/
@Service
public class OrderService {

	private OrdersMapper ordersMapper;

	/**
	 * get all orders by user id
	 * @param userId user id
	 * @return orders
	 */
	public List<Orders> ordersByUserId(long userId) {
		return ordersMapper.getOrdersByUserId(userId);
	}

	/**
	 * get the order
	 * @param userId user id
	 * @param orderId order id
	 * @return the order
	 */
	public Orders getOrder(long userId, long orderId) {
		return ordersMapper.getTheOrder(userId, orderId);
	}

	/**
	 * create an order
	 * @param orders order info
	 * @return order id and order payment info
	 */
	public String createOrder(Orders orders) {
		ordersMapper.insert(orders);
		return orders.getId() + "|" + orders.getPaymentInfo();
	}

	/**
	 * cancel an order
	 * @param userId user id
	 * @param orderId order id
	 * @return
	 */
	public String cancelOrder(long userId, long orderId) {
		return "{}";
	}
}
