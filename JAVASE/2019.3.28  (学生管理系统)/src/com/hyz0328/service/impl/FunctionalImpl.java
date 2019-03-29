package com.hyz0328.service.impl;

import java.util.Scanner;

import com.hyz0328.pojo.Student;
import com.hyz0328.service.Functional;
import com.hyz0328.view.impl.UserViewImpl;


public class FunctionalImpl implements Functional {     //定义一个数组用来存储学生信息
	
	 //UserViewImpl u1=new UserViewImpl();
	 boolean x=false;
	   public  void CheckInfo(Student[] student){                     //查看所有学生信息
    	System.out.println("\n"+ "--------------------------------------所有学生信息如下------------------------------------------" + "\n");
		System.out.println("\n"+ "丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"丨联系方式"+"\t"+"\t"+"丨邮箱");	    	
		    for(int i=0;i<student.length;i++) {
		    	if(student[i]!=null) {		
			System.out.println("\n"+"丨"+student[i].getStuid()+"\t" +"丨"+student[i].getName()+"\t"+"丨"+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"+student[i].getAddr()+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail());	
		    	}continue;
		 
		    }
		    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");	
	   }	    
	
	
	public  void AddInfo(Student[] student) {                             //添加学生的方法
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		int stuid;
		while(true) {
			System.out.println("请输入学号：");
			stuid = scan.nextInt();
			boolean flag=false;
			for(int i=0;i<student.length;i++) {
				if(student[i].getStuid()==stuid) {		
					flag = true;			
					break;
				}else {
					flag = false;			
					break;
				}
			}
			if(flag) {
				System.out.println("您输入的账号被占用！！！");
			}else {
				
				break;
			}
		}
		System.out.print("请输入学生姓名："); 
    	String name1=scan.next();
    	scan.nextLine();
    	System.out.print("请输入学生性别："); 
    	String sex1=scan.next(); 
    	scan.nextLine();
    	System.out.print("请输入学生年龄(只能1-120之间的数字)："); 
    	int age1=scan.nextInt(); 
    	scan.nextLine();
    	System.out.print("请输入学生所属年级(只能初级、中级、高级)："); 
    	String grade1=scan.next(); 
    	scan.nextLine();
    	System.out.print("请输入学生地址："); 
    	String addr1=scan.next();
    	scan.nextLine();
    	System.out.print("请输入学生联系方式："); 
    	String phone1=scan.next(); 
    	scan.nextLine();
    	System.out.print("请输入学生电子邮箱："); 
    	String email1=scan.next(); 
    	scan.nextLine();
		//创建学生对象
		Student s = new Student();
		s.setStuid(stuid);
		s.setName(name1);
		s.setSex(sex1);
		s.setAge(age1);
		s.setGrade(grade1);
		s.setAddr(addr1);
		s.setPhone(phone1);
		s.setEmail(email1);
		//把学生对象添加到集合
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				student[i]=s;	
				break;
			}
		}
		
		System.out.println("添加学生成功！");
		System.out.println("系统自动返回上一级......");
	}
	
