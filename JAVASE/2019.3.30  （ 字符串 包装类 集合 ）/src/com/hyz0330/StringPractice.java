package com.hyz0330;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //�ַ������Ȳ��ɸı�
		byte[] b= {1,2,3};
		String s=new String(b);
		System.out.println(s);
		
		String s1=new String("abc");
		String s2=new String("abc");
		System.out.println(s1==s2);   //false
		System.out.println(s1.equals(s2)); //true String��д��equals
	     
		/*��������ڳ�������JVM��Գ���������һ�����Ż���
		 * ����½����ַ����������Ѿ����ڵģ�
		��ô��ָ��ľ��ǳ��������Ѿ��еģ����û����Ϊ������ռ䣬���´洢
		**/
	     String s3="abcd";
	     String s4="abcd";
	     System.out.println("s3�ַ���"+s3);   
	     System.out.println("s4�ַ���"+s3);   
	     System.out.println("��==�ж�s3s4�Ƿ����"+s3==s4);   //true
		 System.out.println("��equals�����ж�s3s4�Ƿ����"+s3.equals(s4));//true
		 System.out.println("�ַ���ƴ�ӣ�"+s3.concat(s4));//true
		 System.out.println("s3�ַ�����charAt()����ȡ�±�Ϊ2��ֵ"+s3.charAt(2));   
		 System.out.println("s3�ַ���"+s3.getBytes());  
		 
		 StringBuffer s5=new StringBuffer(s3);
		 s5.append("fuk");
		 System.out.println(s5);   
		 StringBuffer s6=s5.insert(3, "love");
		 System.out.println(s6);  
		 StringBuffer s7=s6.reverse();
		 System.out.println(s7);  
		 for(int i=0;i<10;i++) {
			 System.out.println((int)(Math.random()*10+10));   //doubleǿתint
		 }
		 
	}
	
	
	
	

}
