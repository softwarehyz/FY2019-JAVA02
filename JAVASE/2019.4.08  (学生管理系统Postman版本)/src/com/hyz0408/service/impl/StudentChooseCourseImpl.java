package com.hyz0408.service.impl;

import java.util.List;
import java.util.Map;

import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.StudentChooseCourse;

public class StudentChooseCourseImpl implements StudentChooseCourse {
	CourseServiceImpl C1=CourseServiceImpl.getInstance();
	//查看所有课程
	@Override
	public ServerResponse LookCourse() {
		// TODO Auto-generated method stub
		return C1.ViewCourse();
	}

   //选择课程
	@Override
	public ServerResponse chooseCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		//根据cid查询课程
		ServerResponse<Course> serverResponse=C1.ViewCourseByID(cid);
		if(serverResponse.isSucess()) {
			//获取查询的课程			
					Course c=serverResponse.getData();
					course.add(c);
					return ServerResponse.createServerResponseBySucess("添加成功",c);	
				}
			
		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "添加课程不存在");
	}
	
	 //删除课程
	public ServerResponse DelCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		
		//根据cid查询课程
//		ServerResponse serverResponse=CourseServiceImpl.getInstance().ViewCourseByID(cid);
//		if(serverResponse.isSucess()) {
//			//获取查询的课程
//			Course c=(Course)serverResponse.getData();
//			course.remove(c);
//			return ServerResponse.createServerResponseBySucess("删除成功");	
//		}
//		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "删除的课程不存在");
	if(course!=null) {
		boolean x=false;
		for(int i=0;i<course.size();i++) {
		if(course.get(i).getCid()==cid) {
			x=false;
			course.remove(course.get(i));
			return ServerResponse.createServerResponseBySucess("删除成功");
		      }else {
		    	  x=true;
		      }
	      }
		if(x) {
			return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "您未选择该课程");
		}
		
	   }
	return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "您未选择该课程");
	}
	
	//查看已选课程
	public ServerResponse ChoosedCourse(List<Course> course) {
		// TODO Auto-generated method stub	
		return ServerResponse.createServerResponseBySucess("已选课程查询成功", course);
	}

}
