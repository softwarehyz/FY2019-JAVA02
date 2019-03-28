package com.hyz0328.view.impl;
import java.util.Scanner;
import com.hyz0328.pojo.Student;
import com.hyz0328.pojo.User;
import com.hyz0328.service.impl.FunctionalImpl;
import com.hyz0328.view.UserView;

public class UserViewImpl implements UserView {
FunctionalImpl F1=new FunctionalImpl();
	
	public void welcome(){                        //欢迎界面
		System.out.println("\n"+"·············欢迎登陆学生管理系统·············" + "\n"+ "\n"  +"\t" +"\t"+ "1.登陆" + "\t" +"\t"+"\t"+"\t"+ "2.退出" + "\n"+ "\n" + "····································"+ "\n");		
		}
	
	public  void operation1(){                 //选择登陆还是退出
		User[] User= new User[3];              //定义一个数组用来存储系统用户  
		User s=new User("admin","admin");
		User[0]=s;
		Scanner scan = new Scanner(System.in);
	    System.out.print("请选择：");
		int n=scan.nextInt();
		if(n==1){
			login(User);//登陆操作
		}else if(n==2){
			System.out.println("系统退出成功！");
			System.exit(0);//退出操作	
		}else{
			
			System.out.println("少年别乱来，再输入一次吧！");
			operation1();              //递归调用
		}
		
	}
	
	
	public  void login(User[] user){                  //登陆并验证	
		System.out.println("\n"+ "·············欢迎登陆 请验证身份·············" + "\n");	
	    Scanner scan = new Scanner(System.in);
		System.out.print("请输入用户名："); 
		String name=scan.nextLine(); 
		System.out.print("请输入密码："); 
		String password=scan.nextLine(); 
		for(int i=0;i<user.length;i++){
			if(user[i]==null){                                 //此处有疑问
				continue;
			}
			if(name.equals(user[i].name)&&password.equals(user[i].password)){
				System.out.println("\n"+ "·············欢迎登陆"+"\t"+name+"·············" + "\n");
				break;
			}else{	
				System.out.println("验证身份失败，请重新输入");
				login(user);
			    }
			
		    }
		}	
	
	
	public  void operation2(Student[] student,Student[] student1){                     //选择如何操作学生信息
		System.out.println("\n"+ "--------------------------------------请选择您要进行的操作------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.查看学生信息"+"\t"+"2.添加学生信息"+"\t"+"3.删除学生信息"+"\t"+"4.修改学生信息"+"\t"+"5.退出"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入对应的数字：");
		int select=scan.nextInt();
		switch(select){
		case 1:
		F1.CheckInfo(student);//查看学生信息
		operation2(student,student1);
		break;
		case 2:
		F1.AddInfo(student);//添加学生信息
		operation2(student,student1);
		break;
		case 3:
		F1.DelInfo(student,student1);//删除学生信息
		operation2(student,student1);
		break;
		case 4:
		F1.AlterInfo(student);//修改学生信息
		operation2(student,student1);
		break;
		case 5:
		System.out.println("系统退出成功！");
		System.exit(0);//退出
		break;
		default:
		System.out.println("\n"+"少年，请认真输入！"+"\n");
		operation2(student,student1);
		   }
		}
}
