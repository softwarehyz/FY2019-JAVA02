package com.hyz;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 System.out.println("������Ҫ��ת���ַ���:");
	     String e1=scan.nextLine();
	     System.out.print("reversr���Ϊ:");
	     Reverse1(e1);
	}

	public static void Reverse1(String s) {
		StringBuffer e=new StringBuffer(s);
		System.out.println(e.reverse());
	}
}
