package com.hyz0330;

import java.io.File;
import java.io.IOException;

public class FilePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       File file=new File("C:\\Users\\Administrator\\Desktop\\����.java");
		try {                                                     //�ļ����
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());             //��ӡ�ļ�·��
		boolean a=file.exists();
		if(a==true) {
			System.out.println("�ļ�����"); 	
		}else {
			System.out.println("�ļ�������"); 	
		}
	
		file.delete();                                          //�ļ�ɾ��
		System.out.println(file.length()); 	       
		boolean b=file.exists();
		if(b==true) {
			System.out.println("�ļ�����"); 	
		}else {
			System.out.println("�ļ�������"); 	
		}
	
		 File file1=new File("C:\\Users\\Administrator\\Desktop\\�����ļ���");
		file1.mkdir();                                          //�ļ��д���
		file1.delete();                                         //�ļ���ɾ��
		/*mkdirs()��mkdir()����������������
		 * 1.mkdirs()�Ὣ·���ϲ����ڵ��ļ���ȫ��������
		   2.mkdir()ֻ�ᴴ��·������ײ���ļ�����������ļ��в����ڣ������ļ��в��ɹ�
		 **/
	
	
	}

}
