package com.hyz0402;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestIOStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}	
	public static void test() {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\测试文件.txt");
			File file=new File("C:\\Users\\Administrator\\Desktop\\测试文件(副本).txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			fos=new FileOutputStream(file);
			int result=0;
			while((result=(fis.read()))!=-1) {
				fos.write(result);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(fis!=null) {
					fis.close();
				}if(fos!=null) {
					fos.close();
				}
				   }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}
		
	}
}
