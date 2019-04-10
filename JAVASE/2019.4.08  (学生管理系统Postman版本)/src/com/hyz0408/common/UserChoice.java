package com.hyz0408.common;

public enum UserChoice {                   //�û���½ѡ�����
	ONLINE_BUM(1,"�鿴��½����"),
	BOOK_OPERATION(2,"�鼮��ز���")
	;
	private int choose_type;
	private String choose_desc;
	
	 UserChoice(int choose_type, String operation_desc) {
		this.choose_type = choose_type;
		this.choose_desc = operation_desc;
	}
	
	UserChoice() {
		
	}

	public int getChoose_type() {
		return choose_type;
	}

	public void setChoose_type(int choose_type) {
		this.choose_type = choose_type;
	}

	public String getChoose_desc() {
		return choose_desc;
	}

	public void setChoose_desc(String choose_desc) {
		this.choose_desc = choose_desc;
	}

	
}
