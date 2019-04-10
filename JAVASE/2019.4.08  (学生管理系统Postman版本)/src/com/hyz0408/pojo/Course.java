package com.hyz0408.pojo;

public class Course {

	private int cid;
	private String cname;
	public Course(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Course() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
