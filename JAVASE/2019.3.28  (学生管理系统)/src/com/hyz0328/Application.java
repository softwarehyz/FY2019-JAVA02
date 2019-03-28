package com.hyz0328;

import com.hyz0328.pojo.Student;
import com.hyz0328.pojo.User;
import com.hyz0328.view.impl.UserViewImpl;

public class Application {
	static Student[] student=new Student[5];         //定义一个数组用来存储学生信息
	 static Student[] student1=new Student[5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserViewImpl us1=new UserViewImpl();
		us1.welcome();                                //欢迎界面
	    User s=new User();
	    InitData1(student);
	    us1.operation1();                        //选择登陆还是退出
		us1.operation2(student,student1);                             //选择如何操作学生信息
	}

	public static void InitData1(Student[] student){                          //存储学生数组的初始化
		Student s=new Student(2014,"韩艳祖","男",25,"高级","山西朔州","18434260817","1416949284@qq.con");
		student[0]=s;
	}  
}
