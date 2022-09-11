package com.seafood.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.seafood.api.entity.OrderLineItem;
import com.seafood.api.mapper.OrderLineItemMapper;
import com.seafood.api.mapper.ProductMapper;
import com.seafood.api.vo.LineItemVo;

import org.springframework.stereotype.Service;

/**
 *
 * @author eason
 * @date 2022/09/10
 **/
@Service
public class OrderLineItemService {

	@Resource
	private OrderLineItemMapper itemMapper;

	@Resource
	private ProductMapper productMapper;

	public List<LineItemVo> getOrderLineItemsByOrderId(long orderId) {
		List<LineItemVo> lineItemVos = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();
		map.put("order_id", orderId);
		List<OrderLineItem> items = itemMapper.selectByMap(map);
		for(OrderLineItem item : items) {
			LineItemVo lineItemVo = new LineItemVo();
			lineItemVo.setId(item.getId());
			lineItemVo.setProduct(productMapper.selectById(item.getProductId()));
			lineItemVo.setQuantity(item.getQuantity());
			lineItemVo.setSubtotal(item.getSubTotal());
			lineItemVo.setExpressNumber(item.getExpressNumber());
			lineItemVo.setExpressCompany(item.getExpressCompany());
			lineItemVo.setExpressType(item.getExpressType());
			lineItemVos.add(lineItemVo);
		}
		return lineItemVos;
	}
}
