package com.hyz;

public class Extract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "113@ ere qqq yyui";
		String s1 =s.replace("@","");
		String[] s2=s1.split(" ");
		for(int i=0;i<s2.length;i++) {
			System.out.print(s2[i]+" ");
		}
	}

}
