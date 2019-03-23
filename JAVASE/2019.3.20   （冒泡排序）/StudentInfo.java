import java.util.Scanner;
public class StudentInfo{
	
	public Long stunum;
	public String name;
	public int age;
	public String sex;
	public String grade;
	public String addr;
	
	public static void main(String[] argues){
		StudentInfo a=new StudentInfo();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入新建学生的学号：");
		a.stunum=scan.nextLong();
		System.out.println("请输入新建学生的姓名：");
		a.name=scan.next();
		System.out.println("请输入新建学生的年龄：");
		a.age=scan.nextInt();
		System.out.println("请输入新建学生的性别：");
		a.sex=scan.next();
		System.out.println("请输入新建学生的年级：");
		a.grade=scan.next();
		System.out.println("请输入新建学生的家庭住址：");
		a.addr=scan.next();
		scan.close();
		check(a);
	}
	
	public static void check(StudentInfo s){
		System.out.println("您新创建的学生信息如下："+ "\n"+"学号："+s.stunum+ "\n"+"姓名"+s.name+ "\n"+"年龄"+s.age+ "\n"+"性别"+s.sex+ "\n"+"年级"+s.grade+ "\n"+"家庭住址:"+s.addr);	
	}	
}