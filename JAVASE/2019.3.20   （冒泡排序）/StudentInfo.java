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
		System.out.println("�������½�ѧ����ѧ�ţ�");
		a.stunum=scan.nextLong();
		System.out.println("�������½�ѧ����������");
		a.name=scan.next();
		System.out.println("�������½�ѧ�������䣺");
		a.age=scan.nextInt();
		System.out.println("�������½�ѧ�����Ա�");
		a.sex=scan.next();
		System.out.println("�������½�ѧ�����꼶��");
		a.grade=scan.next();
		System.out.println("�������½�ѧ���ļ�ͥסַ��");
		a.addr=scan.next();
		scan.close();
		check(a);
	}
	
	public static void check(StudentInfo s){
		System.out.println("���´�����ѧ����Ϣ���£�"+ "\n"+"ѧ�ţ�"+s.stunum+ "\n"+"����"+s.name+ "\n"+"����"+s.age+ "\n"+"�Ա�"+s.sex+ "\n"+"�꼶"+s.grade+ "\n"+"��ͥסַ:"+s.addr);	
	}	
}