package com.oauth.service.implement;

import org.springframework.beans.factory.annotation.Autowired;

import com.oauth.repository.JwtTokenRepository;
import com.oauth.repository.RoleRepository;
import com.oauth.repository.UserRepository;

public class BaseServiceImplement {

	@Autowired
	protected RoleRepository roleRepository;
	
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired
	protected JwtTokenRepository jwtTokenRepository;
}
