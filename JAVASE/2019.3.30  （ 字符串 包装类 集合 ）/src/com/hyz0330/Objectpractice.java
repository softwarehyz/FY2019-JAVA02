package com.hyz0330;

public class Objectpractice {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
		User user1=new User("��ɺ","��");
	    User user2=new User("��ɺ","��");
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
		System.out.println("�ж��½����������Ƿ����"+"\n");
		System.out.println("��equals��������д���ж�");
		if(user1.equals(user2)) {
			System.out.println("���"+"\n");
		}else {
			System.out.println("�����"+"\n");
		}
		System.out.println("��==�ж�");
		if(user1==user2) {
			System.out.println("���");
		}else {
			System.out.println("�����");
		}
		
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public String getSex(){
		return this.sex;
	}
	
	
	
	
	public boolean equals(Object obj) {      //��дequals����
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
		System.out.println("\n"+"������д��Ĵ�ӡ�����"+user1+"\n"+"(Ĭ�ϵ���toString��������)");
	}
	
	public String toString() {                       //��дtoString()����
		return this.name+"\t"+this.sex;
	}
	
	
	
	
	

}
