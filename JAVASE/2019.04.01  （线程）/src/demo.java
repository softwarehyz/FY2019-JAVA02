import java.util.Random;
import java.util.Scanner;

public class demo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationCode();
	}
	/*
	 * ����һ����ȡ�����֤��ķ�����getCode();
	 */
	public static boolean VerificationCode() {         //��֤��
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//��������0-9 �� ��Сд��ĸ
		char[] ch = new char[4]; //����һ���ַ��������ch ���� ��֤��
		for (int i = 0; i < 4; i++) {
			Random random = new Random();//����һ���µ������������
			int index = random.nextInt(string.length());//����[0,string.length)��Χ��intֵ    ���ã������±�
			ch[i] = string.charAt(index);//charAt() : ����ָ���������� char ֵ   ==�����浽�ַ��������ch����
		}
		//��char��������ת��ΪString���ͱ��浽result
		//String result = new String(ch);//����һ��ֱ��ʹ�ù��췽��      String(char[] value) ������һ���µ� String��ʹ���ʾ�ַ���������е�ǰ�������ַ����С�
		String result = String.valueOf(ch);//�������� String����   valueOf(char c) ������ char �������ַ�����ʾ��ʽ��
		System.out.println(result);
		Scanner scan=new Scanner(System.in);
		System.out.println("��������֤��(�����ִ�Сд)��");
		String s=scan.next();
		if(s.equalsIgnoreCase(result)) {
			System.out.println("��֤�ɹ�");
			return true;
		}else {
			System.out.println("��֤ʧ��");
			return false;
		}
	}
	
}