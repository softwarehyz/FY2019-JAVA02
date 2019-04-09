package com.hyz0408.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.StudentService;

public class StudentServiceImpl implements StudentService {

    
	//UserViewImpl u1=new UserViewImpl();
	private static StudentServiceImpl F1;
	private Map<Integer,Student> student=new HashMap<Integer,Student>();         //����һ�����������洢ѧ����Ϣ
	 
	private StudentServiceImpl() {
		Student s=new Student(2014,"������","��",88,25,"�߼�","ɽ��˷��","18434260817","14169@qq.cn",1554132344000L);
		Student s1=new Student(2015,"ε��","��",99,25,"�м�","ɽ��˷��","18434260834","84589@qq.cn",1557132334000L);
		Student s2=new Student(2016,"��һ��","��",66,25,"�ͼ�","ɽ��˷��","18434260821","84529@qq.cn",1558132394000L);
		student.put(s.getStuid(),s);
		student.put(s1.getStuid(),s1);
		student.put(s2.getStuid(),s2);
	}
	
	public synchronized static StudentServiceImpl getInstance() {
		if(F1==null) {
			 F1=new StudentServiceImpl();
		}
			return F1;
	}	
	
	//�鿴����ѧ����Ϣ
	public ServerResponse ViewInfo(){	
		return ServerResponse.createServerResponseBySucess("��ȡѧ����Ϣ�ɹ�",student.values());
	}
	//����ID�鿴ѧ��
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> ViewByID(int ID) {
		if(student.containsKey(ID)) {
		return ServerResponse.createServerResponseBySucess("��ѯ�ɹ�", student.get(ID));
		}
		return ServerResponse.createServerResponseByFail(Constant.STUDENTID_NOT_NULL, "��ѯID������");
	}
	//���ѧ��
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> addStudent(int stuid,String name,String sex,int score,int age,String grade,String addr,String phone,String email) {
		if(student.containsKey(stuid)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_IS_EXISTS, "��ID�Ѿ�����");
		}
		Student s3=new Student();
		s3.setStuid(stuid);
		s3.setName(name);
		s3.setSex(sex);
		s3.setScore(score);
		s3.setAge(age);
		s3.setGrade(grade);
		s3.setAddr(addr);
		s3.setPhone(phone);
		s3.setEmail(email);
		student.put(stuid,s3);
		return ServerResponse.createServerResponseBySucess("��ӳɹ���");
	}
	
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> delStudent(int delID) {
		if(student.containsKey(delID)) {
			student.remove(delID);
			return ServerResponse.createServerResponseBySucess("ɾ���ɹ���");
		}
		return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID������");
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> alterStudent(int stuid,String name,String sex,int score,int age,String grade,String addr,String phone,String email) {
		if(!student.containsKey(stuid)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID������");
		}
		Student s3=student.get(stuid);
		s3.setName(name);
		s3.setSex(sex);
		s3.setScore(score);
		s3.setAge(age);
		s3.setGrade(grade);
		s3.setAddr(addr);
		s3.setPhone(phone);
		s3.setEmail(email);
		return ServerResponse.createServerResponseBySucess("�޸ĳɹ���");
	}
	
	
	
}	