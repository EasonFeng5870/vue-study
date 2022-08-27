package com.seafood.api.controller;

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

	/**
	 * get all orders by userId
	 * @param userId current user id
	 * @return return all orders
	 */
	@GetMapping("/{userId}")
	public String orders(@PathVariable(name = "userId") String userId) {
		return "{}";
	}

	/**
	 * get the order by userId and orderId
	 * @param userId current user Id
	 * @param orderId current order Id
	 * @return return order details
	 */
	@GetMapping("/{userId}/{orderId}")
	public String order(@PathVariable(name = "userId") String userId,
			@PathVariable(name = "orderId") String orderId) {
		return "{}";
	}

	/**
	 * create an order
	 * @param requestBody order information
	 * @return new order info
	 */
	@PostMapping("/")
	public String order(@RequestBody String requestBody) {
		return "{}";
	}

	@DeleteMapping("/{userId}/{orderId}")
	public String cancelOrder(@PathVariable(name = "userId") String userId,
			@PathVariable(name = "orderId") String orderId) {
		return "{}";
	}

}