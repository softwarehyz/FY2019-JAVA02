package com.hyz0408.common;

public enum StudentCourseOperation {
	STUDENT_LOOK_COURSE(1,"�鿴�γ�"),
	STUDENT_ADD_COURSE(2,"ѡ��γ�"),
	STUDENT_DEL_COURSE(3,"ɾ���γ�")
;
	private int operation_type;
	private String operation_desc;
	private StudentCourseOperation(int operation_type, String operation_desc) {
		this.operation_type = operation_type;
		this.operation_desc = operation_desc;
	}
	
	public int getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}
	public String getOperation_desc() {
		return operation_desc;
	}
	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
	
}
