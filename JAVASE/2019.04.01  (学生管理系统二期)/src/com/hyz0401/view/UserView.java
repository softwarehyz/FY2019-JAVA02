package com.hyz0401.view;

import java.util.List;

import com.hyz0401.pojo.Student;
import com.hyz0401.pojo.User;

public interface UserView {
	void welcome();
	void operation1();
	void login(User[] user);
	void operation2(List<Student> student); 
}
