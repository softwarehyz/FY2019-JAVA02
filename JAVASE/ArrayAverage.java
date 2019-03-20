public class ArrayAverage{
	public static void main(String[] argues){
		int arr1[]={35,58,96,78,85};
		System.out.println(aver(arr1));
	}
	public static double aver(int[] arry){
		int sum=0;
		for(int i=0;i<arry.length;i++){	
			sum+=arry[i];
		}
		double result=sum*1.0/arry.length;
		return result;
	}
}