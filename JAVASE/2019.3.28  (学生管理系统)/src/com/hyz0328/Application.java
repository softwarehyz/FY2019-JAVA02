package com.hyz0328;

import com.hyz0328.pojo.Student;
import com.hyz0328.pojo.User;
import com.hyz0328.view.impl.UserViewImpl;

public class Application {
	static Student[] student=new Student[5];         //����һ�����������洢ѧ����Ϣ
	 static Student[] student1=new Student[5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserViewImpl us1=new UserViewImpl();
		us1.welcome();                                //��ӭ����
	    User s=new User();
	    InitData1(student);
	    us1.operation1();                        //ѡ���½�����˳�
		us1.operation2(student,student1);                             //ѡ����β���ѧ����Ϣ
	}

	public static void InitData1(Student[] student){                          //�洢ѧ������ĳ�ʼ��
		Student s=new Student(2014,"������","��",25,"�߼�","ɽ��˷��","18434260817","1416949284@qq.con");
		student[0]=s;
	}  
}
