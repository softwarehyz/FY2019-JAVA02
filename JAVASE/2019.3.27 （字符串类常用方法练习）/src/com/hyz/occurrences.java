package com.hyz;

import java.util.Scanner;

public class occurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan=new Scanner(System.in);
		 System.out.println("������һ���ַ���:");
	     String e1=scan.nextLine();
	     System.out.println("������ָ���ַ���:");
	     String e2=scan.nextLine();
	     appear (e1,e2);
	}
	
	public static void appear (String a,String b) {//��һ������Ϊ���ַ���   �ڶ�������ΪҪѰ�ҵ�С�ַ���
		int num=0;
		for(int i=0;i<a.length();i++) {
			if(a.contains(b)) {
				a=a.substring(a.indexOf(b)+b.length());
				num++;
			}
		}
		System.out.println("ָ���ַ������ִ���Ϊ��"+num);	
	}
	
	

}
