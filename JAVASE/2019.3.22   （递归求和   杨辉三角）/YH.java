public class YH{
	
	public static void main(String[] argues){
		Caculate(3);
	}
	public static void Caculate(int n){
		int[][] a= new int[n][];
		for(int i=0;i<a.length;i++){
			a[i]=new int[i+1]; 
			a[i][0]=1;
            a[i][i]=1;	
		for(int j=1;j<a[i].length-1;j++){
			a[i][j]=a[i-1][j]+a[i-1][j-1];
		}
		}
		for(int i=0;i<a.length;i++){
			System.out.println("");
            for(int j=0;j<a[i].length;j++){
				System.out.print(""+a[i][j]);
			}			
		}
		
	}
}
