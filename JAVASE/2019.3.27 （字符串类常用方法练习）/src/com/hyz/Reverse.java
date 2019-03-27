package com.hyz;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 System.out.println("请输入要翻转的字符串:");
	     String e1=scan.nextLine();
	     System.out.print("reversr结果为:");
	     Reverse1(e1);
	}

	public static void Reverse1(String s) {
		StringBuffer e=new StringBuffer(s);
		System.out.println(e.reverse());
	}
}