	public  void DelInfo(Student[] student,Student[] student1) {        //删除学生的方法
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入您要删除的学生ID:");
		int num=scan.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
			continue;	
			}
			if(student[i].getStuid()==num) {    //判断输入的学号是否与数组中取出的相等
				x=false;    //用布尔类型的一个变量来判断输入的学号是否存在
				System.out.println("您要删除的学生信息如下:");	
				System.out.println("\n"+"丨"+student[i].getStuid()+"\t" +"丨"+student[i].getName()+"\t"+"丨"+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"+student[i].getAddr()+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail());	
				System.out.println("请确认是否删除:       1.是                        2.否       "+"\n");
				System.out.print("请输入:");
				int num1=scan.nextInt();
				if(num1==1) {
					
					for(int j=0;j<student.length;j++) {
						if(student[j]==null) {
							continue;
						}	
						if(student[i].getStuid()!=student[j].getStuid()) {
							Student s=new Student(student[j].getStuid(),student[j].getName(),student[j].getSex(),student[j].getAge(),student[j].getGrade(),student[j].getAddr(),student[j].getPhone(),student[j].getEmail());
							for(int k=0;k<student1.length;k++) {
								if(student1[k]==null) {
									student1[k]=s;
									break;
								}
							}
							
						}
					}
					System.arraycopy(student1, 0, student, 0, student1.length);//student=student1;
					System.out.println("删除成功");	
					break;
				}else if(num1==2) {
					System.out.println("取消成功");	
					break;
				}else {
					System.out.println("乱输入的后果就是重新来过！！");
					DelInfo(student,student1); 
					break;
				}
			}else {
				x=true;
			}
			
		}
		if(x==true) {
			System.out.println("您要删除的学生不存在");	
			DelInfo(student,student1);
		}
		
	}                                                  //删除学生方法完毕
	
	
	public  void AlterInfo(Student[] student) {        //修改学生信息的方法
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.根据ID修改学生全部信息"+"\t"+"2.根据ID修改学生部分信息"+"\t"+"3.返回上级目录"+"\t"+"4.退   出"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		System.out.print("请输入您要进行的操作");	
		Scanner scan= new Scanner(System.in);
		int t=scan.nextInt();
		if(t==1) {                                            //根据ID修改学生全部信息
		test1(student);
		}else if(t==2) {
		test2(student);	    //根据ID修改学生部分信息
		}else if(t==3) {
		//operation2(student);    //返回上级目录
		}else if(t==4){
		System.out.println("系统退出成功！");
		System.exit(0);//退出
		}else {
			System.out.println("少年别乱来，重输入一次吧！");	
			AlterInfo(student);
		}
	}
	
	public  void test1(Student[] student) {              //修改学生全部信息方法
		Scanner scan= new Scanner(System.in);
		System.out.print("请输入ID：");	
		int t1=scan.nextInt();
		boolean x1=false;
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x1=false;
			if(student[i].getStuid()==t1) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("\n"+"丨"+student[i].getStuid()+"\t" +"丨"+student[i].getName()+"\t"+"丨"+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"+student[i].getAddr()+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail()+"\n");
				System.out.print("请输入修改后ID：");	
				int a=scan.nextInt();
				student[i].setStuid(a);
				System.out.print("请输入修改后Name：");
				String b=scan.next();
				student[i].setName(b);
				System.out.print("请输入修改后Sex：");	
				String c=scan.next();
				student[i].setSex(c);
				System.out.print("请输入修改后Age：");	
				int d=scan.nextInt();
				student[i].setAge(d);
				System.out.print("请输入修改后Grade：");	
				String e=scan.next();
				student[i].setGrade(e);
				System.out.print("请输入修改后Addr：");
				String f=scan.next();
				student[i].setAddr(f);
				System.out.print("请输入修改后Phone：");	
				String g=scan.next();
				student[i].setPhone(g);
				System.out.print("请输入修改后Email：");	
				String h=scan.next();
				student[i].setEmail(h);
				System.out.println("修改成功！自动返回上一级......");
				AlterInfo(student);
				break;	
			}else {
				x1=true;
			}
	
		}
		if(x1==true) {
			System.out.println("您输入的ID不存在，请重新来过!!!");
			test1(student);
		}
		
		//u1.operation2(student);
	}
	
	
	public  void test2(Student[] student) {              //修改学生部分信息方法
		
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入ID：");	
		int t2=scan.nextInt();
		boolean x2=false;
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x2=false;
			if(student[i].getStuid()==t2) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("\n"+"丨"+student[i].getStuid()+"\t" +"丨"+student[i].getName()+"\t"+"丨"+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"+student[i].getAddr()+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail()+"\n");
				System.out.println("请输入要修改的属性：");	 
				String t3=scan.next();
				System.out.println("请输入修改后的值：");	 
				String t4=scan.next();
				if(t3.equals("name")) {
					student[i].setName(t4);
				}else if(t3.equals("sex")) {
					student[i].setSex(t4);
				}else if(t3.equals("age")) {
					student[i].setAge(Integer.valueOf(t4));
				}else if(t3.equals("grade")) {
					student[i].setGrade(t4);
				}else if(t3.equals("addr")) {
					student[i].setAddr(t4);
				}else if(t3.equals("phone")) {
					student[i].setPhone(t4);
				}else if(t3.equals("email")) {
					student[i].setEmail(t4);
				}
				System.out.println("修改成功！自动返回上一级......");
				AlterInfo(student);
				break;	
			}else {
				x2=true;
			}
	
		}
		if(x2==true) {
		System.out.println("您输入的ID不存在!!!");
		test2(student);
		}
	}
	
	

}
