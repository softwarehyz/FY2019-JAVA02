package com.hyz0401.pojo;

public enum Grade {
	MAX_GRADE("�߼�"),
	MID_GRADE("�м�"),
	MIN_GRADE("�ͼ�")
	;
	public String grade;
	Grade(String grade) {		
		this.grade= grade;		 
	} 
	 public String getGrade() {
		 return this.grade;
	 }  
}
