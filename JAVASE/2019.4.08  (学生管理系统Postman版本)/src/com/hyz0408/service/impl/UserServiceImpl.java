package com.hyz0408.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Student;
import com.hyz0408.pojo.User;
import com.hyz0408.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserServiceImpl instance;
	Map<String,User> User= new HashMap<String,User>(); //定义一个数组用来存储系统用户  
	private UserServiceImpl() {
		User s=new User("admin","admin");
		User.put(s.getName(), s);
	}
	public static synchronized UserServiceImpl getInstance() {
		if(instance==null) {
			instance=new UserServiceImpl();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public ServerResponse<User> login(String username,String password) {
		
		//step1:判断参数是否存在
				if(username==null||username.equals("")) {
					return ServerResponse.createServerResponseByFail(Constant.USERNAME_NOT_NULL, "用户名不能为空");
				}
				if(!User.containsKey(username)) {
					return ServerResponse.createServerResponseByFail(Constant.USER_NOT_EXISTS, "用户名不存在");
				}
				if(password==null||password.equals("")) {
					return ServerResponse.createServerResponseByFail(Constant.PASSWORD_NOT_NULL, "密码不能为空");
				}
		
		
		if(User.containsKey(username)) {
			User user1=User.get(username);
			if(password.equals(user1.getPassword())) {//登录成功
				
				return ServerResponse.createServerResponseBySucess();
				
			}else {//username 和password 不匹配
				return ServerResponse.createServerResponseByFail(Constant.PASSWORD_ERROR, "密码不匹配");	
			}
		}
		return ServerResponse.createServerResponseByFail(Constant.USER_NOT_EXISTS, "用户名不存在");
	}
	
	
	
	
	
}
