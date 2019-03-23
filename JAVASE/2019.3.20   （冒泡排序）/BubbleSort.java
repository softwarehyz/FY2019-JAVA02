/*public class BubbleSort{
	
	public static void main(String[] argues){
		int arry[] = {1,3,2,7,5};
		seek(arry);
		
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
		
        for(int i=0;i<arry.length;i++)
        {
           System.out.print(arry[i]+" ");
         }
		
	}
}*/

public class BubbleSort{
	
	public static void main(String[] argues){
		int arry[] = {1,3,2,7,5};
		seek(arry);
		
	}
	
	public static void seek(int[] arry){
		int empty=0;
		for(int i=0;i<arry.length;i++){
			for(int j=0;j<arry.length-1-i;j++){
				
			if(arry[j]>arry[j+1]){
			empty=arry[j];
            arry[j]=arry[j+1];
            arry[j+1]=empty; 			
			}
				
			}
		}
		
        for(int i=0;i<arry.length;i++)
        {
           System.out.print(arry[i]+" ");
         }
		
	}
}