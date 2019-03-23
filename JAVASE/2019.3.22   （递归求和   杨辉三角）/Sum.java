public class Sum{
	
	public static void main(String[] argues){
		System.out.println(Caculate(3));
	}
	public static int Caculate(int n){
		if(n==1){
			return 1;
		}else{
			return n+Caculate(n-1);
			
		}
	}
}


