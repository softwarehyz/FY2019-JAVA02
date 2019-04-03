package com.hyz0403;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ObjectDeal ();
		test();
	}
	
	public static void test() {
		InputStream is=null;
		ObjectInputStream ois=null;
		try {
			is=new FileInputStream("C:\\Users\\Administrator\\Desktop\\测试文件（存储对象）.txt");
		     ois=new ObjectInputStream(is);
		     Object o1=ois.readObject();
		     if(o1 instanceof Teacher) {
		    	 Teacher t2=(Teacher)o1;
		    	 System.out.println(t2.getId()+"\t"+t2.getName()+"\t"+t2.getAge());
		     }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	
	
     //将学生对象写到文件中
	public static void ObjectDeal () {
		Teacher s=new Teacher(1,"张善",25);
		OutputStream os=null;
		ObjectOutputStream oos=null;
		try {
			os=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\测试文件（存储对象）.txt");
		    oos=new ObjectOutputStream(os);
		    oos.writeObject(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {if(oos!=null)
				oos.close();
				if(os!=null) 
					os.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			}
	
		}	
	}
}

		