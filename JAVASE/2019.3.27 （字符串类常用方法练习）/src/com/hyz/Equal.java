package com.hyz;

import java.util.Scanner;

public class Equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 System.out.println("请输入第一个字符串:");
	     String e1=scan.nextLine();
	     System.out.println("请输入第二个字符串:");
	     String e2=scan.nextLine();
	     identical (e1,e2);
	}
	
	public static void identical(String a,String b) {
		boolean e=a.regionMatches(0,b,0,b.length());
		if(e) {
			System.out.println("两字符串内容相同");
		}else {
			System.out.println("两字符串内容不相同");
		}
	}	

}
