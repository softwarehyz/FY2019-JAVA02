
/**
2019.3.23接口，抽象类相关知识代码测试
1.接口(interface)
2.抽象类(abstract)
3.final
4.static
*/


public class TestInterface{
	public static void main(String[] argues){
		Dog a=new Dog();                          //使用无参构造方法构造Dog对象
		System.out.println(Dog.name+"\t"+"年龄："+a.age);
		System.out.println("");
		Dog b=new Dog(9);                          //使用有参数的构造方法构造Dog对象
		System.out.println(Dog.name+"\t"+"年龄："+b.age+"\t"+"爱好："+b.f1);
		b.run();
		System.out.println("");
	}
	
}

interface protectable{                    //接口
	public void fun1();
}
             
 
class Dog extends Animal implements protectable{                //Animal子类Dog 作为实现接口的方法
	public static  String name="忠诚的小狗";
	public int age=5;
	String f1=super.hobby;
	public Dog(){
	}
	
	public Dog(int n){
		this.age=n;
	}
	
	public void run(){
		System.out.println("小狗快速奔跑");
		
	}
	
	public void fun1(){
		System.out.println("实现了接口中的方法");
	}
	
}

abstract class Animal{                  //抽象父类Animal  
	public static final String desc="小狗属于动物";
	public String hobby="爱吃骨头";
	public abstract void run();
}