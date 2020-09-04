package com.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("")
	@ApiOperation(value = "Opening Message")
	public String getOpening() {
		return "Assalamu'alaikum";
	}
}
