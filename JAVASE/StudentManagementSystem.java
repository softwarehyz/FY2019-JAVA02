import java.util.Scanner;
public class StudentManagementSystem{
	public static void main(String[] argues){
	
	welcome();                                //��ӭ����
	Admin[] admin= new Admin[3];              //����һ�����������洢ϵͳ�û�  
    InitData(admin);                          //�û������ʼ��
	operation1(admin);                        //ѡ���½�����˳�
    login(admin);                             //�û���½�����û���ݽ��н�����֤ 
	Student[] student=new Student[5];         //����һ�����������洢ѧ����Ϣ
	InitData1(student);
	operation2();                             //ѡ����β���ѧ����Ϣ
	}
	
	public static void welcome(){                        //��ӭ����
	System.out.println("\n"+"����������������������������ӭ��½ѧ������ϵͳ��������������������������" + "\n"+ "\n"  +"\t" +"\t"+ "1.��½" + "\t" +"\t"+"\t"+"\t"+ "2.�˳�" + "\n"+ "\n" + "������������������������������������������������������������������������");		
	}
	
	public static void operation1(Admin[] admin){                 //ѡ���½�����˳�
		Scanner scan = new Scanner(System.in);
	    System.out.print("��ѡ��");
		int n=scan.nextInt();
		if(n==1){
			//��½����
		}else if(n==2){
			System.exit(0);//�˳�����	
		}else{
			
			System.out.println("�����������������һ�ΰɣ�");
			operation1(admin);              //�ݹ����
		}
		
	}
	
	public static void InitData(Admin[] admin){                          //�����ʼ��
		Admin s=new Admin("admin","admin");
		admin[0]=s;
	}                                                                        
	
	
	public static void login(Admin[] admin){                  //��½����֤	
	System.out.println("\n"+ "����������������������������ӭ��½ ����֤��ݡ�������������������������" + "\n");	
    Scanner scan = new Scanner(System.in);
	System.out.print("�������û�����"); 
	String name=scan.nextLine(); 
	System.out.print("���������룺"); 
	String password=scan.nextLine(); 
	for(int i=0;i<admin.length;i++){
		if(admin[i]==null){                                 //�˴�������
			continue;
		}
		if(name.equals(admin[i].name)&&password.equals(admin[i].password)){
			System.out.println("\n"+ "����������������������������ӭ��½"+name+"��������������������������" + "\n");
			break;
		}else{	
			System.out.println("��֤���ʧ�ܣ�����������");
			login(admin);
		    }
		
	    }
	}	
	
	public static void operation2(){                     //ѡ����β���ѧ����Ϣ
	System.out.println("\n"+ "--------------------------------------��ѡ����Ҫ���еĲ���------------------------------------------" + "\n");
	System.out.println("*"+"\t"+"1.�鿴ѧ����Ϣ"+"\t"+"2.���ѧ����Ϣ"+"\t"+"3.ɾ��ѧ����Ϣ"+"\t"+"4.�޸�ѧ����Ϣ"+"\t"+"5.�˳�"+"\t"+"*");
	System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
	
	Scanner scan = new Scanner(System.in);
	System.out.print("�������Ӧ�����֣�");
	int select=scan.nextInt();
	switch(select){
	case 1:
	CheckInfo();//�鿴ѧ����Ϣ
	break;
	case 2:
	//���ѧ����Ϣ
	break;
	case 3:
	//ɾ��ѧ����Ϣ
	break;
	case 4:
	//�޸�ѧ����Ϣ
	break;
	case 5:
	System.exit(0);//�˳�
	break;
	default:
	System.out.println("\n"+"���꣬���������룡"+"\n");
	operation2();
	   }
	} 
	
	public static void InitData1(Student[] student){                          //�洢ѧ������ĳ�ʼ��
		Student s=new Student(2014,"������","��",25,"�߼�","ɽ��˷��","18434260817","1416949284@qq.con");
		student[0]=s;
	}           

    public static void CheckInfo(){                     //�鿴ѧ����Ϣ
		
			System.out.println("\n"+ "--------------------------------------����ѧ����Ϣ����------------------------------------------" + "\n");
			System.out.println("\n"+ "حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"\t"+"ح��ϵ��ʽ"+"\t"+"ح����"+ "\n");	
			System.out.println("\n"+"ح"+2014+"\t" +"ح������"+"ح��"+"\t"+"ح24"+"\t"+"ح�߼�"+"\t"+"حɽ��˷��"+"\t"+"ح18434260817"+"\t"+"ح1416949284@qq.com"+ "\n");	
		    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");
	}



	
}
	

class Admin{                                            //����Ա��
	public String name;
	public String password;
	
	public Admin(String name,String password){
		this.name=name;
		this.password=password;
	}
	
	public String getName(){                     
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
}

class Student{                                          //ѧ����
	public int stuid;
	public String name;
	public String sex;
	public int age;
	public String grade;
	public String addr;
	public String phone;
	public String email;
	
	public Student(int stuid,String name,String sex,int age,String grade,String addr,String phone,String email){
	this.stuid=stuid;
	this.name=name;
	this.sex=sex;
	this.age=age;
	this.grade=grade;
	this.addr=addr;
	this.phone=phone;
	this.email=email;
	}
	
	public int getStuid(){
		return stuid;
	}
	
	public void setStuid(int stuid){
		this.stuid=stuid;
	}
	
	public String getName(){                     
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getSex(){                     
		return sex;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public int getAge(){                     
		return age;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public String getGrade(){                     
		return grade;
	}
	
	public void setGrade(String grade){
		this.grade=grade;
	}
	
	public String getAddr(){                     
		return addr;
	}
	
	public void setAddr(String addr){
		this.addr=addr;
	}
	
	public String getPhone(){                     
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getEmail(){                     
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	
}