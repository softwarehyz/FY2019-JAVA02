package com.hyz0408.service.impl;

import java.util.List;
import java.util.Map;

import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.StudentChooseCourse;

public class StudentChooseCourseImpl implements StudentChooseCourse {
	
	//查看所有课程
	@Override
	public ServerResponse LookCourse(Map<Integer,Course> course) {
		// TODO Auto-generated method stub
		return ServerResponse.createServerResponseBySucess("查看成功", course);
	}
	
	
	
   //选择课程
	@Override
	public ServerResponse chooseCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		//根据cid查询课程
		ServerResponse<Course> serverResponse=CourseServiceImpl.getInstance().ViewCourseByID(cid);
		if(serverResponse.isSucess()) {
			//获取查询的课程
			for(int i=0;i<course.size();i++) {
				if(course.get(i).getCid()!=cid) {
					Course c=serverResponse.getData();
					course.add(c);
					return ServerResponse.createServerResponseBySucess("添加成功",c);	
				}else {
					return ServerResponse.createServerResponseByFail(Constant.COURSE_IS_EXISTS, "课程已经添加，无需重复添加");
				}
			}
			
		}
		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "添加课程不存在");
	}
	
	 //删除课程
	public ServerResponse DelCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		
		//根据cid查询课程
		ServerResponse serverResponse=CourseServiceImpl.getInstance().ViewCourseByID(cid);
		if(serverResponse.isSucess()) {
			//获取查询的课程
			Course c=(Course)serverResponse.getData();
			course.remove(c);
			return ServerResponse.createServerResponseBySucess("删除成功");	
		}
		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "删除的课程不存在");
	}
	

}
