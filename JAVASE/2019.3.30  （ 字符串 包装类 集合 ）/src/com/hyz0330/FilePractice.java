package com.hyz0330;

import java.io.File;
import java.io.IOException;

public class FilePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       File file=new File("C:\\Users\\Administrator\\Desktop\\测试.java");
		try {                                                     //文件添加
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());             //打印文件路径
		boolean a=file.exists();
		if(a==true) {
			System.out.println("文件存在"); 	
		}else {
			System.out.println("文件不存在"); 	
		}
	
		file.delete();                                          //文件删除
		System.out.println(file.length()); 	       
		boolean b=file.exists();
		if(b==true) {
			System.out.println("文件存在"); 	
		}else {
			System.out.println("文件不存在"); 	
		}
	
		 File file1=new File("C:\\Users\\Administrator\\Desktop\\测试文件夹");
		file1.mkdir();                                          //文件夹创建
		file1.delete();                                         //文件夹删除
		/*mkdirs()和mkdir()两个方法的区别是
		 * 1.mkdirs()会将路径上不存在的文件夹全都创建好
		   2.mkdir()只会创建路径上最底层的文件，如果其他文件夹不存在，创建文件夹不成功
		 **/
	
	
	}

}
