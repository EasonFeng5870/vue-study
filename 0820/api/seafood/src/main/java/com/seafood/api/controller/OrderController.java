package com.seafood.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.seafood.api.dto.OrderDTO;
import com.seafood.api.service.OrderService;
import com.seafood.api.service.UserService;
import com.seafood.api.utils.Constants;
import com.seafood.api.vo.OrderVo;
import com.seafood.api.vo.ResponseData;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.seafood.api.utils.Constants.ERROR_USER_STATE_WRONG;
import static com.seafood.api.utils.Constants.ERROR_USER_STATE_WRONG_MESSAGE;

/**
 * order controller
 * @author eason
 * @date 2022/08/26
 **/
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Resource
	private OrderService orderService;

	@Resource
	private UserService userService;


	@GetMapping("/{userId}")
	public List<OrderVo> orders(
			@PathVariable(value = "userId", required = false) long userId) {
		//TODO
		userId = 1L;
		if (!userService.checkUserState(userId)) {
			return new ArrayList<>();
		}
		return orderService.ordersByUserId(userId);
	}

	/**
	 * get all orders by userId
	 * @param userId current user id
	 * @return return all orders
	 */
	@GetMapping("/listDemo/{userId}")
	public String ordersDemo(@PathVariable(name = "userId") long userId) {
		return "[\n"
				+ "    { \n"
				+ "        \"id\": 532358168848, \n"
				+ "        \"lineitems\": [ \n"
				+ "            { \"product\": { \"id\": 10101, \"name\": \"Shark\", \"price\": \"8.99\", \"unit\": \"lb\", \"inventory\": 2000 }, \"quantity\": 7, \"subtotal\": 62.93 }, \n"
				+ "            { \"product\": { \"id\": 10102, \"name\": \"Belt fish\", \"price\": \"6.99\", \"unit\": \"lb\", \"inventory\": 1000 }, \"quantity\": 4, \"subtotal\": 27.96 }, \n"
				+ "            { \"product\": { \"id\": 20101, \"name\": \"Vancouver\", \"price\": \"8.99\", \"unit\": \"lb\", \"inventory\": 2000 }, \"quantity\": 20, \"subtotal\": 179.8 } \n"
				+ "        ], \n"
				+ "        \"shippingaddress\": { \n"
				+ "            \"street_1\": \"3515 212th PL SE\", \"street_2\": \"Pooky Doo\", \"city\": \"Sammamish\", \"state\": \"Washington\", \"country\": \"United States\", \"zipcode\": \"98075-6235\" \n"
				+ "        }, \n"
				+ "        \"payinfo\": { \n"
				+ "            \"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\" \n"
				+ "        } \n"
				+ "    },\n"
				+ "    {\n"
				+ "        \"id\":422679566375,\n"
				+ "        \"lineitems\":[\n"
				+ "            {\"product\":{\"id\":10101,\"name\":\"Shark\",\"price\":\"8.99\",\"unit\":\"lb\",\"inventory\":2000},\"quantity\":10,\"subtotal\":89.9},\n"
				+ "            {\"product\":{\"id\":20102,\"name\":\"Red rock\",\"price\":\"6.99\",\"unit\":\"lb\",\"inventory\":1000},\"quantity\":20,\"subtotal\":139.8}\n"
				+ "        ],\n"
				+ "        \"shippingaddress\":{\n"
				+ "            \"street_1\":\"3515 212th PL SE\",\"street_2\":\"Pooky Doo\",\"city\":\"Sammamish\",\"state\":\"Washington\",\"country\":\"United States\",\"zipcode\":\"98075-6235\"\n"
				+ "        },\n"
				+ "        \"payinfo\":{\n"
				+ "            \"method\":\"CR\",\"account\":\"1234567890123456\",\"holdername\":\"Peekebo\",\"expirydate\":\"2710\",\"billingzipcode\":\"98003\"\n"
				+ "        }\n"
				+ "    }\n"
				+ "]";
	}

	/**
	 * get the order by userId and orderId
	 * @param userId current user Id
	 * @param orderId current order Id
	 * @return return order details
	 */
	@GetMapping("/{userId}/{orderId}")
	public OrderVo order(@PathVariable(name = "userId") long userId,
			@PathVariable(name = "orderId") long orderId) {
		//TODO
		userId = 1L;
		if (!userService.checkUserState(userId)) {
			return new OrderVo();
		}
		return orderService.getOrder(userId, orderId);
	}

	/**
	 * create an order
	 * @param orderDTO order information
	 * @return new order info
	 */
	@PostMapping("/")
	public OrderVo order(@RequestBody OrderDTO orderDTO) {
		//TODO
		orderDTO.setUserId(1L);
		if (!userService.checkUserState(orderDTO.getUserId())) {
			return new OrderVo();
		}
		return orderService.createOrder(orderDTO);
	}

	/**
	 * cancel order
	 * @param userId user id
	 * @param orderId order id
	 * @return if it is canceled.
	 */
	@DeleteMapping("/{userId}/{orderId}")
	public ResponseData cancelOrder(@PathVariable(name = "userId") long userId,
			@PathVariable(name = "orderId") long orderId) {
		//TODO
		userId = 1L;
		ResponseData rd = new ResponseData();
		if (!userService.checkUserState(userId)) {
			rd.setCode(ERROR_USER_STATE_WRONG);
			rd.setMsg(ERROR_USER_STATE_WRONG_MESSAGE);
			return rd;
		}
		boolean updateState = orderService.cancelOrder(userId, orderId);
		Map<String, Object> map = new HashMap<>();
		map.put("updateState", updateState);
		rd.setContent(map);
		if (updateState) {
			rd.setCode(Constants.OK);
			rd.setMsg(Constants.MESSAGE);
		} else {
			rd.setCode(Constants.ERROR_CANCEL_ORDER_FAILED);
			rd.setMsg(Constants.ERROR_CANCEL_ORDER_FAILED_MESSAGE);
		}
		return rd;
	}

}