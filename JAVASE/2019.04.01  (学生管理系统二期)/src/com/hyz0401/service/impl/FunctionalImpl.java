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

public class FunctionalImpl implements Functional {     //����һ�����������洢ѧ����Ϣ
	 //UserViewImpl u1=new UserViewImpl();
	 boolean x=false;
	   public  void CheckInfo(List<Student> student){                     //�鿴����ѧ����Ϣ
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
	public  void AddInfo(List<Student> student) {                             //���ѧ���ķ���
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		int stuid;
		while(true) {
			System.out.println("������ѧ�ţ�");
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
    	System.out.print("������ѧ���ɼ���"); 
    	int score1=scan.nextInt(); 
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
    	long add_date=System.currentTimeMillis();
		//����ѧ������
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
		//��ѧ��������ӵ�����
		for(int i=0;i<student.size();i++) {
				student.add(i,s);	
				break;
		}
		
		System.out.println("���ѧ���ɹ���");
		System.out.println("ϵͳ�Զ�������һ��......");
	}
	
	public  void DelInfo(List<Student> student) {        //ɾ��ѧ���ķ���
		Scanner scan= new Scanner(System.in);
		System.out.println("��������Ҫɾ����ѧ��ID:");
		int num=scan.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
			continue;	
			}
			if(student.get(i).getStuid()==num) {    //�ж������ѧ���Ƿ���������ȡ�������
				x=false;    //�ò������͵�һ���������ж������ѧ���Ƿ����
				System.out.println("��Ҫɾ����ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+student.get(i).getStuid()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getScore()+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddr()+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail());	
				System.out.println("��ȷ���Ƿ�ɾ��:       1.��                        2.��       "+"\n");
				System.out.print("������:");
				int num1=scan.nextInt();
				if(num1==1) {
					student.remove(i);
					System.out.println("ɾ���ɹ�");	
					break;
				}else if(num1==2) {
					System.out.println("ȡ���ɹ�");	
					break;
				}else {
					System.out.println("������ĺ������������������");
					DelInfo(student); 
					break;
				}
			}else {
				x=true;
			}
			
		}
		if(x==true) {
			System.out.println("��Ҫɾ����ѧ��������");	
			DelInfo(student);
		}
		
	}                                                  //ɾ��ѧ���������
	
	
	public  void AlterInfo(List<Student> student) {        //�޸�ѧ����Ϣ�ķ���
		
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
	
	public  void test1(List<Student> student) {              //�޸�ѧ��ȫ����Ϣ����
		Scanner scan= new Scanner(System.in);
		System.out.print("������ID��");	
		int t1=scan.nextInt();
		boolean x1=false;
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x1=false;
			if(student.get(i).getStuid()==t1) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+student.get(i).getStuid()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getScore()+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddr()+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail()+"\n");
				System.out.print("�������޸ĺ�ID��");	
				int a=scan.nextInt();
				student.get(i).setStuid(a);
				System.out.print("�������޸ĺ�Name��");
				String b=scan.next();
				student.get(i).setName(b);
				System.out.print("�������޸ĺ�Sex��");	
				String c=scan.next();
				student.get(i).setSex(c);
				System.out.print("�������޸ĺ�Score��");	
				int d=scan.nextInt();
				student.get(i).setAge(d);
				System.out.print("�������޸ĺ�Age��");	
				int n=scan.nextInt();
				student.get(i).setScore(n);
				System.out.print("�������޸ĺ�Grade��");	
				String e=scan.next();
				student.get(i).setGrade(e);
				System.out.print("�������޸ĺ�Addr��");
				String f=scan.next();
				student.get(i).setAddr(f);
				System.out.print("�������޸ĺ�Phone��");	
				String g=scan.next();
				student.get(i).setPhone(g);
				System.out.print("�������޸ĺ�Email��");	
				String h=scan.next();
				student.get(i).setEmail(h);
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
	
	
	public  void test2(List<Student> student) {              //�޸�ѧ��������Ϣ����
		
		Scanner scan= new Scanner(System.in);
		System.out.println("������ID��");	
		int t2=scan.nextInt();
		boolean x2=false;
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x2=false;
			if(student.get(i).getStuid()==t2) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+student.get(i).getStuid()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getScore()+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddr()+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail()+"\n");
				System.out.println("������Ҫ�޸ĵ����ԣ�");	 
				String t3=scan.next();
				System.out.println("�������޸ĺ��ֵ��");	 
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
	
	public void look(List<Student> student) {                                      //ѡ��鿴��ʽ����ѡ����Ҳ����ѡ����
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.�ɼ�����鿴"+"\t"+"2.�ɼ�����鿴"+"\t"+"3.������һ��"+"\t"+"*");
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		Scanner scan= new Scanner(System.in);
		System.out.print("��ѡ����Ҫ�鿴�ķ�ʽ:");
	    int n=scan.nextInt();
	    if(n==1) {
	    	System.out.println("\n"+ "--------------------------------------����ѧ����Ϣ����------------------------------------------" + "\n");
			System.out.println("\n"+ "حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح�ɼ�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"ح��ϵ��ʽ"+"\t"+"\t"+"ح����"+"\t"+"\t"+"حע��ʱ��");	 
			//��ѧ����Ϣ���ճɼ��Ӹߵ����������
			Collections.sort(student);          //�����ųɼ�

			   for(int i=0;i<student.size();i++) {
			    	if(student.get(i)!=null) {		
				System.out.print("\n"+"ح"+student.get(i).getStuid()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getScore()+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddr()+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail());	
				Date date=new Date(student.get(i).getAdd_date());
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println("\t" +format.format(date));
			    	}continue;
			    }
			    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");		    
			    System.out.println("�Զ�������һ��......");
			    CheckInfo(student);	
	    }else if(n==2) {
	    	System.out.println("\n"+ "--------------------------------------����ѧ����Ϣ����------------------------------------------" + "\n");
			System.out.println("\n"+ "حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح�ɼ�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"ح��ϵ��ʽ"+"\t"+"\t"+"ح����"+"\t"+"\t"+"حע��ʱ��");	 
			//��ѧ����Ϣ���ճɼ��Ӹߵ����������
			Collections.sort(student);  
			Collections.reverse(student);

			   for(int i=0;i<student.size();i++) {
			    	if(student.get(i)!=null) {		
				System.out.print("\n"+"ح"+student.get(i).getStuid()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getScore()+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddr()+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail());	
				Date date=new Date(student.get(i).getAdd_date());
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println("\t" +format.format(date));
			    	}continue;
			    }
			    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");		    
			    System.out.println("�Զ�������һ��......");
			    CheckInfo(student);	
	    }else if(n==3) {
	    //������һ��
	    }else {
	    	System.out.println("��������������ٴ�ѡ����Ҫ���еĲ���");
	    	look(student);
	    }
	}
}



