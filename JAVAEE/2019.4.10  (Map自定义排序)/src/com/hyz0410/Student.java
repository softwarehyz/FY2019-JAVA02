package com.hyz0410;

public class Student {

	public int ID;
	public String name;
	public int score;

	public Student() {
		super();
	}
	public Student(int iD, String name, int score) {
		super();
		ID = iD;
		this.name = name;
		this.score = score;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
