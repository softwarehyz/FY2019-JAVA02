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
	private List<Student> student=new ArrayList<Student>();         //����һ�����������洢ѧ����Ϣ
	 
	private FunctionalImpl() {
		Student s=new Student(2014,"������","��",88,25,"�߼�","ɽ��˷��","18434260817","14169@qq.cn",1554132344000L);
		Student s1=new Student(2015,"ε��","��",99,25,"�м�","ɽ��˷��","18434260834","84589@qq.cn",1557132334000L);
		Student s2=new Student(2016,"��һ��","��",66,25,"�ͼ�","ɽ��˷��","18434260821","84529@qq.cn",1558132394000L);
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
	   //public  void CheckInfo(/*List<Student> student*/){                     //�鿴����ѧ����Ϣ
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
	    
	public  void AddInfo(/*List<Student> student*/) {                             //���ѧ���ķ���
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
	    int stuid=0;
			System.out.println("������ѧ�ţ�");
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
				System.out.println("��������˺ű�ռ�ã�����");
				AddInfo();
			}
			if(!flag) {
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
        String s1=choice();
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
		s.setGrade(s1);
		s.setAddr(addr1);
		s.setPhone(phone1);
		s.setEmail(email1);
		s.setAdd_date(add_date);
		//��ѧ��������ӵ�����
		student.add(s);	
		System.out.println("���ѧ���ɹ���");
		System.out.println("ϵͳ�Զ�������һ��......");
	   }
	}	
	public  void DelInfo(/*List<Student> student*/) {        //ɾ��ѧ���ķ���
				Scanner scan= new Scanner(System.in);
				System.out.println("��������Ҫɾ����ѧ��ID:");
				int num=scan.nextInt();
				Student str=testFind1(num);   //���ֲ����ж�ѧ���Ƿ����
				if(str!=null) {
				System.out.println("��Ҫɾ����ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+str.getStuid()+"\t" +"ح"+str.getName()+"\t"+"ح"+str.getSex()+"\t"+"ح"+str.getScore()+"\t"+"ح"+str.getAge()+"\t"+"ح"+str.getGrade()+"\t"+"ح"+str.getAddr()+"\t"+"ح"+str.getPhone()+"\t"+"ح"+str.getEmail());	
				System.out.println("��ȷ���Ƿ�ɾ��:       1.��                        2.��       "+"\n");
				System.out.print("������:");
				int num1=scan.nextInt();
				if(num1==1) {
					student.remove(str);
					System.out.println("ɾ���ɹ�");	
				}else if(num1==2) {
					System.out.println("ȡ���ɹ�");	
				}else {
					System.out.println("������ĺ������������������");
					DelInfo(/*student*/); 
				 }
             }     
		}                                            //ɾ��ѧ���������
	
	
	public  void AlterInfo(/*List<Student> student*/) {        //�޸�ѧ����Ϣ�ķ���
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.����ID�޸�ѧ��ȫ����Ϣ"+"\t"+"2.����ID�޸�ѧ��������Ϣ"+"\t"+"3.�����ϼ�Ŀ¼"+"\t"+"4.��   ��"+"\t"+"*");
		System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
		System.out.print("��������Ҫ���еĲ���");	
		Scanner scan= new Scanner(System.in);
		int t=scan.nextInt();
		if(t==1) {               //����ID�޸�ѧ��ȫ����Ϣ
		test1(/*student*/);
		}else if(t==2) {
		test2(/*student*/);	    //����ID�޸�ѧ��������Ϣ
		}else if(t==3) {
		//operation2(student);    //�����ϼ�Ŀ¼
		}else if(t==4){
		System.out.println("ϵͳ�˳��ɹ���");
		System.exit(0);//�˳�
		}else {
			System.out.println("�����������������һ�ΰɣ�");	
			AlterInfo(/*student*/);
		}
	}
	
	public  void test1(/*List<Student> student*/) {              //�޸�ѧ��ȫ����Ϣ����
		Scanner scan= new Scanner(System.in);
		System.out.print("������ID��");	
		int t1=scan.nextInt();
		Student str2=testFind3(t1);
		if(str2!=null) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+str2.getStuid()+"\t" +"ح"+str2.getName()+"\t"+"ح"+str2.getSex()+"\t"+"ح"+str2.getScore()+"\t"+"ح"+str2.getAge()+"\t"+"ح"+str2.getGrade()+"\t"+"ح"+str2.getAddr()+"\t"+"ح"+str2.getPhone()+"\t"+"ح"+str2.getEmail()+"\n");
				System.out.print("�������޸ĺ�ID��");	
				int a=scan.nextInt();
				str2.setStuid(a);
				System.out.print("�������޸ĺ�Name��");
				String b=scan.next();
				str2.setName(b);
				System.out.print("�������޸ĺ�Sex��");	
				String c=scan.next();
				str2.setSex(c);
				System.out.print("�������޸ĺ�Score��");	
				int d=scan.nextInt();
				str2.setAge(d);
				System.out.print("�������޸ĺ�Age��");	
				int n=scan.nextInt();
				str2.setScore(n);
				System.out.print("�������޸ĺ�Grade��");	
				String e=scan.next();
				str2.setGrade(e);
				System.out.print("�������޸ĺ�Addr��");
				String f=scan.next();
				str2.setAddr(f);
				System.out.print("�������޸ĺ�Phone��");	
				String g=scan.next();
				str2.setPhone(g);
				System.out.print("�������޸ĺ�Email��");	
				String h=scan.next();
				str2.setEmail(h);
		//u1.operation2(student);
	   }
		System.out.println("�޸ĳɹ����Զ�������һ��......");
		AlterInfo(/*student*/);
    }	
	public  void test2(/*List<Student> student*/) {              //�޸�ѧ��������Ϣ����
		
		Scanner scan= new Scanner(System.in);
		System.out.println("������ID��");	
		int t2=scan.nextInt();
		        Student str1=testFind2(t2);
		        if(str1!=null) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("\n"+"ح"+str1.getStuid()+"\t" +"ح"+str1.getName()+"\t"+"ح"+str1.getSex()+"\t"+"ح"+str1.getScore()+"\t"+"ح"+str1.getAge()+"\t"+"ح"+str1.getGrade()+"\t"+"ح"+str1.getAddr()+"\t"+"ح"+str1.getPhone()+"\t"+"ح"+str1.getEmail()+"\n");
				System.out.println("������Ҫ�޸ĵ����ԣ�");	 
				String t3=scan.next();
				System.out.println("�������޸ĺ��ֵ��");	 
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
		System.out.println("�޸ĳɹ����Զ�������һ��......");
		AlterInfo(/*student*/);
	}
	
	public void look(/*List<Student> student*/) {   //ѡ��鿴��ʽ����ѡ����Ҳ����ѡ����
		
		System.out.println("\n"+ "-------------------------------------------------------------------------------------------" + "\n");
		System.out.println("*"+"\t"+"1.�ɼ�����鿴"+"\t"+"2.�ɼ�����鿴"+"\t"+"3.ID��ѯѧ��"+"\t"+"4.������һ��"+"\t"+"*");
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
			    look(/*student*/);	
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
				    look(/*student*/);	
	    }else if(n==3) {
	    	findStudent() ;
	    }else if(n==4) {
	        //������һ��
	    }else {
	    	System.out.println("��������������ٴ�ѡ����Ҫ���еĲ���");
	    	look(/*student*/);
	    }
	}

	
	public  Student testFind(int c) {   //��ID���ֲ��Ҷ�Ӧѧ��
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
	    	System.out.println("��Ҫ���ҵ�ѧ�������ڣ���");
	    	findStudent();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//���ֲ���(���ڲ鿴)
	
	public  Student testFind1(int c) {   //��ID����ɾ����Ӧѧ��
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
	    	System.out.println("��Ҫ���ҵ�ѧ�������ڣ���");
	    	DelInfo();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//���ֲ���(����ɾ��ѧ��)
	
	public  Student testFind2(int c) {   //��ID�����޸�ѧ����������
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
	    	System.out.println("��Ҫ���ҵ�ѧ�������ڣ���");
	    	test2();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//���ֲ���(�����޸�ѧ����������)
	
	
	public  Student testFind3(int c) {   //��ID�����޸�ѧ��ȫ������
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
	    	System.out.println("��Ҫ���ҵ�ѧ�������ڣ���");
	    	test1();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	//���ֲ���(�����޸�ѧ��ȫ������)
	
    public  String choice() {                                        //ö������ѡ���꼶
    	Scanner scan= new Scanner(System.in);
    	System.out.println("ѧ�������꼶��1.�߼�      2.�м�      3.����"); 
    	System.out.print("��ѡ��:"); 
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
    		System.out.println("ѡ������������ѡ��");
    		choice();
          }
        return "";
     }
    
    public void findStudent() {
    	Scanner scan1= new Scanner(System.in);
		System.out.print("����ѧ��ID:");
	    int f=scan1.nextInt();	
    	Student s5=testFind(f);
    	if(s5!=null) {
    	System.out.println("��Ҫ��ѯ��ѧ����Ϣ����:");	
		System.out.println("\n"+"ح"+s5.getStuid()+"\t" +"ح"+s5.getName()+"\t"+"ح"+s5.getSex()+"\t"+"ح"+s5.getScore()+"\t"+"ح"+s5.getAge()+"\t"+"ح"+s5.getGrade()+"\t"+"ح"+s5.getAddr()+"\t"+"ح"+s5.getPhone()+"\t"+"ح"+s5.getEmail()+"\n");
		System.out.println("�Զ�������һ��......");
		look(/*student*/);	
        }
    }  
}
