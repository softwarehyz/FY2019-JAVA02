public class ArryMatching{
	public static void main(String[] argues){
		
		int n =65;
		System.out.println(aver(n));
		
	}
	public static int aver(int n){
		int[] arry={18,58,98,35,65,78};
		for(int i=0;i<arry.length;i++){	
		
		if(arry[i]==n){
			
			return i;
			
		    }	
		}
		return -1;
	}
}