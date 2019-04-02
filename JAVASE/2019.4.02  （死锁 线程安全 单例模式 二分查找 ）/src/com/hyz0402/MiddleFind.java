package com.hyz0402;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MiddleFind {
    static List<Integer> array= new ArrayList<Integer>();
    static int d=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**Scanner scan=new Scanner(System.in);
		 System.out.println("请输入您要进行查询的原始数组:");
		 String s1=scan.next();
		 System.out.println("请输入您要查询的数字:");
		 int i1=scan.nextInt();*/
     array.add(1);
     array.add(5);
     array.add(8);
     array.add(6);
     array.add(2);
     array.add(9);
     array.add(3);
     int m=9;
     for(int i=0;i<array.size();i++) {
    	 System.out.print(array.get(i)+" ");
     }
     if( testFind(array,m)) {
    	 System.out.println("\n"+"查找成功");
    	 System.out.println("查找了"+d+"次");
     }else {
    	 System.out.println("有没有你心里没数");
    	 System.out.println("查找了"+d+"次");
     }
	}
	public static boolean testFind(List<Integer> array,int c) {   //循环实现
		Collections.sort(array);
		int a=0;
		int b=array.size()-1;
		int k=(a+b)/2;
		while(a<=b) {
		if(c>array.get(k)) {
			a=k+1; 
		   }else if(c<array.get(k)) {
			b=k-1;
		   }else {
			   return true;
		   }
		 k=(a+b)/2;
		 d++;
		}
		return false;
	}
	
/**public static boolean testFind1(List<Integer> array,int c) {     //递归实现
		Collections.sort(array);
		int a=0;
		int b=array.size()-1;
		int k=(a+b)/2;
		
	}
*/	
}
