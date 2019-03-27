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
	
	public static void welcome(){                        //��ӭ����
		System.out.println("\n"+"����������������������������ӭʹ�ñ�ϵͳϵͳ��������������������������" + "\n"+ "\n"  +"\t" +"\t"+ "1.��½" + "\t" +"\t"+ "2.ע��"+"\t"+"\t"+"3.�˳�" + "\n"+ "\n" + "������������������������������������������������������������������������"+ "\n");		
		}
		public static void operation1(){                                     //ѡ���½�����˳�
			                                   		
			Scanner scan = new Scanner(System.in);
		    System.out.print("��ѡ��");
			int n=scan.nextInt();
			if(n==1){
				T2.login();//��½����
			}else if(n==2){
				T2.register();//ע�����
				operation1();
			}else if(n==3){
				System.exit(0);//�˳�����	
			}else{
				
				System.out.println("�����������������һ�ΰɣ�");
				operation1();              //�ݹ����
			}
			
		}
	
	class User{                                      //�û���
		public String username;
		public String password;
		public String name;
		public String email;
		
		public User() {                 //�޲������췽��
			
		}
		public User(String username,String password,String name,String email) {    //�в������췽��
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
	
	class LoginException extends RuntimeException{  //LoginException�쳣��
		
		public LoginException(){
			
		}
		
        public LoginException(String msg){
			super(msg);
		}
	}   
        
    class RegisterException extends RuntimeException{  //RegisterException�쳣��
    		
    		public RegisterException(){
    			
    		}
    		
            public RegisterException(String msg){
    			super(msg);
    		}
		
    	}     
        
   
    	interface UserBiz {            //UserBiz�ӿ�
    		void usernamexist(String username)throws LoginException;
    		void Rusernamexist(String username)throws RegisterException;
    		void  passwordSame(String password,String password2)throws RegisterException;
            void register(String username, String password,String name, String email) throws RegisterException; //�û�ע��
            void login(String username, String password) throws LoginException;//�û���¼
            }
            
        
   	class TUserBiz implements UserBiz{          //TUserBizʵ����
   	        
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
    			
    		 } //�û�ע��
    		 public void login(String username, String password) throws LoginException{
    			 for(int i=0;i<users.length;i++) {
    				 if(users[i]==null) {
    					continue; 
    				 }
    				 if(users[i].getUsername().equals(username)) {
    					 if(users[i].getPassword().equals(password)) {
    						 System.out.println("��½�ɹ�");
    						 break;
    					 }else {
    						 throw new RegisterException("username��password��ƥ��");	 
    					 }					 
    				 }
    		         
    			 }
    			 
    				 /*if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password)) {
      					System.out.println("��½�ɹ���");
      					break;
      				}
     				if(!users[i].getUsername().equals(username)) {
     					throw new RegisterException("username������");
     				}
     				if(!users[i].getPassword().equals(password)) {
     					throw new RegisterException("username��password��ƥ��");
     				}*/	 

    		 } //�û���¼
    		public void usernamexist(String username)throws LoginException{//�ж��û��Ƿ����
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
    			throw new LoginException("username������");	
    			}
    	}	
    		
    	public void Rusernamexist(String username)throws RegisterException{//ע��ʱ�ж��û��Ƿ����
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
			throw new RegisterException("username�Ѿ�����");	
			}
    		
    }	
    	
    public void  passwordSame(String password,String password2)throws RegisterException{
    	if(!password.equals(password2)) {
    		throw new RegisterException("�����������벻һ��");	
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
    			System.out.println("�������û���:");
    			String username=s.next();
    			T1.usernamexist(username);
    			System.out.println("����������:");
    		    String password =s.next();   		     
    		    T1.login(username, password);
    		}
    		public void register() {
    			Scanner s=new Scanner(System.in);
    			System.out.println("�������û���:");
    			String username=s.next();
    			T1.Rusernamexist(username);
    			System.out.println("����������:");
    		    String password =s.next(); 
    		    System.out.println("��ȷ������:");
    		    String password2 =s.next(); 
    		    T1.passwordSame(password,password2);
    		    System.out.println("��������ʵ����:");
    		    String name =s.next(); 
    		    System.out.println("����������ʼ�:");
    		    String email =s.next(); 
    		    T1.register(username, password,name,email);
    		}
    	}
    	
	}
	
