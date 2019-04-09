package com.hyz0408.service;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.User;

public interface UserService {

	public ServerResponse<User> login(String username,String password);
	//public boolean exit();
}
