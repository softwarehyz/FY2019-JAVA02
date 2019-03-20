public class BMI{
	public static void main(String[] argues){
		double height=1.75;
		double weight=80.5;
		calculate(1.75,80.5);
		
	}
	public static void calculate(double height,double weight){
		
		double result=weight/(height*height);
		if(result<18.5){
			System.out.println("过轻");
		}else if(result>=18.5&result<25){
			System.out.println("正常");
		}else if(result>=25&result<28){
			System.out.println("过重");
		}else if(result>=28&result<32){
			System.out.println("肥胖");
		}else{
			System.out.println("严重肥胖");
		}
	}
}