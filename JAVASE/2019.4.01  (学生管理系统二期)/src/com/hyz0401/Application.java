package com.hyz0401;

import java.util.ArrayList;
import java.util.List;
import com.hyz0401.pojo.Student;
import com.hyz0401.pojo.User;
import com.hyz0401.view.impl.UserViewImpl;

public class Application {
	//static List<Student> student=new ArrayList<Student>();         //定义一个数组用来存储学生信息
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserViewImpl us1=new UserViewImpl();
		us1.welcome();                                //欢迎界面
	    User s=new User();
	    //InitData1(student);
	    us1.operation1();                        //选择登陆还是退出
		us1.operation2(/*student*/);                             //选择如何操作学生信息
	}

	/**public static void InitData1(List<Student> student){                          //存储学生数组的初始化
		Student s=new Student(2014,"韩艳祖","男",88,25,"高级","山西朔州","18434260817","14169@qq.cn",1554132344000L);
		student.add(s);
	}  
	*/
}
