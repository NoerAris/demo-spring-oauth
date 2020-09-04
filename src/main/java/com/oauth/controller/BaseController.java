package com.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.oauth.service.UserService;

public class BaseController {

	@Autowired
	protected UserService userService;
}
