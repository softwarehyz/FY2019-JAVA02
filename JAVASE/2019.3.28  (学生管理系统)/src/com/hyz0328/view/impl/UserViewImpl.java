package com.hyz0328.view.impl;
import java.util.Scanner;
import com.hyz0328.pojo.Student;
import com.hyz0328.pojo.User;
import com.hyz0328.service.impl.FunctionalImpl;
import com.hyz0328.view.UserView;

public class UserViewImpl implements UserView {
FunctionalImpl F1=new FunctionalImpl();
	
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
	
	
	public  void operation2(Student[] student,Student[] student1){                     //ѡ����β���ѧ����Ϣ
		System.out.println("\n"+ "--------------------------------------��ѡ����Ҫ���еĲ���------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.�鿴ѧ����Ϣ"+"\t"+"2.���ѧ����Ϣ"+"\t"+"3.ɾ��ѧ����Ϣ"+"\t"+"4.�޸�ѧ����Ϣ"+"\t"+"5.�˳�"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�������Ӧ�����֣�");
		int select=scan.nextInt();
		switch(select){
		case 1:
		F1.CheckInfo(student);//�鿴ѧ����Ϣ
		operation2(student,student1);
		break;
		case 2:
		F1.AddInfo(student);//���ѧ����Ϣ
		operation2(student,student1);
		break;
		case 3:
		F1.DelInfo(student,student1);//ɾ��ѧ����Ϣ
		operation2(student,student1);
		break;
		case 4:
		F1.AlterInfo(student);//�޸�ѧ����Ϣ
		operation2(student,student1);
		break;
		case 5:
		System.out.println("ϵͳ�˳��ɹ���");
		System.exit(0);//�˳�
		break;
		default:
		System.out.println("\n"+"���꣬���������룡"+"\n");
		operation2(student,student1);
		   }
		}
}
