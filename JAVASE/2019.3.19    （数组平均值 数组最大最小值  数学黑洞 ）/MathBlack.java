public class MathBlack{
	
	public static void main(String[] argues){
		
	
	    int a=1536;	
		BlackHole(a);
			
	}
	
	public static void seek(int[] arry){
		int empty=0;
		for(int i=0;i<arry.length;i++){
			for(int j=i+1;j<arry.length;j++){
				
			if(arry[i]>arry[j]){
			empty=arry[i];
            arry[i]=arry[j];
            arry[j]=empty; 			
			   }	
			}
		}
	}
	
	public static void BlackHole(int num){
	int b=0;
	//定义一个数组存储四位数的各个数字
	int a[]=new int[4];
	//用来存储被减数（数字重新排序后的最大四位数）
	int num1 = 0;
	//用来存储减数（数字重新排序后的最小的四位数）
	int num2 = 0;
	//do····while循环判断是否等于6174
	do{
	for(int i=0;i<a.length;i++){
	a[i] = num%10;
	num = num/10;
	}
	//各个数位的数字按升排列
	seek(a);
	//最大值赋值给num1
	num1 = a[0]+a[1]*10+a[2]*100+a[3]*1000;
	//最小值赋值给num2
	num2 = a[0]*1000+a[1]*100+a[2]*10+a[3];
	//输出每一步的结果
	System.out.println(num1+"-"+num2+"="+(num1-num2));
	num = num1-num2;
	b++;
	}while(num!=6174);
	System.out.println("共进行："+b+"步");
	}
	
}