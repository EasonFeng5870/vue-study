package com.seafood.api.controller;

import javax.annotation.Resource;

import com.seafood.api.entity.User;
import com.seafood.api.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eason
 * @date 2022/09/10
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private UserService userService;

	/**
	 * 通过第三方类型和第三方名称查询用户信息
	 *
	 * @param idType type
	 * @param idAuthority id
	 * @return system user id
	 */
	@GetMapping(value = "/{idType}/{idAuthority}")
	public User getUserByIdAuthorityWithType(@PathVariable int idType,
			@PathVariable String idAuthority) {
		return userService.getUserByIdAuthorityWithType(idAuthority, idType);
	}

	@PostMapping(value = "/")
	public User saveUser(User user) {
		return user;
	}
}
