
/**
2019.3.23�ӿڣ����������֪ʶ�������
1.�ӿ�(interface)
2.������(abstract)
3.final
4.static
*/


public class TestInterface{
	public static void main(String[] argues){
		Dog a=new Dog();                          //ʹ���޲ι��췽������Dog����
		System.out.println(Dog.name+"\t"+"���䣺"+a.age);
		System.out.println("");
		Dog b=new Dog(9);                          //ʹ���в����Ĺ��췽������Dog����
		System.out.println(Dog.name+"\t"+"���䣺"+b.age+"\t"+"���ã�"+b.f1);
		b.run();
		System.out.println("");
	}
	
}

interface protectable{                    //�ӿ�
	public void fun1();
}
             
 
class Dog extends Animal implements protectable{                //Animal����Dog ��Ϊʵ�ֽӿڵķ���
	public static  String name="�ҳϵ�С��";
	public int age=5;
	String f1=super.hobby;
	public Dog(){
	}
	
	public Dog(int n){
		this.age=n;
	}
	
	public void run(){
		System.out.println("С�����ٱ���");
		
	}
	
	public void fun1(){
		System.out.println("ʵ���˽ӿ��еķ���");
	}
	
}

abstract class Animal{                  //������Animal  
	public static final String desc="С�����ڶ���";
	public String hobby="���Թ�ͷ";
	public abstract void run();
}