package com.seafood.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.seafood.api.entity.Product;
import com.seafood.api.mapper.ProductMapper;
import com.seafood.api.vo.ProductVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * product service
 * @author eason
 * @date 2022/08/28
 **/
@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	/**
	 * get product details by product id
	 * @param productId product id
	 * @return product information
	 */
	public ProductVo getProductDetails(long productId) {
		Product product = productMapper.selectById(productId);
		return convertProductToVo(product);
	}

	private ProductVo convertProductToVo(Product product) {
		ProductVo productVo = new ProductVo();
		productVo.setId(product.getId());
		productVo.setName(product.getName());
		productVo.setPrice(product.getPrice());
		productVo.setUnit(product.getMeasuringUnit());
		productVo.setInventory(product.getInventory());
		productVo.setCategoryId(product.getCategoryId());
		productVo.setShortDesc(product.getShortDesc());
		productVo.setFullDesc(product.getFullDesc());
		productVo.setIconUrl(product.getIconUrl());
		productVo.setImgUrl(product.getImgUrl());
		productVo.setMaxOrderUnits(product.getMaxOrderUnits());
		productVo.setMixOrderUnits(product.getMixOrderUnits());
		productVo.setOrderStepUnits(product.getOrderStepUnits());
		productVo.setCreateTime(product.getCreateTime());
		productVo.setUpdateTime(product.getUpdateTime());
		productVo.setCatalogId(product.getCatalogId());
		productVo.setMeasuringUnit(product.getMeasuringUnit());
		return productVo;
	}

	/**
	 * list all products
	 * @return all products
	 */
	public Map<Long, List<ProductVo>> getAllProductsByCatalogId(long catalogId) {
		Map<String, Object> params = new HashMap<>();
		params.put("catalog_id", catalogId);
		List<Product> products = productMapper.selectByMap(params);
		Map<Long, List<ProductVo>> map = new HashMap<>();
		for (Product prod : products) {
			ProductVo productVo = convertProductToVo(prod);
			if (!map.containsKey(prod.getCategoryId())) {
				map.put(prod.getCategoryId(), new ArrayList<>());
			}
			List<ProductVo> vos = map.get(prod.getCategoryId());
			vos.add(productVo);
		}
		return map;
	}
}
