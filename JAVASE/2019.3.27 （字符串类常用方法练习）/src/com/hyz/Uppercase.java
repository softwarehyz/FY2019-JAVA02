package com.hyz;

import java.util.Locale;
import java.util.Scanner;

public class Uppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 System.out.println("请输入要转换的字符串:");
	     String e=scan.nextLine();
	     DX(e);
	}

	public static void DX(String s) {
		// TODO Auto-generated method stub
     String s2=s.toUpperCase();
     String s1=s2.substring(1);
     System.out.println(s2);
     System.out.println(s1);
	}
}
