package com.hyz0401.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hyz0401.pojo.Grade;
import com.hyz0401.pojo.Student;
import com.hyz0401.pojo.User;
import com.hyz0401.service.Functional;
import com.hyz0401.view.impl.UserViewImpl;

import java.util.Scanner;

public class FunctionalImpl implements Functional {    
	//UserViewImpl u1=new UserViewImpl();
	private static FunctionalImpl F1;
	private List<Student> student=new ArrayList<Student>();         //定义一个数组用来存储学生信息
	 
	private FunctionalImpl() {
		Student s=new Student(2014,"韩艳祖","男",88,25,"高级","山西朔州","18434260817","14169@qq.cn",1554132344000L);
		Student s1=new Student(2015,"蔚卫","男",99,25,"中级","山西朔州","18434260834","84589@qq.cn",1557132334000L);
		Student s2=new Student(2016,"姜一飞","男",66,25,"低级","山西朔州","18434260821","84529@qq.cn",1558132394000L);
		student.add(s);
		student.add(s1);
		student.add(s2);
	}
	
	public synchronized static FunctionalImpl getInstance() {
		if(F1==null) {
			 F1=new FunctionalImpl();
		}
			return F1;
	}
	
	boolean x=false;
	   //public  void CheckInfo(/*List<Student> student*/){                     //查看所有学生信息
		  // look(/*student*/);	
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
 // }
	    
	public  void AddInfo(/*List<Student> student*/) {                             //添加学生的方法
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
	    int stuid=0;
			System.out.println("请输入学号：");
			stuid = scan.nextInt();
			boolean flag=false;
			for(int i=0;i<student.size();i++) {
				if(student.get(i).getStuid()==stuid) {		
					flag = true;
					break;
				}else {
					flag = false;
				}
			}
			if(flag) {
				System.out.println("您输入的账号被占用！！！");
				AddInfo();
			}
			if(!flag) {
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
        String s1=choice();
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
		s.setGrade(s1);
		s.setAddr(addr1);
		s.setPhone(phone1);
		s.setEmail(email1);
		s.setAdd_date(add_date);
		//把学生对象添加到集合
		student.add(s);	
		System.out.println("添加学生成功！");
		System.out.println("系统自动返回上一级......");
	   }
	}	
	public  void DelInfo(/*List<Student> student*/) {        //删除学生的方法
				Scanner scan= new Scanner(System.in);
				System.out.println("请输入您要删除的学生ID:");
				int num=scan.nextInt();
				Student str=testFind1(num);   //二分查找判断学生是否存在
				if(str!=null) {
				System.out.println("您要删除的学生信息如下:");	
				System.out.println("\n"+"丨"+str.getStuid()+"\t" +"丨"+str.getName()+"\t"+"丨"+str.getSex()+"\t"+"丨"+str.getScore()+"\t"+"丨"+str.getAge()+"\t"+"丨"+str.getGrade()+"\t"+"丨"+str.getAddr()+"\t"+"丨"+str.getPhone()+"\t"+"丨"+str.getEmail());	
				System.out.println("请确认是否删除:       1.是                        2.否       "+"\n");
				System.out.print("请输入:");
				int num1=scan.nextInt();
				if(num1==1) {
					student.remove(str);
					System.out.println("删除成功");	
				}else if(num1==2) {
					System.out.println("取消成功");	
				}else {
					System.out.println("乱输入的后果就是重新来过！！");
					DelInfo(/*student*/); 
				 }
             }     
		}                                            //删除学生方法完毕
	
	
	public  void AlterInfo(/*List<Student> student*/) {        //修改学生信息的方法
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.根据ID修改学生全部信息"+"\t"+"2.根据ID修改学生部分信息"+"\t"+"3.返回上级目录"+"\t"+"4.退   出"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		System.out.print("请输入您要进行的操作");	
		Scanner scan= new Scanner(System.in);
		int t=scan.nextInt();
		if(t==1) {               //根据ID修改学生全部信息
		test1(/*student*/);
		}else if(t==2) {
		test2(/*student*/);	    //根据ID修改学生部分信息
		}else if(t==3) {
		//operation2(student);    //返回上级目录
		}else if(t==4){
		System.out.println("系统退出成功！");
		System.exit(0);//退出
		}else {
			System.out.println("少年别乱来，重输入一次吧！");	
			AlterInfo(/*student*/);
		}
	}
	
