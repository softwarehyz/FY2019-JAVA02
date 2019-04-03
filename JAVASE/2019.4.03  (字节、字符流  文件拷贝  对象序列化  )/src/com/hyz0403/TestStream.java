package com.hyz0403;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStream t1=new TestStream();
		t1.testBufferReader ();
	}

	public  void testBufferReader () {
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		try {
			//File.separator 跨平台地址分隔符
			fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\测试文件.txt");
	        isr=new InputStreamReader(fis);	
	        br=new BufferedReader(isr);
	      String s=null;
	        while((s=(br.readLine()))!=null) {
	        	System.out.println(s);
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(isr!=null) {
					isr.close();
				}
				if(fis!=null) {
					fis.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
