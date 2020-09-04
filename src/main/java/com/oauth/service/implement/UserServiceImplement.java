package com.oauth.service.implement;

import javax.transaction.Transactional;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth.entity.User;
import com.oauth.service.UserService;

@Service
@Transactional
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserServiceImplement extends BaseServiceImplement implements UserService, UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findOneByUsername(username);
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

}
