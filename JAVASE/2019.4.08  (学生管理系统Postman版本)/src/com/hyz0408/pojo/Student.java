package com.hyz0408.pojo;

import java.util.Comparator;

import com.hyz0408.pojo.Student;

public class Student {                               //—ß…˙¿‡
	public int stuid;
	public String name;
	public String sex;
	public int score;
	public int age;
	public String grade;
	public String addr;
	public String phone;
	public String email;
	public long add_date;
	public Student() {
		
	}
	
	public Student(int stuid,String name,String sex,int score,int age,String grade,String addr,String phone,String email,long add_date){
	this.stuid=stuid;
	this.name=name;
	this.sex=sex;
	this.score=score;
	this.age=age;
	this.grade=grade;
	this.addr=addr;
	this.phone=phone;
	this.email=email;
	this.add_date=add_date;
	}
	
	public int getStuid(){
		return stuid;
	}
	
	public void setStuid(int stuid){
		this.stuid=stuid;
	}
	
	public String getName(){                     
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getSex(){                     
		return sex;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public int getScore(){                     
		return score;
	}
	
	public void setScore(int score){
		this.score=score;
	}
	
	public int getAge(){                     
		return age;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public String getGrade(){                     
		return grade;
	}
	
	public void setGrade(String grade){
		this.grade=grade;
	}
	
	public String getAddr(){                     
		return addr;
	}
	
	public void setAddr(String addr){
		this.addr=addr;
	}
	
	public String getPhone(){                     
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getEmail(){                     
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}

	public long getAdd_date(){                     
		return add_date;
	}
	
	public void setAdd_date(long add_date){
		this.add_date=add_date;
	}
}
