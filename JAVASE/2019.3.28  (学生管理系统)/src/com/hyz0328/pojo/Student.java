package com.hyz0328.pojo;

public class Student {                               //—ß…˙¿‡
	public int stuid;
	public String name;
	public String sex;
	public int age;
	public String grade;
	public String addr;
	public String phone;
	public String email;
	
	public Student() {
		
	}
	
	public Student(int stuid,String name,String sex,int age,String grade,String addr,String phone,String email){
	this.stuid=stuid;
	this.name=name;
	this.sex=sex;
	this.age=age;
	this.grade=grade;
	this.addr=addr;
	this.phone=phone;
	this.email=email;
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
}
