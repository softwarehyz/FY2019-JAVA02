public class TwoDimArry{
	
	public static void main(String[] argues){
		
		int[][] a=new int[2][];
		
		a[0]=new int[2];
		a[1]=new int[2];
		
		a[0][0]=5;
		a[0][0]=2;
		a[1][0]=0;
		a[1][1]=1;
		for(int m=0;m<a.length;m++){
			
			for(int n=0;n<a[m].length;n++){
				
				System.out.println("a"+"["+m+"]"+"["+n+"]"+"="+a[m][n]);
				
			}
			
		}
	}
	
	
}