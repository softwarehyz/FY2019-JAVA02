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
	public void welcome(){                        //��ӭ����
		System.out.println("\n"+"����������������������������ӭ��½ѧ������ϵͳ��������������������������" + "\n"+ "\n"  +"\t" +"\t"+ "1.��½" + "\t" +"\t"+"\t"+"\t"+ "2.�˳�" + "\n"+ "\n" + "������������������������������������������������������������������������"+ "\n");		
		}
	
	public  void operation1(){                 //ѡ���½�����˳�
		User[] User= new User[3];              //����һ�����������洢ϵͳ�û�  
		User s=new User("admin","admin");
		User[0]=s;
		Scanner scan = new Scanner(System.in);
	    System.out.print("��ѡ��");
		int n=scan.nextInt();
		if(n==1){
			login(User);//��½����
		}else if(n==2){
			System.out.println("ϵͳ�˳��ɹ���");
			System.exit(0);//�˳�����	
		}else{
			
			System.out.println("�����������������һ�ΰɣ�");
			operation1();              //�ݹ����
		}
		
	}
	
	
	public  void login(User[] user){                  //��½����֤	
		System.out.println("\n"+ "����������������������������ӭ��½ ����֤��ݡ�������������������������" + "\n");	
	    Scanner scan = new Scanner(System.in);
		System.out.print("�������û�����"); 
		String name=scan.nextLine(); 
		System.out.print("���������룺"); 
		String password=scan.nextLine(); 
		testt() ;
		for(int i=0;i<user.length;i++){
			if(user[i]==null){                                 //�˴�������
				continue;
			}
			if(name.equals(user[i].name)&&password.equals(user[i].password)){
				System.out.println("\n"+ "����������������������������ӭ��½"+"\t"+name+"��������������������������" + "\n");
				break;
			}else{	
				System.out.println("��֤���ʧ�ܣ�����������");
				login(user);
			    }
		    }	
			
			
		
	}
	
	public  void operation2(/*List<Student> student*/){                     //ѡ����β���ѧ����Ϣ
		System.out.println("\n"+ "--------------------------------------��ѡ����Ҫ���еĲ���------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.�鿴ѧ����Ϣ"+"\t"+"2.���ѧ����Ϣ"+"\t"+"3.ɾ��ѧ����Ϣ"+"\t"+"4.�޸�ѧ����Ϣ"+"\t"+"5.�˳�"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�������Ӧ�����֣�");
		int select=scan.nextInt();
		switch(select){
		case 1:
		F2.CheckInfo(/*student*/);//�鿴ѧ����Ϣ
		operation2(/*student*/);
		break;
		case 2:
		F2.AddInfo(/*student*/);//���ѧ����Ϣ
		operation2(/*student*/);
		break;
		case 3:
		F2.DelInfo(/*student*/);//ɾ��ѧ����Ϣ
		operation2(/*student*/);
		break;
		case 4:
		F2.AlterInfo(/*student*/);//�޸�ѧ����Ϣ
		operation2(/*student*/);
		break;
		case 5:
		System.out.println("ϵͳ�˳��ɹ���");
		System.exit(0);//�˳�
		break;
		default:
		System.out.println("\n"+"���꣬���������룡"+"\n");
		operation2(/*student*/);
		   }
		}
	
	
	public static boolean VerificationCode() {         //��֤��У��
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//��������0-9 �� ��Сд��ĸ
		char[] ch = new char[4]; //����һ���ַ��������ch ���� ��֤��
		for (int i = 0; i < 4; i++) {
			Random random = new Random();//����һ���µ������������
			int index = random.nextInt(string.length());//����[0,string.length)��Χ��intֵ    ���ã������±�
			ch[i] = string.charAt(index);//charAt() : ����ָ���������� char ֵ   ==�����浽�ַ��������ch����
		}
		//��char��������ת��ΪString���ͱ��浽result
		//String result = new String(ch);//����һ��ֱ��ʹ�ù��췽��      String(char[] value) ������һ���µ� String��ʹ���ʾ�ַ���������е�ǰ�������ַ����С�
		String result = String.valueOf(ch);//�������� String����   valueOf(char c) ������ char �������ַ�����ʾ��ʽ��
		System.out.print("��֤�룺");
		System.out.println(result);
		Scanner scan=new Scanner(System.in);
		System.out.println("��������֤��(�����ִ�Сд)��");
		String s=scan.next();
		if(s.equalsIgnoreCase(result)) {
			//System.out.println("��֤�ɹ�");
			return true;
		}else {
			//System.out.println("��֤ʧ��");
			return false;
		}
	}
	
	public static void testt() {
		if(!VerificationCode() ) {
			System.out.println("��֤���������������");
			testt();
		}
	}
	
}