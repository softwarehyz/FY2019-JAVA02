package com.hyz0408.common;

public enum UserChoice {                   //用户登陆选择操作
	ONLINE_BUM(1,"查看登陆人数"),
	BOOK_OPERATION(2,"书籍相关操作")
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
