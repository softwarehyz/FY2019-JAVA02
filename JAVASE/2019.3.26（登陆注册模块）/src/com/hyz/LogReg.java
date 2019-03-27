package com.hyz;

import java.util.Scanner;

public class LogReg {
	static LogReg L1=new LogReg();
	static TUserView T2=L1.new TUserView();   
    User[] users=new User[5]; 
    TUserBiz T1= new TUserBiz(users); 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		welcome();
		operation1();
	}
	
	public static void welcome(){                        //欢迎界面
		System.out.println("\n"+"·············欢迎使用本系统系统·············" + "\n"+ "\n"  +"\t" +"\t"+ "1.登陆" + "\t" +"\t"+ "2.注册"+"\t"+"\t"+"3.退出" + "\n"+ "\n" + "····································"+ "\n");		
		}
		public static void operation1(){                                     //选择登陆还是退出
			                                   		
			Scanner scan = new Scanner(System.in);
		    System.out.print("请选择：");
			int n=scan.nextInt();
			if(n==1){
				T2.login();//登陆操作
			}else if(n==2){
				T2.register();//注册操作
				operation1();
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
    		void usernamexist(String username)throws LoginException;
    		void Rusernamexist(String username)throws RegisterException;
    		void  passwordSame(String password,String password2)throws RegisterException;
            void register(String username, String password,String name, String email) throws RegisterException; //用户注册
            void login(String username, String password) throws LoginException;//用户登录
            }
            
        
   	class TUserBiz implements UserBiz{          //TUserBiz实现类
   	        
   	        public TUserBiz(User[] users){
   	        	User a=new User("admin","admin","Administrator","admin@123.com");
   	    		User b=new User("tom","cat","tomcat","tomcat@cat.com");
   	    		users[0]=a;
   	    		users[1]=b;
   	        }    
   	        
    		public  void register(String username, String password, String name, String email) throws RegisterException{
    			User c=new User(username,password,name,email);
    			for(int i=0;i<users.length;i++) {
    				if(users[i]==null) {
    					users[i]=c;
    					break;
    				}
    			} 
    			
    		 } //用户注册
    		 public void login(String username, String password) throws LoginException{
    			 for(int i=0;i<users.length;i++) {
    				 if(users[i]==null) {
    					continue; 
    				 }
    				 if(users[i].getUsername().equals(username)) {
    					 if(users[i].getPassword().equals(password)) {
    						 System.out.println("登陆成功");
    						 break;
    					 }else {
    						 throw new RegisterException("username和password不匹配");	 
    					 }					 
    				 }
    		         
    			 }
    			 
    				 /*if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password)) {
      					System.out.println("登陆成功！");
      					break;
      				}
     				if(!users[i].getUsername().equals(username)) {
     					throw new RegisterException("username不存在");
     				}
     				if(!users[i].getPassword().equals(password)) {
     					throw new RegisterException("username和password不匹配");
     				}*/	 

    		 } //用户登录
    		public void usernamexist(String username)throws LoginException{//判断用户是否存在
    			boolean usernamexist=false;
    			for(int i=0;i<users.length;i++) {
   				 if(users[i]==null) {
   					continue; 
   				 }	
   				 if(users[i].getUsername().equals(username)) {
   					usernamexist=true;
   				 }
    		}
    			if(usernamexist==false) {
    			throw new LoginException("username不存在");	
    			}
    	}	
    		
    	public void Rusernamexist(String username)throws RegisterException{//注册时判断用户是否存在
    		boolean Rusernamexist=true;
			for(int i=0;i<users.length;i++) {
				 if(users[i]==null) {
					continue; 
				 }	
				 if(users[i].getUsername().equals(username)) {
					 Rusernamexist=false;
					 break;
				 }
		}
			if(Rusernamexist==false) {
			throw new RegisterException("username已经存在");	
			}
    		
    }	
    	
    public void  passwordSame(String password,String password2)throws RegisterException{
    	if(!password.equals(password2)) {
    		throw new RegisterException("两次密码输入不一致");	
    	}
    }
    		
    		 
   }    	
    	interface UserView{
    		void login();
    		void register();
    	}
    	
     class TUserView implements UserView{
    		
    		public void login() {
    			Scanner s=new Scanner(System.in);
    			System.out.println("请输入用户名:");
    			String username=s.next();
    			T1.usernamexist(username);
    			System.out.println("请输入密码:");
    		    String password =s.next();   		     
    		    T1.login(username, password);
    		}
    		public void register() {
    			Scanner s=new Scanner(System.in);
    			System.out.println("请输入用户名:");
    			String username=s.next();
    			T1.Rusernamexist(username);
    			System.out.println("请输入密码:");
    		    String password =s.next(); 
    		    System.out.println("请确认密码:");
    		    String password2 =s.next(); 
    		    T1.passwordSame(password,password2);
    		    System.out.println("请输入真实姓名:");
    		    String name =s.next(); 
    		    System.out.println("请输入电子邮件:");
    		    String email =s.next(); 
    		    T1.register(username, password,name,email);
    		}
    	}
    	
	}
	
