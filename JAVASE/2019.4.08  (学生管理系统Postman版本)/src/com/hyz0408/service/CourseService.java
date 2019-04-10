package com.hyz0408.service;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Student;

public interface CourseService {
	ServerResponse ViewCourse();
	ServerResponse ViewCourseByID(int ID);
	ServerResponse AddCourse(int ID,String Cname);
	ServerResponse AlterCourse(int ID,String Cname);
	ServerResponse DelCourse(int ID);
}
