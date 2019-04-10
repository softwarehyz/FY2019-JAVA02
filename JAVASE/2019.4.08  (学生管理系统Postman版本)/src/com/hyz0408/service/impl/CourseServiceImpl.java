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
	private Map<Integer,Course> course=new TreeMap<Integer,Course>();         //����һ�����������洢ѧ����Ϣ
	 
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
		return ServerResponse.createServerResponseBySucess("��ȡ�鼮��Ϣ�ɹ�",course.values());
	}

	@Override
	public ServerResponse AddCourse(int ID,String Cname) {
		// TODO Auto-generated method stub
		if(course.containsKey(ID)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_IS_EXISTS, "��ID�Ѿ�����");
		}
		Course s3=new Course();
		s3.setCid(ID);
		s3.setCname(Cname);;
		course.put(ID,s3);
		return ServerResponse.createServerResponseBySucess("��ӳɹ���");
	}

	@Override
	public ServerResponse AlterCourse(int ID,String Cname) {
		// TODO Auto-generated method stub
		if(!course.containsKey(ID)) {
			return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID������");
		}
		Course s3=course.get(ID);
		s3.setCname(Cname);
		return ServerResponse.createServerResponseBySucess("�޸ĳɹ���");
	}

	@Override
	public ServerResponse DelCourse(int ID) {
		// TODO Auto-generated method stub
		if(course.containsKey(ID)) {
			course.remove(ID);
			return ServerResponse.createServerResponseBySucess("ɾ���ɹ���");
		}
		return ServerResponse.createServerResponseByFail(Constant.ID_NOT_EXISTS, "ID������");
	}

	@Override
	public ServerResponse ViewCourseByID(int ID) {
		// TODO Auto-generated method stub
		if(course.containsKey(ID)) {
			return ServerResponse.createServerResponseBySucess("��ѯ�ɹ�", course.get(ID));
			}
			return ServerResponse.createServerResponseByFail(Constant.STUDENTID_NOT_NULL, "��ѯID������");
		}
	}

