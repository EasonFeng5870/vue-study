package com.seafood.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * product controller
 * @author eason
 * @date 2022/08/25
 **/
@RestController
public class ProductController extends BaseController {

	@GetMapping("/product/{pId}")
	public String getProductDetails(@PathVariable(name = "pId") int productId) {
		return "";
	}


}
