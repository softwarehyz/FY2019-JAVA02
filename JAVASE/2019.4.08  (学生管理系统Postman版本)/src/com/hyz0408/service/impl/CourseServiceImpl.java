package com.hyz0408.service.impl;

import java.util.Map;
import java.util.TreeMap;

import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private static CourseServiceImpl C1;
	private Map<Integer,Course> course=new TreeMap<Integer,Course>();         //定义一个数组用来存储学生信息
	 
	private CourseServiceImpl() {
		Course s=new Course(1,"java");
		Course s1=new Course(2,"C++");
		Course s2=new Course(3,"Html");
		course.put(s.getCid(),s);
		course.put(s1.getCid(),s1);
		course.put(s2.getCid(),s2);
	}
	
	public synchronized static CourseServiceImpl getInstance() {
		if(C1==null) {
			C1=new CourseServiceImpl();
		}
			return C1;
	}	
	
	@Override
	public ServerResponse ViewCourse() {
		// TODO Auto-generated method stub
		return ServerResponse.createServerResponseBySucess("获取书籍信息成功",course.values());
	}

	@Override
	public ServerResponse AddCourse(int ID,String Cname) {
		// TODO Auto-generated method stub
		if(course.containsKey(ID)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_IS_EXISTS, "该ID已经存在");
		}
		Course s3=new Course();
		s3.setCid(ID);
		s3.setCname(Cname);;
		course.put(ID,s3);
		return ServerResponse.createServerResponseBySucess("添加成功！");
	}

	@Override
	public ServerResponse AlterCourse(int ID,String Cname) {
		// TODO Auto-generated method stub
		if(!course.containsKey(ID)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID不存在");
		}
		Course s3=course.get(ID);
		s3.setCname(Cname);
		return ServerResponse.createServerResponseBySucess("修改成功！");
	}

	@Override
	public ServerResponse DelCourse(int ID) {
		// TODO Auto-generated method stub
		if(course.containsKey(ID)) {
			course.remove(ID);
			return ServerResponse.createServerResponseBySucess("删除成功！");
		}
		return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID不存在");
	}

	@Override
	public ServerResponse ViewCourseByID(int ID) {
		// TODO Auto-generated method stub
		if(course.containsKey(ID)) {
			return ServerResponse.createServerResponseBySucess("查询成功", course.get(ID));
			}
			return ServerResponse.createServerResponseByFail(Constant.STUDENTID_NOT_NULL, "查询ID不存在");
		}
	}

