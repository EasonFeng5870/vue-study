package com.seafood.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.seafood.api.entity.Catalog;
import com.seafood.api.entity.Category;
import com.seafood.api.mapper.CatalogMapper;
import com.seafood.api.mapper.CategoryMapper;
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
	private CategoryMapper categoryMapper;

	@Autowired
	private ProductService productService;

	/**
	 * Get catalog info by catalogId
	 * @param catalogId catalog id, default is 1
	 * @return ResponseData<Catalog>
	 */
	public ResponseData<CatalogVo> getList(long catalogId) {
		Catalog catalog = catalogMapper.selectById(catalogId);
		CatalogVo catalogVo = new CatalogVo();
		catalogVo.setId(catalog.getId());
		catalogVo.setName(catalog.getName());
		catalogVo.setDesc(catalog.getShortDesc());

		List<ProductCategory> categories = getCategoriesByCatalogId(catalogId);
		catalogVo.setProductCategories(categories);

		updateProductsToSubcategories(categories, catalogId);
		return new ResponseData<>(catalogVo, OK, MESSAGE);
	}

	private List<ProductCategory> getCategoriesByCatalogId(long catalogId) {
		List<ProductCategory> productCategories = new ArrayList<>();
		List<Category> categories =
				categoryMapper.selectAllProductCategoriesByCatalogId(catalogId);
		Map<Long, List<Category>> subCategoryMap = new HashMap<>();
		for (Category cate : categories) {
			if (cate.getParentId() != 0) {
				if (!subCategoryMap.containsKey(cate.getParentId())) {
					subCategoryMap.put(cate.getParentId(), new ArrayList<>());
				}
				subCategoryMap.get(cate.getParentId()).add(cate);
			} else {
				ProductCategory productCategory = new ProductCategory();
				productCategory.setId(cate.getId());
				productCategory.setName(cate.getName());
				productCategory.setDescription(cate.getShortDesc());
				productCategory.setParentId(0);
				productCategories.add(productCategory);
			}
		}
		for (ProductCategory productCate : productCategories) {
			List<SubCategory> subCategories = new ArrayList<>();
			if (!subCategoryMap.containsKey(productCate.getId())) {
				continue;
			}
			for (Category cate : subCategoryMap.get(productCate.getId())) {
				SubCategory subCategory = new SubCategory();
				subCategory.setId(cate.getId());
				subCategory.setName(cate.getName());
				subCategory.setDescription(cate.getShortDesc());
				subCategories.add(subCategory);
			}
			productCate.setSubcategories(subCategories);
		}
		List<ProductCategory> res = productCategories.stream().filter(
				productCategory -> productCategory.getParentId() == 0 ).collect(Collectors.toList());
		return res;
	}

	private void updateProductsToSubcategories(List<ProductCategory> categories,
			long catalogId) {
		Map<Long, List<ProductVo>> products =
				productService.getAllProductsByCatalogId(catalogId);
		for (ProductCategory pc: categories) {
			List<SubCategory> subCategories = pc.getSubcategories();
			if (subCategories == null || subCategories.size() == 0) {
				continue;
			}
			for (SubCategory sub: subCategories) {
				sub.setProducts(products.get(sub.getId()));
			}
		}

	}

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.add(5);
		integers.add(6);
		integers.add(7);
		integers.add(8);
		integers.add(9);
		integers.add(10);

		List<Integer> res = integers.stream().filter(data -> data > 5).collect(Collectors.toList());

		System.out.println(res);
	}
}
