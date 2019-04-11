package com.hyz0408.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Student;
import com.hyz0408.pojo.User;
import com.hyz0408.service.StudentService;

public class StudentServiceImpl implements StudentService {

    
	//UserViewImpl u1=new UserViewImpl();
	private static StudentServiceImpl F1;
	private Map<Integer,Student> student=new TreeMap<Integer,Student>();         //定义一个数组用来存储学生信息
	 
	private StudentServiceImpl() {
		Student s=new Student(2014,"韩艳祖","男",88,25,"高级","山西朔州","18434260817","14169@qq.cn",1554132344000L,"123456");
		Student s1=new Student(2015,"蔚卫","男",99,25,"中级","山西朔州","18434260834","84589@qq.cn",1557132334000L,"123456");
		Student s2=new Student(2016,"姜一飞","男",66,25,"低级","山西朔州","18434260821","84529@qq.cn",1558132394000L,"123456");
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
	
	//查看所有学生信息（无序）
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServerResponse ViewInfo(){	
		return ServerResponse.createServerResponseBySucess("获取学生信息成功",student.values());
	}
	
	/*
	 * //成绩升序查看
	 * 
	 * @SuppressWarnings("rawtypes") public ServerResponse ScoreRise(){
	 * 
	 * 
	 * return ServerResponse.createServerResponseBySucess("按成绩升序排序成功",list); }
	 * 
	 * //成绩降序查看
	 * 
	 * @SuppressWarnings("rawtypes") public ServerResponse ScoreDown(){
	 * 
	 * 
	 * return ServerResponse.createServerResponseBySucess("按成绩降序排序成功",list); }
	 */
	
	//按照ID查看学生
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> ViewByID(int ID) {
		if(student.containsKey(ID)) {
		return ServerResponse.createServerResponseBySucess("查询成功", student.get(ID));
		}
		return ServerResponse.createServerResponseByFail(Constant.STUDENTID_NOT_NULL, "查询ID不存在");
	}
	//添加学生
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> addStudent(int stuid,String name,String sex,int score,int age,String grade,String addr,String phone,String email,String stuPassword) {
		if(student.containsKey(stuid)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_IS_EXISTS, "该ID已经存在");
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
		s3.setStuPassword(stuPassword);
		student.put(stuid,s3);
		return ServerResponse.createServerResponseBySucess("添加成功！");
	}
	
	//删除学生
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> delStudent(int delID) {
		if(student.containsKey(delID)) {
			student.remove(delID);
			return ServerResponse.createServerResponseBySucess("删除成功！");
		}
		return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID不存在");
		
	}
	
	//改变学生信息
	@SuppressWarnings("unchecked")
	public ServerResponse<Student> alterStudent(int stuid,String name,String sex,int score,int age,String grade,String addr,String phone,String email) {
		if(!student.containsKey(stuid)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID不存在");
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
		return ServerResponse.createServerResponseBySucess("修改成功！");
	}
	
	//学生登陆
	public ServerResponse<Student> Stulogin(int stuID,String stuPassword){
		
		if(student.containsKey(stuID)) {
			if(stuPassword==null||stuPassword.equals("")) {
				return ServerResponse.createServerResponseByFail(Constant.PASSWORD_NOT_NULL, "密码不能为空");
			}
			Student stu1=student.get(stuID);
			if(stuPassword.equals(stu1.getStuPassword())) {//登录成功
				
				return ServerResponse.createServerResponseBySucess("登陆成功",stu1);
				
			}else {//stuID 和password 不匹配
				return ServerResponse.createServerResponseByFail(Constant.PASSWORD_ERROR, "密码不匹配");	
			}
		}
		return ServerResponse.createServerResponseByFail(Constant.USER_NOT_EXISTS, "用户不存在");
		}
	
	
	
	
	}