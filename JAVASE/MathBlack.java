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
	//����һ������洢��λ���ĸ�������
	int a[]=new int[4];
	//�����洢���������������������������λ����
	int num1 = 0;
	//�����洢����������������������С����λ����
	int num2 = 0;
	//do��������whileѭ���ж��Ƿ����6174
	do{
	for(int i=0;i<a.length;i++){
	a[i] = num%10;
	num = num/10;
	}
	//������λ�����ְ�������
	seek(a);
	//���ֵ��ֵ��num1
	num1 = a[0]+a[1]*10+a[2]*100+a[3]*1000;
	//��Сֵ��ֵ��num2
	num2 = a[0]*1000+a[1]*100+a[2]*10+a[3];
	//���ÿһ���Ľ��
	System.out.println(num1+"-"+num2+"="+(num1-num2));
	num = num1-num2;
	b++;
	}while(num!=6174);
	System.out.println("�����У�"+b+"��");
	}
	
}