package com.seafood.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.seafood.api.entity.Address;
import com.seafood.api.service.AddressService;
import com.seafood.api.service.UserService;
import com.seafood.api.vo.OrderVo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eason
 * @date 2022/09/18
 **/
@RestController
@RequestMapping("/addr")
public class AddressController extends BaseController {

	@Resource
	private AddressService addressService;

	@Resource
	private UserService userService;

	@GetMapping("/{userId}")
	public List<Address> getAddressesByUserId(
			@PathVariable(value = "userId", required = false) long userId) {
		//TODO
		userId = 1L;
		if (!userService.checkUserState(userId)) {
			return new ArrayList<>();
		}
		return addressService.getAddressesByUserId(userId);
	}
}
