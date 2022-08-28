package com.seafood.api.service;

import java.util.ArrayList;
import java.util.List;

import com.seafood.api.entity.Catalog;
import com.seafood.api.mapper.CatalogMapper;
import com.seafood.api.vo.CatalogVo;
import com.seafood.api.vo.ProductCategory;
import com.seafood.api.vo.ProductVo;
import com.seafood.api.vo.ResponseData;
import com.seafood.api.vo.SubCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.seafood.api.utils.Constants.MESSAGE;
import static com.seafood.api.utils.Constants.OK;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
@Service("catalogService")
public class CatalogService {

	@Autowired
	private CatalogMapper catalogMapper;

	@Autowired
	private ProductService productService;

	/**
	 *  get catalog info by catalogId
	 * @param catalogId catalog id, default is 1
	 * @return ResponseData<Catalog>
	 */
	public ResponseData<CatalogVo> getList(long catalogId) {

		List<ProductVo> products = productService.getAllProductsByCatalogId(catalogId);

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

		Catalog catalog = catalogMapper.selectById(catalogId);
		CatalogVo catalogVo = new CatalogVo();
		catalogVo.setId(catalog.getId());
		catalogVo.setName(catalog.getName());
		catalogVo.setDesc(catalog.getShortDesc());


		catalogVo.setProductCategories(productCategories);
		return new ResponseData<CatalogVo>(catalogVo, OK, MESSAGE);
	}
}
