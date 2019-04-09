package com.hyz0408.common;

public enum StudentOperation {
	VIEW_ALL(1,"查看全部"),
	VIEW_ID(2,"按照ID查询"),
	ADD_STUDENT(3,"添加学生"),
	DEL_STUDENT(4,"删除学生"),
	ALTER_STUDENT(5,"修改学生")
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
