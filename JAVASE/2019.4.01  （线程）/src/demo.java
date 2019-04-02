import java.util.Random;
import java.util.Scanner;

public class demo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationCode();
	}
	/*
	 * 定义一个获取随机验证码的方法：getCode();
	 */
	public static boolean VerificationCode() {         //验证码
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大小写字母
		char[] ch = new char[4]; //声明一个字符数组对象ch 保存 验证码
		for (int i = 0; i < 4; i++) {
			Random random = new Random();//创建一个新的随机数生成器
			int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
			ch[i] = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》保存到字符数组对象ch里面
		}
		//将char数组类型转换为String类型保存到result
		//String result = new String(ch);//方法一：直接使用构造方法      String(char[] value) ：分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
		String result = String.valueOf(ch);//方法二： String方法   valueOf(char c) ：返回 char 参数的字符串表示形式。
		System.out.println(result);
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入验证码(不区分大小写)：");
		String s=scan.next();
		if(s.equalsIgnoreCase(result)) {
			System.out.println("验证成功");
			return true;
		}else {
			System.out.println("验证失败");
			return false;
		}
	}
	
}