package com.tech.doks.it.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.doks.it.model.AuthStatus;
import com.tech.doks.it.svc.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthService authService;
	
	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@RequestMapping(value = "{name}/{password}", method = RequestMethod.GET)
	public @ResponseBody
	AuthStatus getAuthStatusInJSON(@PathVariable String name,
			@PathVariable String password) {
		
		System.out.println("Inside getAuthStatusInJSON ::");
		/*System.out.println("name : " + name + " password : " + password);
		System.out.println("authService.authenticate(name, password) : " + authService.authenticate(name, password));*/
		return authService.authenticate(name, password);

	}

	@PostConstruct
	public void init() {
		System.out.println("AuthController initialized ::");
	}

}