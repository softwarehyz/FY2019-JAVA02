package com.hyz;

import java.util.Scanner;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Scanner scan=new Scanner(System.in);
	 System.out.println("������Ҫͳ�Ƶ��ַ���:");
     String e=scan.nextLine();
     Statistical(e);
	}
	
	public static void Statistical(String s) {
		char[] a = s.toCharArray();
		int b=0;                          //ͳ�ƴ�д��ĸ����
		int c=0;                          //ͳ��Сд��ĸ����  
		int d=0;                          //ͳ�Ʒ���ĸ����  
		for(int i=0;i<a.length;i++) {
			if(a[i]>='A'&&a[i]<='Z') {
				b++;
			}else if(a[i]>='a'&&a[i]<='z') {
				c++;
			}else {
				d++;
			}
		}
		System.out.println("�����ַ����д�д��ĸ����Ϊ��"+b+"��");
		System.out.println("�����ַ�����Сд��ĸ����Ϊ��"+c+"��");
		System.out.println("�����ַ����з���ĸ����Ϊ��"+d+"��");
	}
    
}
