package com.seafood.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.seafood.api.dto.OrderDTO;
import com.seafood.api.entity.Address;
import com.seafood.api.entity.Order;
import com.seafood.api.entity.OrderLineItem;
import com.seafood.api.mapper.AddressMapper;
import com.seafood.api.mapper.OrderLineItemMapper;
import com.seafood.api.mapper.OrderMapper;
import com.seafood.api.vo.LineItemVo;
import com.seafood.api.vo.OrderVo;

import org.springframework.stereotype.Service;

import static com.seafood.api.utils.Constants.ERROR_CREATE_ORDER_FAILED;
import static com.seafood.api.utils.Constants.ERROR_CREATE_ORDER_FAILED_MESSAGE;

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

	@Resource
	private AddressService addressService;

	@Resource
	private OrderLineItemMapper orderLineItemMapper;

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
	 * @param orderDTO order info
	 * @return order id and order payment info
	 */
	public OrderVo createOrder(OrderDTO orderDTO) {
		List<LineItemVo> items = orderDTO.getLineitems();
		if (items == null) {
			OrderVo vo = new OrderVo();
			vo.setReason(ERROR_CREATE_ORDER_FAILED_MESSAGE);
			vo.setReasonCode(ERROR_CREATE_ORDER_FAILED);
			return vo;
		}

		//save order status:0
		Order order = new Order();
		order.setUserId(orderDTO.getUserId());
		order.setPaymentInfo(orderDTO.getPayInfo());

		Address shippingAddress = orderDTO.getShippingAddress();
		Address address = null;
		if (orderDTO.getShippingAddress().getId() != 0) {
			order.setShippingAddressId(shippingAddress.getId());
			address = addressMapper.selectById(shippingAddress.getId());
		} else {
			//create shipping address
			address = new Address();
			address.setAptNum(shippingAddress.getAptNum());
			address.setCity(shippingAddress.getCity());
			address.setCountry(shippingAddress.getCountry());
			address.setState(shippingAddress.getState());
			address.setStreetOne(shippingAddress.getStreetOne());
			address.setStreetTwo(shippingAddress.getStreetTwo());
			address.setZipcode(shippingAddress.getZipcode());
			address.setUserId(orderDTO.getUserId());
			addressService.saveAddress(address);
			order.setShippingAddressId(address.getId());
		}
		orderMapper.insert(order);

		double allTax = 0;
		double allTotal = 0;
		for (LineItemVo item : items) {
			OrderLineItem lineItem = insertLineItem(item, order.getId());
			allTax += lineItem.getLineTax();
			allTotal += lineItem.getLineTotal();
		}
		order.setTaxSubtotal(allTax);
		order.setOrderTotal(allTotal);

		//TODO calculate tax
		//pay and set status: 1

		//update order status.
		OrderVo res = new OrderVo();
		res.setId(order.getId());
		return res;
	}

	private OrderLineItem insertLineItem(LineItemVo itemVo, Long orderId) {
		OrderLineItem item = new OrderLineItem();
		item.setOrderId(orderId);
		item.setProductId(itemVo.getProduct().getId());
		item.setQuantity(itemVo.getQuantity());
		item.setSubTotal(itemVo.getSubTotal());
		item.setMeasuringUnit(itemVo.getMeasuringUnit());
		item.setUnitsOrdered(itemVo.getUnitsOrdered());
		item.setUnitPrice(itemVo.getUnitPrice());
		item.setLineAmount(itemVo.getLineAmount());
		item.setLineTax(itemVo.getLineTax());
		item.setLineTotal(itemVo.getLineTotal());
		orderLineItemMapper.insert(item);
		return item;
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
