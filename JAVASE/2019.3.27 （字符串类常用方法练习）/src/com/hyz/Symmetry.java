package com.hyz;

import java.util.Scanner;

public class Symmetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		 System.out.println("������ҪУ����ַ���:");
	     String e=scan.nextLine();
	     isSymmetry(e);
	}

	public static void isSymmetry(String e) {
		StringBuffer e1=new StringBuffer(e);
		StringBuffer e2=e1.reverse();
		if(e.contentEquals(e2)) {
			 System.out.println("���ַ����Գ�");
		}else {
			 System.out.println("���ַ������Գ�");
		}
	}
	
}
