
/**
2019.3.23��̬���֪ʶ�������
1.��������������д
2.��ļ̳�
3.����ת��
4.super�ؼ���
*/

public class testDT{
	
	public static void main(String[] argues){
		Cat a=new Cat();                          //�½�һ��Cat���� ���Ըö������ڸ���Animal������
		System.out.println (a.f1+"\t"+a.name+"\t"+a.f2+a.desc+"\t"+a.f3);
		a.run();
		
		System.out.println ("");
		
		Animal b=new Cat();                          //�½�һ��Cat���� ����������ת��ΪAnimal�� ���в���
		
		System.out.println (b.hobby);  
        /*System.out.println (b.price+b.hobby);      
		�������ڴ��� b����ֻ�ܵ���Animal���еı��� �޷�����Cat���еĶ��� �����÷���ʱ���õ���������д�ĸ����еķ�����
        �������������û�и÷�����ֻ�����ϵ��ø����еķ���
		*/          
		b.run();
		b.eat();
		System.out.println ("");
		
		Cat c=new Cat(1);        //ʹ�ò�ͬ���췽���½�һ��Cat���� ���Ըö������ڸ���Animal������ ʹ��this�ؼ���
		System.out.println (c.f1+"\t"+c.name+"\t"+c.f2+c.desc+"\t"+c.f3);
		c.run();
		
		System.out.println ("");
	}
	 
}

class Cat extends Animal{                                              //è��
	public String name="�ɰ���Сè";
	public String desc="�����С�ް�";
	public String price="Сè50Ԫ";
	String f1=super.name;                                             //�����з��ʸ��������
	String f2=super.desc;
	String f3=super.hobby;
	public Cat(){
		System.out.println("�������ࣺCat��");
	}
	
	public Cat(int n){
		System.out.println("�������ࣺCat��");
		this.name="����һֻ�в����Ŀɰ���è";
	}
	
	public void run(){
		System.out.println("Сè�����ŵ���");
	}
	
}

class Animal{                                           //������
	public String name="��Ȼ��Ķ���";
	public String desc="����Ȼ�ĺ�����";
	public String hobby="���ﶼ����";
	public  Animal(){
		System.out.println("���Ǹ��ࣺAnimal��");
	}
	public void run(){
		System.out.println("�������ܵ����Ƹ��ֶ���");
	}
	public void eat(){
		System.out.println("�������ֻ����Animal�����У�ֻ�ܵ����ҵ�");
	}
	
}