package com.seafood.api.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author eason
 * @date 2022/08/27
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
				.antMatchers("/",
						"/js/*",
						"/css/*",
						"/guest",
						"/oauth2/authorization/github",
						"/rest/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.oauth2Login();
	}
}
