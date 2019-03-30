package com.hyz0330;
/*enum枚举类型变量 只能在固定的值里面取变量
比如订单状态：
开
关
**/
public enum OrderStatus {
	NO_PAY("未付款"),
	PAYID("已付款"),
	FINISH("已完成")
	;
	private String orderStatus;
	
	 OrderStatus(String orderStatus) {
		
		this.orderStatus= orderStatus;
		 
	}
	 
	 public String getOrderStatus() {
		 return this.orderStatus;
	 }  
	 
	 public static void main(String[] argues) {
			System.out.println(OrderStatus.NO_PAY.getOrderStatus());
			
		}
}

