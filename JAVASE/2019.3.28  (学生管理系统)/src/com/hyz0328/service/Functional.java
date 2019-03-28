package com.hyz0328.service;

import com.hyz0328.pojo.Student;

public interface Functional {
	void CheckInfo(Student[] student);
	void AddInfo(Student[] student) ;
	void DelInfo(Student[] student,Student[] student1);
	void AlterInfo(Student[] student);
}
