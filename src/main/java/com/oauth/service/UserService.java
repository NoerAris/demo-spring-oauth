package com.oauth.service;

import com.oauth.entity.User;

public interface UserService {

	public User getByUsername(String username);
}
