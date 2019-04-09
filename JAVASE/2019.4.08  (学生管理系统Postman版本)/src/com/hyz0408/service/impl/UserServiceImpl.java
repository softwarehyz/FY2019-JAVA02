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
	Map<String,User> User= new HashMap<String,User>(); //����һ�����������洢ϵͳ�û�  
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
		
		//step1:�жϲ����Ƿ����
				if(username==null||username.equals("")) {
					return ServerResponse.createServerResponseByFail(Constant.USERNAME_NOT_NULL, "�û�������Ϊ��");
				}
				if(!User.containsKey(username)) {
					return ServerResponse.createServerResponseByFail(Constant.USER_NOT_EXISTS, "�û���������");
				}
				if(password==null||password.equals("")) {
					return ServerResponse.createServerResponseByFail(Constant.PASSWORD_NOT_NULL, "���벻��Ϊ��");
				}
		
		
		if(User.containsKey(username)) {
			User user1=User.get(username);
			if(password.equals(user1.getPassword())) {//��¼�ɹ�
				
				return ServerResponse.createServerResponseBySucess();
				
			}else {//username ��password ��ƥ��
				return ServerResponse.createServerResponseByFail(Constant.PASSWORD_ERROR, "���벻ƥ��");	
			}
		}
		return ServerResponse.createServerResponseByFail(Constant.USER_NOT_EXISTS, "�û���������");
	}
	
	
	
	
	
}
