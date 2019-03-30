package com.hyz0330;

public class Objectpractice {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
		User user1=new User("张珊","男");
	    User user2=new User("张珊","男");
		user.check1(user1,user2);
		user.DaYin(user1);
	   }	
}	

	
class User{
	private String name;
	private String sex;
	public User() {
		
	}
	
	public User(String name,String sex) {
		this.name=name;
		this.sex=sex;
	}

	public void check1(User user1,User user2) {
		System.out.println("判断新建两个对象是否相等"+"\n");
		System.out.println("用equals方法（重写）判断");
		if(user1.equals(user2)) {
			System.out.println("相等"+"\n");
		}else {
			System.out.println("不相等"+"\n");
		}
		System.out.println("用==判断");
		if(user1==user2) {
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}
		
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public String getSex(){
		return this.sex;
	}
	
	
	
	
	public boolean equals(Object obj) {      //重写equals方法
   	 if(obj==null) {
   		 return false;
   	 }
   	 User user1=(User)obj;
   	 if(user1.getName().equals(this.name)&&user1.getSex().equals(this.sex)) {
   		return true;
   	 }else {
   		return false;
   	 }
   	 
    }

	
	public void DaYin(User user1) {
		System.out.println("\n"+"方法重写后的打印结果："+user1+"\n"+"(默认调用toString（）方法)");
	}
	
	public String toString() {                       //重写toString()方法
		return this.name+"\t"+this.sex;
	}
	
	
	
	
	

}
