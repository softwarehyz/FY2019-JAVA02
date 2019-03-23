
/**
2019.3.23多态相关知识代码测试
1.方法的重载与重写
2.类的继承
3.向上转型
4.super关键字
*/

public class testDT{
	
	public static void main(String[] argues){
		Cat a=new Cat();                          //新建一个Cat对象 测试该对象用于父类Animal的属性
		System.out.println (a.f1+"\t"+a.name+"\t"+a.f2+a.desc+"\t"+a.f3);
		a.run();
		
		System.out.println ("");
		
		Animal b=new Cat();                          //新建一个Cat对象 并将其向上转型为Animal类 进行测试
		
		System.out.println (b.hobby);  
        /*System.out.println (b.price+b.hobby);      
		本语句存在错误 b对象只能调用Animal类中的变量 无法调用Cat类中的对象 但调用方法时调用的是子类重写的父类中的方法，
        但是如果子类中没有该方法，只能向上调用父类中的方法
		*/          
		b.run();
		b.eat();
		System.out.println ("");
		
		Cat c=new Cat(1);        //使用不同构造方法新建一个Cat对象 测试该对象用于父类Animal的属性 使用this关键字
		System.out.println (c.f1+"\t"+c.name+"\t"+c.f2+c.desc+"\t"+c.f3);
		c.run();
		
		System.out.println ("");
	}
	 
}

class Cat extends Animal{                                              //猫类
	public String name="可爱的小猫";
	public String desc="人类的小棉袄";
	public String price="小猫50元";
	String f1=super.name;                                             //子类中访问父类的属性
	String f2=super.desc;
	String f3=super.hobby;
	public Cat(){
		System.out.println("我是子类：Cat类");
	}
	
	public Cat(int n){
		System.out.println("我是子类：Cat类");
		this.name="我是一只有参数的可爱的猫";
	}
	
	public void run(){
		System.out.println("小猫是优雅地跑");
	}
	
}

class Animal{                                           //动物类
	public String name="自然界的动物";
	public String desc="大自然的好朋友";
	public String hobby="动物都爱吃";
	public  Animal(){
		System.out.println("我是父类：Animal类");
	}
	public void run(){
		System.out.println("动物那跑的姿势各种都有");
	}
	public void eat(){
		System.out.println("这个方法只有我Animal类中有，只能调用我的");
	}
	
}