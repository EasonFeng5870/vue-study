package com.seafood.api.controller;

import com.seafood.api.service.ProductService;
import com.seafood.api.vo.ProductVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * product controller
 * @author eason
 * @date 2022/08/25
 **/
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{pId}")
	public ProductVo getProductDetails(@PathVariable(name = "pId") long productId) {
		return productService.getProductDetails(productId);
	}


}
