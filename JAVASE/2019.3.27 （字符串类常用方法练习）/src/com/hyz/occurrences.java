package com.hyz;

import java.util.Scanner;

public class occurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan=new Scanner(System.in);
		 System.out.println("请输入一个字符串:");
	     String e1=scan.nextLine();
	     System.out.println("请输入指定字符串:");
	     String e2=scan.nextLine();
	     appear (e1,e2);
	}
	
	public static void appear (String a,String b) {//第一个参数为大字符串   第二个参数为要寻找的小字符串
		int num=0;
		for(int i=0;i<a.length();i++) {
			if(a.contains(b)) {
				a=a.substring(a.indexOf(b)+b.length());
				num++;
			}
		}
		System.out.println("指定字符串出现次数为："+num);	
	}
	
	

}
