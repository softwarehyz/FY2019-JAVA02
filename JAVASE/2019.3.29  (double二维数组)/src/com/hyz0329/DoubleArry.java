package com.hyz0329;

import java.util.Scanner;

public class DoubleArry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		check();
	}
	
	public static void check() {
		System.out.print("请输入要解析的字符串：");
		Scanner scan=new Scanner(System.in);
		String s1=scan.nextLine();
		String[] a=s1.split(";");
		double[][] d;
		d=new double[a.length][];
		for(int i=0;i<a.length;i++) {
			String[] b=a[i].split(",");
			d[i]=new double[b.length];
			for(int j=0;j<b.length;j++) {
			d[i][j] = Double.parseDouble(b[j]);	//将字符串数组中每个元素都转为double类型
			}
		}
		
		for (int i = 0; i < d.length; i++) {
			   System.out.println();
			   for (int j = 0; j < d[i].length; j++) {
			    System.out.print("   "+"d["+i+"]"+"["+j+"]"+"="+d[i][j]);
			   }
			  }
	}
	
	 
	

}
