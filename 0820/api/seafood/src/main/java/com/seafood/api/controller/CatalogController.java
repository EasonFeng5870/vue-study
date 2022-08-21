package com.seafood.api.controller;

import java.util.List;

import com.seafood.api.vo.Catalog;
import com.seafood.api.service.CatalogService;
import com.seafood.api.vo.ResponseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eason
 * @date 2022/08/21
 **/
@RestController
@RequestMapping("/catalog")
public class CatalogController extends BaseController {

	@Autowired
	private CatalogService catalogService;

	@GetMapping(value = "/list")
	public String catalogList(
			@RequestParam(value = "catalogId", defaultValue = "0") int catalogId) {
		return gson.toJson(catalogService.getList(catalogId));
	}

	@GetMapping(value = "/listDemo")
	public String catalogListDemo(
			@RequestParam(value = "catalogId", defaultValue = "0") int catalogId) {
		return "{\n"
				+ "  \"name\" : \"Seafood\",\n"
				+ "  \"desc\" : \"Delicious seafood direct to your home\",\n"
				+ "  \"productcategories\": [\n"
				+ "    {\n"
				+ "      \"id\": 1,\n"
				+ "      \"name\": \"Fish\",\n"
				+ "      \"description\": \"Fresh fishes\",\n"
				+ "      \"subcategories\": [\n"
				+ "        {\n"
				+ "          \"id\": 101,\n"
				+ "          \"name\": \"Salt water fish\",\n"
				+ "          \"description\": \"Fishes from the sea\",\n"
				+ "          \"products\": [\n"
				+ "            {\"id\": 10101, \"name\": \"Shark\", \"price\": \"8.99\", \"unit\":  \"lb\", \"inventory\": 2000},\n"
				+ "            {\"id\": 10102, \"name\": \"Belt fish\", \"price\": \"6.99\", \"unit\":  \"lb\", \"inventory\": 1000},\n"
				+ "            {\"id\": 10103, \"name\": \"Catfish\", \"price\": \"3.99\", \"unit\":  \"lb\", \"inventory\": 1200}\n"
				+ "          ]\n"
				+ "        },\n"
				+ "        {\n"
				+ "          \"id\": 102,\n"
				+ "          \"name\": \"White water fish\",\n"
				+ "          \"description\": \"Fishes from the rivers\",\n"
				+ "          \"products\": [\n"
				+ "            {\"id\": 10201, \"name\": \"Carp\", \"price\": \"4.99\", \"unit\":  \"lb\", \"inventory\": 2000},\n"
				+ "            {\"id\": 10202, \"name\": \"Goldfish\", \"price\": \"36.99\", \"unit\":  \"lb\", \"inventory\": 1000},\n"
				+ "            {\"id\": 10203, \"name\": \"Salmon\", \"price\": \"13.99\", \"unit\":  \"lb\", \"inventory\": 1200}\n"
				+ "          ]\n"
				+ "        }\n"
				+ "      ]\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"id\": 2,\n"
				+ "      \"name\": \"Crab\",\n"
				+ "      \"description\": \"Fresh crabs\",\n"
				+ "      \"subcategories\": [\n"
				+ "        {\n"
				+ "          \"id\": 201,\n"
				+ "          \"name\": \"Salt water crab\",\n"
				+ "          \"description\": \"Crabs from the sea\",\n"
				+ "          \"products\": [\n"
				+ "            {\"id\": 20101, \"name\": \"Vancouver\", \"price\": \"8.99\", \"unit\":  \"lb\", \"inventory\": 2000},\n"
				+ "            {\"id\": 20102, \"name\": \"Red rock\", \"price\": \"6.99\", \"unit\":  \"lb\", \"inventory\": 1000},\n"
				+ "            {\"id\": 20103, \"name\": \"Black Stone\", \"price\": \"3.99\", \"unit\":  \"lb\", \"inventory\": 1200}\n"
				+ "          ]\n"
				+ "        },\n"
				+ "        {\n"
				+ "          \"id\": 202,\n"
				+ "          \"name\": \"White water crab\",\n"
				+ "          \"description\": \"Crabs from the rivers\",\n"
				+ "          \"products\": [\n"
				+ "            {\"id\": 20201, \"name\": \"Da Zha Xie\", \"price\": \"8.99\", \"unit\":  \"lb\", \"inventory\": 2000},\n"
				+ "            {\"id\": 20202, \"name\": \"Qing Xie\", \"price\": \"6.99\", \"unit\":  \"lb\", \"inventory\": 1000},\n"
				+ "          ]\n"
				+ "        }\n"
				+ "      ]\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
	}

	@PostMapping("/postlist")
	public String catalogPostList(@RequestBody(required = false) String reqStr) {
		return reqStr;
	}
}
