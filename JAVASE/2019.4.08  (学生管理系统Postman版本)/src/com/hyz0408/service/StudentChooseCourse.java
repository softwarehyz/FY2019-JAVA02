package com.hyz0408.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;

//ѧ��ѡ�νӿ�
public interface StudentChooseCourse {
    // s ѧ������
	//cid �γ�ID
	public ServerResponse chooseCourse(int cid,List<Course> course);
	ServerResponse LookCourse();
}
