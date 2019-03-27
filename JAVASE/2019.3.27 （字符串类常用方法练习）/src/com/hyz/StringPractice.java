package com.hyz;

import java.util.Scanner;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Scanner scan=new Scanner(System.in);
	 System.out.println("请输入要统计的字符串:");
     String e=scan.nextLine();
     Statistical(e);
	}
	
	public static void Statistical(String s) {
		char[] a = s.toCharArray();
		int b=0;                          //统计大写字母个数
		int c=0;                          //统计小写字母个数  
		int d=0;                          //统计非字母个数  
		for(int i=0;i<a.length;i++) {
			if(a[i]>='A'&&a[i]<='Z') {
				b++;
			}else if(a[i]>='a'&&a[i]<='z') {
				c++;
			}else {
				d++;
			}
		}
		System.out.println("输入字符串中大写字母个数为："+b+"个");
		System.out.println("输入字符串中小写字母个数为："+c+"个");
		System.out.println("输入字符串中非字母个数为："+d+"个");
	}
    
}
