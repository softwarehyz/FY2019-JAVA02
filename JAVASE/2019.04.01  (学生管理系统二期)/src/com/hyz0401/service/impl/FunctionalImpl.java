package com.hyz0401.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hyz0401.pojo.Student;
import com.hyz0401.pojo.User;
import com.hyz0401.service.Functional;
import java.util.Scanner;

public class FunctionalImpl implements Functional {     //定义一个数组用来存储学生信息
	 //UserViewImpl u1=new UserViewImpl();
	 boolean x=false;
	   public  void CheckInfo(List<Student> student){                     //查看所有学生信息
		   look(student);	
		  /**  Student s1=new Student();
		       for(int i=0;i<student.size();i++) {
		    	if(student.get(i)!=null) {		
		    	for(int j=0;j<student.size()-1-i;j++) {
		    		if(student.get(j)!=null&&student.get(j+1)!=null) {
		    		if(student.get(j).getScore()<student.get(j+1).getScore()) {
		    			s1=student.get(j);
		    			student.set(j,student.get(j+1));
		    			student.set(j+1,s1);
		    		}
		    	}
		    }
		 }
	 }	*/

	   }
	public  void AddInfo(List<Student> student) {                             //添加学生的方法
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		int stuid;
		while(true) {
			System.out.println("请输入学号：");
			stuid = scan.nextInt();
			boolean flag=false;
			for(int i=0;i<student.size();i++) {
				if(student.get(i).getStuid()==stuid) {		
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
    	System.out.print("请输入学生成绩："); 
    	int score1=scan.nextInt(); 
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
    	long add_date=System.currentTimeMillis();
		//创建学生对象
		Student s = new Student();
		s.setStuid(stuid);
		s.setName(name1);
		s.setSex(sex1);
		s.setScore(score1);
		s.setAge(age1);
		s.setGrade(grade1);
		s.setAddr(addr1);
		s.setPhone(phone1);
		s.setEmail(email1);
		s.setAdd_date(add_date);
		//把学生对象添加到集合
		for(int i=0;i<student.size();i++) {
				student.add(i,s);	
				break;
		}
		
		System.out.println("添加学生成功！");
		System.out.println("系统自动返回上一级......");
	}
	
	public  void DelInfo(List<Student> student) {        //删除学生的方法
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入您要删除的学生ID:");
		int num=scan.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
			continue;	
			}
			if(student.get(i).getStuid()==num) {    //判断输入的学号是否与数组中取出的相等
				x=false;    //用布尔类型的一个变量来判断输入的学号是否存在
				System.out.println("您要删除的学生信息如下:");	
				System.out.println("\n"+"丨"+student.get(i).getStuid()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getScore()+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddr()+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail());	
				System.out.println("请确认是否删除:       1.是                        2.否       "+"\n");
				System.out.print("请输入:");
				int num1=scan.nextInt();
				if(num1==1) {
					student.remove(i);
					System.out.println("删除成功");	
					break;
				}else if(num1==2) {
					System.out.println("取消成功");	
					break;
				}else {
					System.out.println("乱输入的后果就是重新来过！！");
					DelInfo(student); 
					break;
				}
			}else {
				x=true;
			}
			
		}
		if(x==true) {
			System.out.println("您要删除的学生不存在");	
			DelInfo(student);
		}
		
	}                                                  //删除学生方法完毕
	
	
	public  void AlterInfo(List<Student> student) {        //修改学生信息的方法
		
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
	
	public  void test1(List<Student> student) {              //修改学生全部信息方法
		Scanner scan= new Scanner(System.in);
		System.out.print("请输入ID：");	
		int t1=scan.nextInt();
		boolean x1=false;
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x1=false;
			if(student.get(i).getStuid()==t1) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("\n"+"丨"+student.get(i).getStuid()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getScore()+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddr()+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail()+"\n");
				System.out.print("请输入修改后ID：");	
				int a=scan.nextInt();
				student.get(i).setStuid(a);
				System.out.print("请输入修改后Name：");
				String b=scan.next();
				student.get(i).setName(b);
				System.out.print("请输入修改后Sex：");	
				String c=scan.next();
				student.get(i).setSex(c);
				System.out.print("请输入修改后Score：");	
				int d=scan.nextInt();
				student.get(i).setAge(d);
				System.out.print("请输入修改后Age：");	
				int n=scan.nextInt();
				student.get(i).setScore(n);
				System.out.print("请输入修改后Grade：");	
				String e=scan.next();
				student.get(i).setGrade(e);
				System.out.print("请输入修改后Addr：");
				String f=scan.next();
				student.get(i).setAddr(f);
				System.out.print("请输入修改后Phone：");	
				String g=scan.next();
				student.get(i).setPhone(g);
				System.out.print("请输入修改后Email：");	
				String h=scan.next();
				student.get(i).setEmail(h);
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
	
	
	public  void test2(List<Student> student) {              //修改学生部分信息方法
		
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入ID：");	
		int t2=scan.nextInt();
		boolean x2=false;
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x2=false;
			if(student.get(i).getStuid()==t2) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("\n"+"丨"+student.get(i).getStuid()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getScore()+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddr()+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail()+"\n");
				System.out.println("请输入要修改的属性：");	 
				String t3=scan.next();
				System.out.println("请输入修改后的值：");	 
				String t4=scan.next();
				if(t3.equals("name")) {
					student.get(i).setName(t4);
				}else if(t3.equals("sex")) {
					student.get(i).setSex(t4);
				}else if(t3.equals("score")) {
					student.get(i).setScore(Integer.valueOf(t4));
				}else if(t3.equals("age")) {
					student.get(i).setAge(Integer.valueOf(t4));
				}else if(t3.equals("grade")) {
					student.get(i).setGrade(t4);
				}else if(t3.equals("addr")) {
					student.get(i).setAddr(t4);
				}else if(t3.equals("phone")) {
					student.get(i).setPhone(t4);
				}else if(t3.equals("email")) {
					student.get(i).setEmail(t4);
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
	
	public void look(List<Student> student) {                                      //选择查看方式可以选降序也可以选升序
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.成绩升序查看"+"\t"+"2.成绩降序查看"+"\t"+"3.返回上一级"+"\t"+"*");
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		Scanner scan= new Scanner(System.in);
		System.out.print("请选择您要查看的方式:");
	    int n=scan.nextInt();
	    if(n==1) {
	    	System.out.println("\n"+ "--------------------------------------所有学生信息如下------------------------------------------" + "\n");
			System.out.println("\n"+ "丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨成绩"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"丨联系方式"+"\t"+"\t"+"丨邮箱"+"\t"+"\t"+"丨注册时间");	 
			//让学生信息按照成绩从高到低排序输出
			Collections.sort(student);          //升序排成绩

			   for(int i=0;i<student.size();i++) {
			    	if(student.get(i)!=null) {		
				System.out.print("\n"+"丨"+student.get(i).getStuid()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getScore()+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddr()+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail());	
				Date date=new Date(student.get(i).getAdd_date());
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println("\t" +format.format(date));
			    	}continue;
			    }
			    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");		    
			    System.out.println("自动返回上一级......");
			    CheckInfo(student);	
	    }else if(n==2) {
	    	System.out.println("\n"+ "--------------------------------------所有学生信息如下------------------------------------------" + "\n");
			System.out.println("\n"+ "丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨成绩"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"丨联系方式"+"\t"+"\t"+"丨邮箱"+"\t"+"\t"+"丨注册时间");	 
			//让学生信息按照成绩从高到低排序输出
			Collections.sort(student);  
			Collections.reverse(student);

			   for(int i=0;i<student.size();i++) {
			    	if(student.get(i)!=null) {		
				System.out.print("\n"+"丨"+student.get(i).getStuid()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getScore()+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddr()+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail());	
				Date date=new Date(student.get(i).getAdd_date());
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println("\t" +format.format(date));
			    	}continue;
			    }
			    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");		    
			    System.out.println("自动返回上一级......");
			    CheckInfo(student);	
	    }else if(n==3) {
	    //返回上一级
	    }else {
	    	System.out.println("少年别乱来，请再次选择您要进行的操作");
	    	look(student);
	    }
	}
}



