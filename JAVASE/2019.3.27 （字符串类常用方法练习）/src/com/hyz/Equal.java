package com.hyz;

import java.util.Scanner;

public class Equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 System.out.println("�������һ���ַ���:");
	     String e1=scan.nextLine();
	     System.out.println("������ڶ����ַ���:");
	     String e2=scan.nextLine();
	     identical (e1,e2);
	}
	
	public static void identical(String a,String b) {
		boolean e=a.regionMatches(0,b,0,b.length());
		if(e) {
			System.out.println("���ַ���������ͬ");
		}else {
			System.out.println("���ַ������ݲ���ͬ");
		}
	}	

}
