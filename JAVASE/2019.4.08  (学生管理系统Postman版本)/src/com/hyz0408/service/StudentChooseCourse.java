package com.hyz0408.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;

//学生选课接口
public interface StudentChooseCourse {
    // s 学生对象
	//cid 课程ID
	public ServerResponse chooseCourse(int cid,List<Course> course);
	ServerResponse LookCourse();
}
