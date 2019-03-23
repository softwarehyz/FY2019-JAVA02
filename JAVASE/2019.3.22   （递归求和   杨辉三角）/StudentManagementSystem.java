import java.util.Scanner;
public class StudentManagementSystem{
	public static void main(String[] argues){
	
	welcome();                                //欢迎界面
	Admin[] admin= new Admin[3];              //定义一个数组用来存储系统用户  
    InitData(admin);                          //用户数组初始化
	operation1(admin);                        //选择登陆还是退出
    login(admin);                             //用户登陆并对用户身份进行进行验证 
	Student[] student=new Student[5];         //定义一个数组用来存储学生信息
	InitData1(student);
	operation2();                             //选择如何操作学生信息
	}
	
	public static void welcome(){                        //欢迎界面
	System.out.println("\n"+"·············欢迎登陆学生管理系统·············" + "\n"+ "\n"  +"\t" +"\t"+ "1.登陆" + "\t" +"\t"+"\t"+"\t"+ "2.退出" + "\n"+ "\n" + "····································");		
	}
	
	public static void operation1(Admin[] admin){                 //选择登陆还是退出
		Scanner scan = new Scanner(System.in);
	    System.out.print("请选择：");
		int n=scan.nextInt();
		if(n==1){
			//登陆操作
		}else if(n==2){
			System.exit(0);//退出操作	
		}else{
			
			System.out.println("少年别乱来，再输入一次吧！");
			operation1(admin);              //递归调用
		}
		
	}
	
	public static void InitData(Admin[] admin){                          //数组初始化
		Admin s=new Admin("admin","admin");
		admin[0]=s;
	}                                                                        
	
	
	public static void login(Admin[] admin){                  //登陆并验证	
	System.out.println("\n"+ "·············欢迎登陆 请验证身份·············" + "\n");	
    Scanner scan = new Scanner(System.in);
	System.out.print("请输入用户名："); 
	String name=scan.nextLine(); 
	System.out.print("请输入密码："); 
	String password=scan.nextLine(); 
	for(int i=0;i<admin.length;i++){
		if(admin[i]==null){                                 //此处有疑问
			continue;
		}
		if(name.equals(admin[i].name)&&password.equals(admin[i].password)){
			System.out.println("\n"+ "·············欢迎登陆"+name+"·············" + "\n");
			break;
		}else{	
			System.out.println("验证身份失败，请重新输入");
			login(admin);
		    }
		
	    }
	}	
	
	public static void operation2(){                     //选择如何操作学生信息
	System.out.println("\n"+ "--------------------------------------请选择您要进行的操作------------------------------------------" + "\n");
	System.out.println("*"+"\t"+"1.查看学生信息"+"\t"+"2.添加学生信息"+"\t"+"3.删除学生信息"+"\t"+"4.修改学生信息"+"\t"+"5.退出"+"\t"+"*");
	System.out.println("\n"+ "----------------------------------------------------------------------------------------------------" + "\n");
	
	Scanner scan = new Scanner(System.in);
	System.out.print("请输入对应的数字：");
	int select=scan.nextInt();
	switch(select){
	case 1:
	CheckInfo();//查看学生信息
	break;
	case 2:
	//添加学生信息
	break;
	case 3:
	//删除学生信息
	break;
	case 4:
	//修改学生信息
	break;
	case 5:
	System.exit(0);//退出
	break;
	default:
	System.out.println("\n"+"少年，请认真输入！"+"\n");
	operation2();
	   }
	} 
	
	public static void InitData1(Student[] student){                          //存储学生数组的初始化
		Student s=new Student(2014,"韩艳祖","男",25,"高级","山西朔州","18434260817","1416949284@qq.con");
		student[0]=s;
	}           

    public static void CheckInfo(){                     //查看学生信息
		
			System.out.println("\n"+ "--------------------------------------所有学生信息如下------------------------------------------" + "\n");
			System.out.println("\n"+ "丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"\t"+"丨联系方式"+"\t"+"丨邮箱"+ "\n");	
			System.out.println("\n"+"丨"+2014+"\t" +"丨韩艳祖"+"丨男"+"\t"+"丨24"+"\t"+"丨高级"+"\t"+"丨山西朔州"+"\t"+"丨18434260817"+"\t"+"丨1416949284@qq.com"+ "\n");	
		    System.out.println("\n"+ "------------------------------------------------------------------------------------------------" + "\n");
	}



	
}
	

class Admin{                                            //管理员类
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

class Student{                                          //学生类
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