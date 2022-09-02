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
		Product products = productMapper.selectById(productId);
		ProductVo productVo = new ProductVo();
		productVo.setId(products.getId());
		productVo.setName(products.getName());
		productVo.setPrice(8.99);
		productVo.setUnit(1L);
		productVo.setInventory(2000);
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
			ProductVo productVo = new ProductVo();
			productVo.setId(prod.getId());
			productVo.setName(prod.getName());
//			productVo.setPrice(prod.get);
			productVo.setUnit(prod.getMixOrderUnits());
//			productVo.setInventory(prod.get);

			if (!map.containsKey(prod.getCategoryId())) {
				map.put(prod.getCategoryId(), new ArrayList<>());
			}
			List<ProductVo> vos = map.get(prod.getCategoryId());
			vos.add(productVo);
		}
		return map;
	}
}
