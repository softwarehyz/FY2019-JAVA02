package com.hyz0330;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //字符串长度不可改变
		byte[] b= {1,2,3};
		String s=new String(b);
		System.out.println(s);
		
		String s1=new String("abc");
		String s2=new String("abc");
		System.out.println(s1==s2);   //false
		System.out.println(s1.equals(s2)); //true String重写了equals
	     
		/*常量会存在常量区，JVM针对常量区做了一定的优化，
		 * 如果新建的字符串常量是已经存在的，
		那么它指向的就是常量区中已经有的，如果没有再为他分配空间，重新存储
		**/
	     String s3="abcd";
	     String s4="abcd";
	     System.out.println("s3字符串"+s3);   
	     System.out.println("s4字符串"+s3);   
	     System.out.println("用==判断s3s4是否相等"+s3==s4);   //true
		 System.out.println("用equals方法判断s3s4是否相等"+s3.equals(s4));//true
		 System.out.println("字符串拼接："+s3.concat(s4));//true
		 System.out.println("s3字符串用charAt()方法取下标为2的值"+s3.charAt(2));   
		 System.out.println("s3字符串"+s3.getBytes());  
		 
		 StringBuffer s5=new StringBuffer(s3);
		 s5.append("fuk");
		 System.out.println(s5);   
		 StringBuffer s6=s5.insert(3, "love");
		 System.out.println(s6);  
		 StringBuffer s7=s6.reverse();
		 System.out.println(s7);  
		 for(int i=0;i<10;i++) {
			 System.out.println((int)(Math.random()*10+10));   //double强转int
		 }
		 
	}
	
	
	
	

}
