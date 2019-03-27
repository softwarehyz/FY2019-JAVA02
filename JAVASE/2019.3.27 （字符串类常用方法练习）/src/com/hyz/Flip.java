package com.hyz;

import java.util.Scanner;

public class Flip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //String s="To be or not to be";
        Scanner scan=new Scanner(System.in);
		 System.out.println("请输入要转换的字符串(中间用空格隔开):");
	     String e1=scan.nextLine();
        LetterFlip(e1);
	}

	public static void  LetterFlip(String s) {
		String[] a=s.split(" ");
		StringBuffer e1;
		for(int i=0;i<a.length;i++) {
			StringBuffer e=new StringBuffer(a[i]);
			e1=e.reverse();
			System.out.print(e1+" ");
		}
	
	}
}
