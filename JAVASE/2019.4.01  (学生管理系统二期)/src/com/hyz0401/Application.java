package com.hyz0401;

import java.util.ArrayList;
import java.util.List;
import com.hyz0401.pojo.Student;
import com.hyz0401.pojo.User;
import com.hyz0401.view.impl.UserViewImpl;

public class Application {
	//static List<Student> student=new ArrayList<Student>();         //����һ�����������洢ѧ����Ϣ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserViewImpl us1=new UserViewImpl();
		us1.welcome();                                //��ӭ����
	    User s=new User();
	    //InitData1(student);
	    us1.operation1();                        //ѡ���½�����˳�
		us1.operation2(/*student*/);                             //ѡ����β���ѧ����Ϣ
	}

	/**public static void InitData1(List<Student> student){                          //�洢ѧ������ĳ�ʼ��
		Student s=new Student(2014,"������","��",88,25,"�߼�","ɽ��˷��","18434260817","14169@qq.cn",1554132344000L);
		student.add(s);
	}  
	*/
}
