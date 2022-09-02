package com.seafood.api.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eason
 * @date 2022/08/27
 **/
@RestController
public class MessageController extends BaseController {

//	@GetMapping("/")
//	public String hello() {
//		return "hello google github";
//	}

	@GetMapping("/guest")
	public String guest() {
		return "hello guest";
	}

	@GetMapping("/rest/login")
	public String login(HttpServletResponse response, @RequestParam("state") String state) throws IOException {
		String token = "abc" + System.currentTimeMillis();
		System.out.println(state);
		return token;
	}

	@GetMapping("/admin")
	public Map<String, Object> admin(HttpServletResponse response,
			@AuthenticationPrincipal OAuth2User principal) throws IOException {
		System.out.println(gson.toJson(principal));
		String user = principal.getName() + "|";
		int userId = principal.getAttribute("id");
		String avatarUrl = principal.getAttribute("avatar_url");
		String userName = principal.getAttribute("login");
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}

}
