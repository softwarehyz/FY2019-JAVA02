package com.hyz0328.view;

import com.hyz0328.pojo.Student;
import com.hyz0328.pojo.User;

public interface UserView {
	void welcome();
	void operation1();
	void login(User[] user);
	void operation2(Student[] student,Student[] student1); 
}