	public  void test1(/*List<Student> student*/) {              //修改学生全部信息方法
		Scanner scan= new Scanner(System.in);
		System.out.print("请输入ID：");	
		int t1=scan.nextInt();
		Student str2=testFind3(t1);
		if(str2!=null) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("\n"+"丨"+str2.getStuid()+"\t" +"丨"+str2.getName()+"\t"+"丨"+str2.getSex()+"\t"+"丨"+str2.getScore()+"\t"+"丨"+str2.getAge()+"\t"+"丨"+str2.getGrade()+"\t"+"丨"+str2.getAddr()+"\t"+"丨"+str2.getPhone()+"\t"+"丨"+str2.getEmail()+"\n");
				System.out.print("请输入修改后ID：");	
				int a=scan.nextInt();
				str2.setStuid(a);
				System.out.print("请输入修改后Name：");
				String b=scan.next();
				str2.setName(b);
				System.out.print("请输入修改后Sex：");	
				String c=scan.next();
				str2.setSex(c);
				System.out.print("请输入修改后Score：");	
				int d=scan.nextInt();
				str2.setAge(d);
				System.out.print("请输入修改后Age：");	
				int n=scan.nextInt();
				str2.setScore(n);
				System.out.print("请输入修改后Grade：");	
				String e=scan.next();
				str2.setGrade(e);
				System.out.print("请输入修改后Addr：");
				String f=scan.next();
				str2.setAddr(f);
				System.out.print("请输入修改后Phone：");	
				String g=scan.next();
				str2.setPhone(g);
				System.out.print("请输入修改后Email：");	
				String h=scan.next();
				str2.setEmail(h);
		//u1.operation2(student);
	   }
		System.out.println("修改成功！自动返回上一级......");
		AlterInfo(/*student*/);
    }	
	public  void test2(/*List<Student> student*/) {              //修改学生部分信息方法
		
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入ID：");	
		int t2=scan.nextInt();
		        Student str1=testFind2(t2);
		        if(str1!=null) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("\n"+"丨"+str1.getStuid()+"\t" +"丨"+str1.getName()+"\t"+"丨"+str1.getSex()+"\t"+"丨"+str1.getScore()+"\t"+"丨"+str1.getAge()+"\t"+"丨"+str1.getGrade()+"\t"+"丨"+str1.getAddr()+"\t"+"丨"+str1.getPhone()+"\t"+"丨"+str1.getEmail()+"\n");
				System.out.println("请输入要修改的属性：");	 
				String t3=scan.next();
				System.out.println("请输入修改后的值：");	 
				String t4=scan.next();
				if(t3.equals("name")) {
					str1.setName(t4);
				}else if(t3.equals("sex")) {
					str1.setSex(t4);
				}else if(t3.equals("score")) {
					str1.setScore(Integer.valueOf(t4));
				}else if(t3.equals("age")) {
					str1.setAge(Integer.valueOf(t4));
				}else if(t3.equals("grade")) {
					str1.setGrade(t4);
				}else if(t3.equals("addr")) {
					str1.setAddr(t4);
				}else if(t3.equals("phone")) {
					str1.setPhone(t4);
				}else if(t3.equals("email")) {
					str1.setEmail(t4);
				}
		}	
		System.out.println("修改成功！自动返回上一级......");
		AlterInfo(/*student*/);
	}
	
	public void look(/*List<Student> student*/) {   //选择查看方式可以选降序也可以选升序
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.成绩升序查看"+"\t"+"2.成绩降序查看"+"\t"+"3.ID查询学生"+"\t"+"4.返回上一级"+"\t"+"*");
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
			    look(/*student*/);	
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
				    look(/*student*/);	
	    }else if(n==3) {
	    	findStudent() ;
	    }else if(n==4) {
	        //返回上一级
	    }else {
	    	System.out.println("少年别乱来，请再次选择您要进行的操作");
	    	look(/*student*/);
	    }
	}

	
	public  Student testFind(int c) {   //用ID二分查找对应学生
		Student s=new Student();
		//System.out.println(student.size());
		for(int i=0;i<student.size();i++) {
			for(int j=0;j<student.size()-i-1;j++) {
				if(student.get(j)!=null&&student.get(j+1)!=null) {
				if(student.get(j).getStuid()>student.get(j+1).getStuid()) {
					s=student.get(j);
					student.set(j, student.get(j+1));
					student.set(j+1, s);
				  }
				}
			}
		}	
		int a=0;
		int b=student.size()-1;
		int k=(a+b)/2;
		boolean sf=false;
		while(a<=b) {
		if(c>student.get(k).getStuid()) {
			a=k+1; 
		   }else if(c<student.get(k).getStuid()) {
			b=k-1;
		   }else {
			    sf=true;
			    break;
		   }
		 k=(a+b)/2;
		}
		
	    if(!sf) {
	    	System.out.println("您要查找的学生不存在！！");
	    	findStudent();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//二分查找(用于查看)
	
	public  Student testFind1(int c) {   //用ID二分删除对应学生
		Student s=new Student();
		//System.out.println(student.size());
		for(int i=0;i<student.size();i++) {
			for(int j=0;j<student.size()-i-1;j++) {
				if(student.get(j)!=null&&student.get(j+1)!=null) {
				if(student.get(j).getStuid()>student.get(j+1).getStuid()) {
					s=student.get(j);
					student.set(j, student.get(j+1));
					student.set(j+1, s);
				  }
				}
			}
		}	
		int a=0;
		int b=student.size()-1;
		int k=(a+b)/2;
		boolean sf=false;
		while(a<=b) {
		if(c>student.get(k).getStuid()) {
			a=k+1; 
		   }else if(c<student.get(k).getStuid()) {
			b=k-1;
		   }else {
			    sf=true;
			    break;
		   }
		 k=(a+b)/2;
		}
		
	    if(!sf) {
	    	System.out.println("您要查找的学生不存在！！");
	    	DelInfo();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//二分查找(用于删除学生)
	
	public  Student testFind2(int c) {   //用ID二分修改学生部分属性
		Student s=new Student();
		//System.out.println(student.size());
		for(int i=0;i<student.size();i++) {
			for(int j=0;j<student.size()-i-1;j++) {
				if(student.get(j)!=null&&student.get(j+1)!=null) {
				if(student.get(j).getStuid()>student.get(j+1).getStuid()) {
					s=student.get(j);
					student.set(j, student.get(j+1));
					student.set(j+1, s);
				  }
				}
			}
		}	
		int a=0;
		int b=student.size()-1;
		int k=(a+b)/2;
		boolean sf=false;
		while(a<=b) {
		if(c>student.get(k).getStuid()) {
			a=k+1; 
		   }else if(c<student.get(k).getStuid()) {
			b=k-1;
		   }else {
			    sf=true;
			    break;
		   }
		 k=(a+b)/2;
		}
		
	    if(!sf) {
	    	System.out.println("您要查找的学生不存在！！");
	    	test2();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//二分查找(用于修改学生部分属性)
	
	
	public  Student testFind3(int c) {   //用ID二分修改学生全部属性
		Student s=new Student();
		//System.out.println(student.size());
		for(int i=0;i<student.size();i++) {
			for(int j=0;j<student.size()-i-1;j++) {
				if(student.get(j)!=null&&student.get(j+1)!=null) {
				if(student.get(j).getStuid()>student.get(j+1).getStuid()) {
					s=student.get(j);
					student.set(j, student.get(j+1));
					student.set(j+1, s);
				  }
				}
			}
		}	
		int a=0;
		int b=student.size()-1;
		int k=(a+b)/2;
		boolean sf=false;
		while(a<=b) {
		if(c>student.get(k).getStuid()) {
			a=k+1; 
		   }else if(c<student.get(k).getStuid()) {
			b=k-1;
		   }else {
			    sf=true;
			    break;
		   }
		 k=(a+b)/2;
		}
		
	    if(!sf) {
	    	System.out.println("您要查找的学生不存在！！");
	    	test1();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//二分查找(用于修改学生全部属性)
	
    public  String choice() {                                        //枚举类型选择年级
    	Scanner scan= new Scanner(System.in);
    	System.out.println("学生所属年级：1.高级      2.中级      3.初级"); 
    	System.out.print("请选择:"); 
    	int n=scan.nextInt(); 
        switch(n) {
        case 1:
    		System.out.println(Grade.MAX_GRADE.getGrade().toString());
    		return Grade.MAX_GRADE.getGrade();
        case 2:
    		System.out.println(Grade.MID_GRADE.getGrade().toString());
    		return Grade.MID_GRADE.getGrade();
        case 3:
    		System.out.println(Grade.MIN_GRADE.getGrade().toString());
    		return Grade.MIN_GRADE.getGrade();
        default:
    		System.out.println("选择有误，请重新选择");
    		choice();
          }
        return "";
     }
    
    public void findStudent() {
    	Scanner scan1= new Scanner(System.in);
		System.out.print("输入学生ID:");
	    int f=scan1.nextInt();	
    	Student s5=testFind(f);
    	if(s5!=null) {
    	System.out.println("您要查询的学生信息如下:");	
		System.out.println("\n"+"丨"+s5.getStuid()+"\t" +"丨"+s5.getName()+"\t"+"丨"+s5.getSex()+"\t"+"丨"+s5.getScore()+"\t"+"丨"+s5.getAge()+"\t"+"丨"+s5.getGrade()+"\t"+"丨"+s5.getAddr()+"\t"+"丨"+s5.getPhone()+"\t"+"丨"+s5.getEmail()+"\n");
		System.out.println("自动返回上一级......");
		look(/*student*/);	
        }
    }  
}
