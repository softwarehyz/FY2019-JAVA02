package com.hyz0328.service.impl;

import java.util.Scanner;

import com.hyz0328.pojo.Student;
import com.hyz0328.service.Functional;
import com.hyz0328.view.impl.UserViewImpl;


public class FunctionalImpl implements Functional {     //����һ�����������洢ѧ����Ϣ
	
	 //UserViewImpl u1=new UserViewImpl();
	 boolean x=false;
	   public  void CheckInfo(Student[] student){                     //�鿴����ѧ����Ϣ
    	System.out.println("\n"+ "--------------------------------------����ѧ����Ϣ����------------------------------------------" + "\n");
		System.out.println("\n"+ "حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"ح��ϵ��ʽ"+"\t"+"\t"+"ح����");	    	
		    for(int i=0;i<student.length;i++) {
		    	if(student[i]!=null) {		
			System.out.println("\n"+"ح"+student[i].getStuid()+"\t" +"ح"+student[i].getName()+"\t"+"ح"+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"+student[i].getAddr()+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail());	
		    	}continue;
		 
		    }
		    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");	
	   }	    
	
	
	public  void AddInfo(Student[] student) {                             //���ѧ���ķ���
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		int stuid;
		while(true) {
			System.out.println("������ѧ�ţ�");
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
				System.out.println("��������˺ű�ռ�ã�����");
			}else {
				
				break;
			}
		}
		System.out.print("������ѧ��������"); 
    	String name1=scan.next();
    	scan.nextLine();
    	System.out.print("������ѧ���Ա�"); 
    	String sex1=scan.next(); 
    	scan.nextLine();
    	System.out.print("������ѧ������(ֻ��1-120֮�������)��"); 
    	int age1=scan.nextInt(); 
    	scan.nextLine();
    	System.out.print("������ѧ�������꼶(ֻ�ܳ������м����߼�)��"); 
    	String grade1=scan.next(); 
    	scan.nextLine();
    	System.out.print("������ѧ����ַ��"); 
    	String addr1=scan.next();
    	scan.nextLine();
    	System.out.print("������ѧ����ϵ��ʽ��"); 
    	String phone1=scan.next(); 
    	scan.nextLine();
    	System.out.print("������ѧ���������䣺"); 
    	String email1=scan.next(); 
    	scan.nextLine();
		//����ѧ������
		Student s = new Student();
		s.setStuid(stuid);
		s.setName(name1);
		s.setSex(sex1);
		s.setAge(age1);
		s.setGrade(grade1);
		s.setAddr(addr1);
		s.setPhone(phone1);
		s.setEmail(email1);
		//��ѧ��������ӵ�����
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				student[i]=s;	
				break;
			}
		}
		
		System.out.println("���ѧ���ɹ���");
		System.out.println("ϵͳ�Զ�������һ��......");
	}
	
	public  void DelInfo(Student[] student,Student[] student1) {        //ɾ��ѧ���ķ���
		Scanner scan= new Scanner(System.in);
		System.out.println("��������Ҫɾ����ѧ��ID:");
		int num=scan.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
			continue;	
			}
			if(student[i].getStuid()==num) {    //�ж������ѧ���Ƿ���������ȡ�������
				x=false;    //�ò������͵�һ���������ж������ѧ���Ƿ����
				System.out.println("��Ҫɾ����ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+student[i].getStuid()+"\t" +"ح"+student[i].getName()+"\t"+"ح"+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"+student[i].getAddr()+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail());	
				System.out.println("��ȷ���Ƿ�ɾ��:       1.��                        2.��       "+"\n");
				System.out.print("������:");
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
					System.out.println("ɾ���ɹ�");	
					break;
				}else if(num1==2) {
					System.out.println("ȡ���ɹ�");	
					break;
				}else {
					System.out.println("������ĺ������������������");
					DelInfo(student,student1); 
					break;
				}
			}else {
				x=true;
			}
			
		}
		if(x==true) {
			System.out.println("��Ҫɾ����ѧ��������");	
			DelInfo(student,student1);
		}
		
	}                                                  //ɾ��ѧ���������
	
	
	public  void AlterInfo(Student[] student) {        //�޸�ѧ����Ϣ�ķ���
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.����ID�޸�ѧ��ȫ����Ϣ"+"\t"+"2.����ID�޸�ѧ��������Ϣ"+"\t"+"3.�����ϼ�Ŀ¼"+"\t"+"4.��   ��"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		System.out.print("��������Ҫ���еĲ���");	
		Scanner scan= new Scanner(System.in);
		int t=scan.nextInt();
		if(t==1) {                                            //����ID�޸�ѧ��ȫ����Ϣ
		test1(student);
		}else if(t==2) {
		test2(student);	    //����ID�޸�ѧ��������Ϣ
		}else if(t==3) {
		//operation2(student);    //�����ϼ�Ŀ¼
		}else if(t==4){
		System.out.println("ϵͳ�˳��ɹ���");
		System.exit(0);//�˳�
		}else {
			System.out.println("�����������������һ�ΰɣ�");	
			AlterInfo(student);
		}
	}
	
	public  void test1(Student[] student) {              //�޸�ѧ��ȫ����Ϣ����
		Scanner scan= new Scanner(System.in);
		System.out.print("������ID��");	
		int t1=scan.nextInt();
		boolean x1=false;
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x1=false;
			if(student[i].getStuid()==t1) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+student[i].getStuid()+"\t" +"ح"+student[i].getName()+"\t"+"ح"+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"+student[i].getAddr()+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail()+"\n");
				System.out.print("�������޸ĺ�ID��");	
				int a=scan.nextInt();
				student[i].setStuid(a);
				System.out.print("�������޸ĺ�Name��");
				String b=scan.next();
				student[i].setName(b);
				System.out.print("�������޸ĺ�Sex��");	
				String c=scan.next();
				student[i].setSex(c);
				System.out.print("�������޸ĺ�Age��");	
				int d=scan.nextInt();
				student[i].setAge(d);
				System.out.print("�������޸ĺ�Grade��");	
				String e=scan.next();
				student[i].setGrade(e);
				System.out.print("�������޸ĺ�Addr��");
				String f=scan.next();
				student[i].setAddr(f);
				System.out.print("�������޸ĺ�Phone��");	
				String g=scan.next();
				student[i].setPhone(g);
				System.out.print("�������޸ĺ�Email��");	
				String h=scan.next();
				student[i].setEmail(h);
				System.out.println("�޸ĳɹ����Զ�������һ��......");
				AlterInfo(student);
				break;	
			}else {
				x1=true;
			}
	
		}
		if(x1==true) {
			System.out.println("�������ID�����ڣ�����������!!!");
			test1(student);
		}
		
		//u1.operation2(student);
	}
	
	
	public  void test2(Student[] student) {              //�޸�ѧ��������Ϣ����
		
		Scanner scan= new Scanner(System.in);
		System.out.println("������ID��");	
		int t2=scan.nextInt();
		boolean x2=false;
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x2=false;
			if(student[i].getStuid()==t2) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+student[i].getStuid()+"\t" +"ح"+student[i].getName()+"\t"+"ح"+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"+student[i].getAddr()+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail()+"\n");
				System.out.println("������Ҫ�޸ĵ����ԣ�");	 
				String t3=scan.next();
				System.out.println("�������޸ĺ��ֵ��");	 
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
				System.out.println("�޸ĳɹ����Զ�������һ��......");
				AlterInfo(student);
				break;	
			}else {
				x2=true;
			}
	
		}
		if(x2==true) {
		System.out.println("�������ID������!!!");
		test2(student);
		}
	}
	
	

}
