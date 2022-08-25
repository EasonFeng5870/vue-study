package com.seafood.api.service;

import java.util.ArrayList;
import java.util.List;

import com.seafood.api.vo.Catalog;
import com.seafood.api.vo.Product;
import com.seafood.api.vo.ProductCategory;
import com.seafood.api.vo.ResponseData;
import com.seafood.api.vo.SubCategory;

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

		Product product = new Product();
		product.setId(10101);
		product.setName("Shark");
		product.setPrice(8.99);
		product.setUnit("lb");
		product.setInventory(2000);

		List<Product> products = new ArrayList<>();
		products.add(product);

		SubCategory subCategory = new SubCategory();
		subCategory.setId(101);
		subCategory.setName("salt water fish");
		subCategory.setDescription("Fishes from the sea");
		subCategory.setProducts(products);

		List<SubCategory> subCategories = new ArrayList<>();
		subCategories.add(subCategory);

		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(1);
		productCategory.setName("Fish");
		productCategory.setDescription("Fresh fishes");
		productCategory.setSubcategories(subCategories);

		List<ProductCategory> productCategories = new ArrayList<>();
		productCategories.add(productCategory);

		Catalog catalog = new Catalog();
		catalog.setId(1);
		catalog.setName("Seafood");
		catalog.setDesc("Delicious seafood direct to your home");
		catalog.setProductCategories(productCategories);
		return new ResponseData<Catalog>(catalog, 200, "成功");
	}
}
