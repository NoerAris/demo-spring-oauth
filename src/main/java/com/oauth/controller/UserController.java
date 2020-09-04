package com.oauth.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.entity.User;
import com.oauth.model.RoleName;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/api/user")
@RestController
public class UserController extends BaseController {

	@GetMapping("/findByUser")
	@Secured({RoleName.ROLE_ADMIN, RoleName.ROLE_USER})
	@ApiOperation("Find data user by username")
	public User findByUsername(@RequestParam(value = "username", required = true) String username) {
		User userData = userService.getByUsername(username);
		userData.setPassword(null);
		return userData;
	}
}
