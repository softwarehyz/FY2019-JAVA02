package com.hyz;

import java.util.Scanner;

public class Breakup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan=new Scanner(System.in);
		 System.out.println("������Ҫ��ֵ��ַ���:");
	     String e1=scan.nextLine();
	     System.out.print("��ֽ��Ϊ:");
	     resolute(e1);
	}

	public static void resolute(String s) {
		String s1=s.replace("name=","");
		String s2=s1.replace("age=","");
		String s3=s2.replace("classNo=","");
		System.out.println(s3);
	}
}
