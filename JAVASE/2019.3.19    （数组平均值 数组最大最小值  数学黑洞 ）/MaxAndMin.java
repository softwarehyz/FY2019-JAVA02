public class MaxAndMin{
	
	public static void main(String[] argues){
		int arry[] = {6,8,10,5,63};
		seek(arry);
		
	}
	
	public static void seek(int[] arry){
		int empty=0;
		for(int i=0;i<arry.length;i++){
			for(int j=i+1;j<arry.length-1;j++){
				
			if(arry[i]>arry[j]){
			empty=arry[i];
            arry[i]=arry[j];
            arry[j]=empty; 			
			}
				
			}
		}
		
       System.out.println("��������СֵΪ��"+arry[0]);
	   System.out.println("���������ֵΪ��"+arry[arry.length-1]);
		
	}
	
	
	
}