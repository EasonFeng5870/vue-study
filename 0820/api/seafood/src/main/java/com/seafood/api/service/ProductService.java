package com.seafood.api.service;

import java.util.ArrayList;
import java.util.List;

import com.seafood.api.entity.Products;
import com.seafood.api.mapper.ProductsMapper;
import com.seafood.api.vo.ProductVo;

import org.springframework.stereotype.Service;

/**
 * product service
 * @author eason
 * @date 2022/08/28
 **/
@Service
public class ProductService {

	private ProductsMapper productsMapper;

	/**
	 * get product details by product id
	 * @param productId product id
	 * @return product information
	 */
	public ProductVo getProductDetails(long productId) {
		Products products = productsMapper.selectById(productId);
		ProductVo productVo = new ProductVo();
		productVo.setId(products.getId());
		productVo.setName(products.getName());
		productVo.setPrice(8.99);
		productVo.setUnit("lb");
		productVo.setInventory(2000);
		return productVo;
	}

	/**
	 * list all products by catalog id
	 * @param catalogId catalog id
	 * @return all products
	 */
	public List<ProductVo> getAllProductsByCatalogId(long catalogId) {
		ProductVo productVo = new ProductVo();
		productVo.setId(10101);
		productVo.setName("Shark");
		productVo.setPrice(8.99);
		productVo.setUnit("lb");
		productVo.setInventory(2000);
		List<ProductVo> productVos = new ArrayList<>();
		productVos.add(productVo);
		return productVos;
	}
}
