package com.seafood.api.service;

import java.util.List;

import com.seafood.api.entity.Order;
import com.seafood.api.mapper.OrderMapper;

import org.springframework.stereotype.Service;

/**
 *
 * @author eason
 * @date 2022/08/28
 **/
@Service
public class OrderService {

	private OrderMapper orderMapper;

	/**
	 * get all orders by user id
	 * @param userId user id
	 * @return orders
	 */
	public List<Order> ordersByUserId(long userId) {
		return orderMapper.getOrdersByUserId(userId);
	}

	/**
	 * get the order
	 * @param userId user id
	 * @param orderId order id
	 * @return the order
	 */
	public Order getOrder(long userId, long orderId) {
		return orderMapper.getTheOrder(userId, orderId);
	}

	/**
	 * create an order
	 * @param orders order info
	 * @return order id and order payment info
	 */
	public String createOrder(Order orders) {
		orderMapper.insert(orders);
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
