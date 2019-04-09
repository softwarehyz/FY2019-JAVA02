package com.hyz0408.service;

import java.util.List;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Student;

public interface StudentService {
	ServerResponse<Student> ViewInfo();
	ServerResponse ViewByID(int ID);
}
