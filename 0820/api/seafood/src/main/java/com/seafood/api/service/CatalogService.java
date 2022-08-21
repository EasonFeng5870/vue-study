package com.seafood.api.service;

import java.util.ArrayList;
import java.util.List;

import com.seafood.api.vo.Catalog;
import com.seafood.api.vo.ProductCatagory;
import com.seafood.api.vo.ResponseData;

import org.springframework.stereotype.Service;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
@Service("catalogService")
public class CatalogService {

	/**
	 *  get catalog info by catalogId
	 * @param catalogId
	 * @return ResponseData<Catalog>
	 */
	public ResponseData<Catalog> getList(int catalogId) {

		ProductCatagory productCatagory = new ProductCatagory();
		productCatagory.setId(1);
		productCatagory.setName("Fish");

		List<ProductCatagory> productCatagories = new ArrayList<>();
		productCatagories.add(productCatagory);

		Catalog catalog = new Catalog();
		catalog.setId(1);
		catalog.setName("Seafood");
		catalog.setDesc("Delicious seafood direct to your home");
		catalog.setProductCatagories(productCatagories);
		return new ResponseData<Catalog>(catalog, 200, "成功");
	}
}
