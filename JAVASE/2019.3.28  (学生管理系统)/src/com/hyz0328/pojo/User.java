package com.hyz0328.pojo;



public class User {                          //����Ա��
	public String name;
	public String password;
	
	public User(){
		User[] User= new User[3];              //����һ�����������洢ϵͳ�û�  
		User s=new User("admin","admin");
		User[0]=s;
	}
	
	public User(String name,String password){
		this.name=name;
		this.password=password;
	}
	
	public String getName(){                     
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
}
