package com.hyz0330;
/*enumö�����ͱ��� ֻ���ڹ̶���ֵ����ȡ����
���綩��״̬��
��
��
**/
public enum OrderStatus {
	NO_PAY("δ����"),
	PAYID("�Ѹ���"),
	FINISH("�����")
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

