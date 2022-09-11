package com.seafood.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.seafood.api.entity.Order;
import com.seafood.api.mapper.AddressMapper;
import com.seafood.api.mapper.OrderMapper;
import com.seafood.api.vo.OrderVo;

import org.springframework.stereotype.Service;

/**
 *
 * @author eason
 * @date 2022/08/28
 **/
@Service
public class OrderService {

	@Resource
	private OrderMapper orderMapper;

	@Resource
	private AddressMapper addressMapper;

	@Resource
	private OrderLineItemService itemService;



	/**
	 * get all orders by user id
	 * @param userId user id
	 * @return orders
	 */
	public List<OrderVo> ordersByUserId(long userId) {
		List<OrderVo> vos = new ArrayList<>();
		List<Order> orders = orderMapper.getOrdersByUserId(userId);
		for (Order o : orders) {
			vos.add(convertOrderToVo(o));
		}
		return vos;
	}

	/**
	 * get the order
	 * @param userId user id
	 * @param orderId order id
	 * @return the order
	 */
	public OrderVo getOrder(long userId, long orderId) {
		Order o = orderMapper.getTheOrder(userId, orderId);
		return convertOrderToVo(o);
	}

	private OrderVo convertOrderToVo(Order o) {
		OrderVo vo = new OrderVo();
		vo.setId(o.getId());
		Map<String, Object> map = new HashMap<>();
		map.put("id", o.getShippingAddressId());
		vo.setShippingAddress(addressMapper.selectByMap(map).get(0));
		vo.setPayInfo(o.getPaymentInfo());
		vo.setLineItemVos(itemService.getOrderLineItemsByOrderId(o.getId()));
		return vo;
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
	public Boolean cancelOrder(long userId, long orderId) {
		int updatedRows = orderMapper.updateByIdWithUserId(orderId, userId);
		if (updatedRows == 1) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
