package com.seafood.api.controller;

import java.util.List;

import com.seafood.api.entity.Order;
import com.seafood.api.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * order controller
 * @author eason
 * @date 2022/08/26
 **/
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	/**
	 * get all orders by userId
	 * @param userId current user id
	 * @return return all orders
	 */
	@GetMapping("/{userId}")
	public List<Order> orders(@PathVariable(name = "userId") long userId) {
		List<Order> ordersList = orderService.ordersByUserId(userId);
		return ordersList;
	}

	/**
	 * get the order by userId and orderId
	 * @param userId current user Id
	 * @param orderId current order Id
	 * @return return order details
	 */
	@GetMapping("/{userId}/{orderId}")
	public Order order(@PathVariable(name = "userId") long userId,
			@PathVariable(name = "orderId") long orderId) {
		return orderService.getOrder(userId, orderId);
	}

	/**
	 * create an order
	 * @param requestBody order information
	 * @return new order info
	 */
	@PostMapping("/")
	public String order(@RequestBody String requestBody) {
		Order orders = new Order();
		return orderService.createOrder(orders);
	}

	/**
	 * cancel order
	 * @param userId user id
	 * @param orderId order id
	 * @return if it is canceled.
	 */
	@DeleteMapping("/{userId}/{orderId}")
	public String cancelOrder(@PathVariable(name = "userId") long userId,
			@PathVariable(name = "orderId") long orderId) {
		return orderService.cancelOrder(userId, orderId);
	}

}