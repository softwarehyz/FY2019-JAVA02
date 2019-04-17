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
	//�鿴���пγ�
	@Override
	public ServerResponse LookCourse() {
		// TODO Auto-generated method stub
		return C1.ViewCourse();
	}

   //ѡ��γ�
	@Override
	public ServerResponse chooseCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		//����cid��ѯ�γ�
		ServerResponse<Course> serverResponse=C1.ViewCourseByID(cid);
		if(serverResponse.isSucess()) {
			//��ȡ��ѯ�Ŀγ�			
					Course c=serverResponse.getData();
					course.add(c);
					return ServerResponse.createServerResponseBySucess("��ӳɹ�",c);	
				}
			
		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "��ӿγ̲�����");
	}
	
	 //ɾ���γ�
	public ServerResponse DelCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		
		//����cid��ѯ�γ�
//		ServerResponse serverResponse=CourseServiceImpl.getInstance().ViewCourseByID(cid);
//		if(serverResponse.isSucess()) {
//			//��ȡ��ѯ�Ŀγ�
//			Course c=(Course)serverResponse.getData();
//			course.remove(c);
//			return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");	
//		}
//		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "ɾ���Ŀγ̲�����");
	if(course!=null) {
		boolean x=false;
		for(int i=0;i<course.size();i++) {
		if(course.get(i).getCid()==cid) {
			x=false;
			course.remove(course.get(i));
			return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");
		      }else {
		    	  x=true;
		      }
	      }
		if(x) {
			return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "��δѡ��ÿγ�");
		}
		
	   }
	return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "��δѡ��ÿγ�");
	}
	
	//�鿴��ѡ�γ�
	public ServerResponse ChoosedCourse(List<Course> course) {
		// TODO Auto-generated method stub	
		return ServerResponse.createServerResponseBySucess("��ѡ�γ̲�ѯ�ɹ�", course);
	}

}
