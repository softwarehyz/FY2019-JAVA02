package com.hyz0401.view.impl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.hyz0401.pojo.Student;
import com.hyz0401.pojo.User;
import com.hyz0401.service.impl.FunctionalImpl;
import com.hyz0401.view.UserView;

public class UserViewImpl implements UserView {
//FunctionalImpl F1=new FunctionalImpl();
	FunctionalImpl F2=FunctionalImpl.getInstance();
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
		testt() ;
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
	
	public  void operation2(/*List<Student> student*/){                     //选择如何操作学生信息
		System.out.println("\n"+ "--------------------------------------请选择您要进行的操作------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.查看学生信息"+"\t"+"2.添加学生信息"+"\t"+"3.删除学生信息"+"\t"+"4.修改学生信息"+"\t"+"5.退出"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入对应的数字：");
		int select=scan.nextInt();
		switch(select){
		case 1:
		F2.CheckInfo(/*student*/);//查看学生信息
		operation2(/*student*/);
		break;
		case 2:
		F2.AddInfo(/*student*/);//添加学生信息
		operation2(/*student*/);
		break;
		case 3:
		F2.DelInfo(/*student*/);//删除学生信息
		operation2(/*student*/);
		break;
		case 4:
		F2.AlterInfo(/*student*/);//修改学生信息
		operation2(/*student*/);
		break;
		case 5:
		System.out.println("系统退出成功！");
		System.exit(0);//退出
		break;
		default:
		System.out.println("\n"+"少年，请认真输入！"+"\n");
		operation2(/*student*/);
		   }
		}
	
	
	public static boolean VerificationCode() {         //验证码校验
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大小写字母
		char[] ch = new char[4]; //声明一个字符数组对象ch 保存 验证码
		for (int i = 0; i < 4; i++) {
			Random random = new Random();//创建一个新的随机数生成器
			int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
			ch[i] = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》保存到字符数组对象ch里面
		}
		//将char数组类型转换为String类型保存到result
		//String result = new String(ch);//方法一：直接使用构造方法      String(char[] value) ：分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
		String result = String.valueOf(ch);//方法二： String方法   valueOf(char c) ：返回 char 参数的字符串表示形式。
		System.out.print("验证码：");
		System.out.println(result);
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入验证码(不区分大小写)：");
		String s=scan.next();
		if(s.equalsIgnoreCase(result)) {
			//System.out.println("验证成功");
			return true;
		}else {
			//System.out.println("验证失败");
			return false;
		}
	}
	
	public static void testt() {
		if(!VerificationCode() ) {
			System.out.println("验证码错误！请重新输入");
			testt();
		}
	}
	
}