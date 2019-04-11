package com.hyz0408.service.impl;

import java.util.List;
import java.util.Map;

import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.StudentChooseCourse;

public class StudentChooseCourseImpl implements StudentChooseCourse {
	
	//�鿴���пγ�
	@Override
	public ServerResponse LookCourse(Map<Integer,Course> course) {
		// TODO Auto-generated method stub
		return ServerResponse.createServerResponseBySucess("�鿴�ɹ�", course);
	}
	
	
	
   //ѡ��γ�
	@Override
	public ServerResponse chooseCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		//����cid��ѯ�γ�
		ServerResponse<Course> serverResponse=CourseServiceImpl.getInstance().ViewCourseByID(cid);
		if(serverResponse.isSucess()) {
			//��ȡ��ѯ�Ŀγ�
			for(int i=0;i<course.size();i++) {
				if(course.get(i).getCid()!=cid) {
					Course c=serverResponse.getData();
					course.add(c);
					return ServerResponse.createServerResponseBySucess("��ӳɹ�",c);	
				}else {
					return ServerResponse.createServerResponseByFail(Constant.COURSE_IS_EXISTS, "�γ��Ѿ���ӣ������ظ����");
				}
			}
			
		}
		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "��ӿγ̲�����");
	}
	
	 //ɾ���γ�
	public ServerResponse DelCourse(int cid,List<Course> course) {
		// TODO Auto-generated method stub
		
		//����cid��ѯ�γ�
		ServerResponse serverResponse=CourseServiceImpl.getInstance().ViewCourseByID(cid);
		if(serverResponse.isSucess()) {
			//��ȡ��ѯ�Ŀγ�
			Course c=(Course)serverResponse.getData();
			course.remove(c);
			return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");	
		}
		return ServerResponse.createServerResponseByFail(Constant.COURSE_NOT_EXISTS, "ɾ���Ŀγ̲�����");
	}
	

}
