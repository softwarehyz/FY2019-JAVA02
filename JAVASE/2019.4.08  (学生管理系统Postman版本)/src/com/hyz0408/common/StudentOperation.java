package com.hyz0408.common;

public enum StudentOperation {
	VIEW_ALL(1,"�鿴ȫ��"),
	VIEW_ID(2,"����ID��ѯ"),
	ADD_STUDENT(3,"���ѧ��"),
	DEL_STUDENT(4,"ɾ��ѧ��"),
	ALTER_STUDENT(5,"�޸�ѧ��")
	;
	private int ViewWay_type;
	private String ViewWay_desc;
	StudentOperation(int ViewWay_type,String ViewWay_desc){
		this.ViewWay_type=ViewWay_type;
		this.ViewWay_desc=ViewWay_desc;
	}
	public int getViewWay_type() {
		return ViewWay_type;
	}
	public void setViewWay_type(int ViewWay_type) {
		this.ViewWay_type = ViewWay_type;
	}
	public String getViewWay_desc() {
		return ViewWay_desc;
	}
	public void setViewWay_desc(String ViewWay_desc) {
		this.ViewWay_desc = ViewWay_desc;
	}
}
