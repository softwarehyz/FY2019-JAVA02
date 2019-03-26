package com.hyz;

import java.util.Scanner;

public class LogReg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		welcome();
		operation1();
	}
	
	public static void welcome(){                        //欢迎界面
		System.out.println("\n"+"·············欢迎使用本系统系统·············" + "\n"+ "\n"  +"\t" +"\t"+ "1.登陆" + "\t" +"\t"+ "2.注册"+"\t"+"\t"+"3.退出" + "\n"+ "\n" + "····································"+ "\n");		
		}
		
		public static void operation1(){                 //选择登陆还是退出
			LogReg L1=new LogReg();
			TUserView T2=L1.new TUserView();
			Scanner scan = new Scanner(System.in);
		    System.out.print("请选择：");
			int n=scan.nextInt();
			if(n==1){
				T2.login();//登陆操作
			}else if(n==2){
				T2.register();//注册操作	
			}else if(n==3){
				System.exit(0);//退出操作	
			}else{
				
				System.out.println("少年别乱来，再输入一次吧！");
				operation1();              //递归调用
			}
			
		}
	
	class User{                                      //用户类
		public String username;
		public String password;
		public String name;
		public String email;
		
		public User() {                 //无参数构造方法
			
		}
		public User(String username,String password,String name,String email) {    //有参数构造方法
		  this.username=username;
		  this.password=password;
		  this.name=name;
		  this.email=email;
		}
		
		public String getUsername() {
			return username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public String getName() {
			return name;
		}
		
		public String getEmail() {
			return email;
		}
		
		
		public void setUsername(String username) {
			this.username=username;
		}
		
		public void setPassword(String password) {
			 this.password=password;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public void setEmail(String email) {
			this.email=email;
		}
		
	}
	
	class LoginException extends RuntimeException{  //LoginException异常类
		
		public LoginException(){
			
		}
		
        public LoginException(String msg){
			super(msg);
		}
	}   
        
    class RegisterException extends RuntimeException{  //RegisterException异常类
    		
    		public RegisterException(){
    			
    		}
    		
            public RegisterException(String msg){
    			super(msg);
    		}
		
    	}     
            
    	
    	interface UserBiz {            //UserBiz接口
            void register(String username, String password, String password2,String name, String email) throws RegisterException; //用户注册
            void login(String username, String password) throws LoginException;//用户登录
            }
            
        
   	class TUserBiz implements UserBiz{          //TUserBiz实现类
   		User[] users=new User[5]; {    			
    		User a=new User("admin","admin","Administrator","admin@123.com");
    		User b=new User("tom","cat","tomcat","tomcat@cat.com");
    		users[0]=a;
    		users[1]=b;
    		}
    		public  void register(String username, String password, String password2,String name, String email) throws RegisterException{
    			for(int i=0;i<users.length;i++) {
    				if(users[i]==null) {
    					continue;
    				}
    				if(users[i].getUsername().equals(username)) {
    					throw new RegisterException("username在数组中已经存在");
    				}break;
    			} 
    			if(!(password.equals(password2))) {
					throw new RegisterException("两次输入的password不一致");
				}	
    		 } //用户注册
    		 public void login(String username, String password) throws LoginException{
    			 for(int i=0;i<users.length;i++) {
    				 if(users[i]==null) {
    					continue; 
    				 }
    				 if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password)) {
      					System.out.println("登陆成功！");
      					break;
      				}
     				if(!users[i].getUsername().equals(username)) {
     					throw new RegisterException("username不存在");
     				}
     				if(!users[i].getPassword().equals(password)) {
     					throw new RegisterException("username和password不匹配");
     				}	 
     			} 
     			
             }//用户登录
    	}
    	
    	interface UserView{
    		void login();
    		void register();
    	}
    	
     class TUserView implements UserView{
    		
    		public void login() {
    			 TUserBiz T1= new TUserBiz();  
    			Scanner s=new Scanner(System.in);
    			System.out.println("请输入用户名:");
    			String username=s.next();
    			System.out.println("请输入密码:");
    		    String password =s.next();   		     
    		    T1.login(username, password);
    		}
    		public void register() {
    			Scanner s=new Scanner(System.in);
    			System.out.println("请输入用户名:");
    			String username=s.next();
    			System.out.println("请输入密码:");
    		    String password =s.next(); 
    		    System.out.println("请确认密码:");
    		    String password2 =s.next(); 
    		    System.out.println("请输入真实姓名:");
    		    String name =s.next(); 
    		    System.out.println("请输入电子邮件:");
    		    String email =s.next(); 
    		    TUserBiz T1= new TUserBiz();    
    		    T1.register(username, password,password2,name,email);
    		}
    	}
    	
	}
	
