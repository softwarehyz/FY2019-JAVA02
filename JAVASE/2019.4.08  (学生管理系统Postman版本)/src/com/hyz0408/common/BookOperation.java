package com.hyz0408.common;

public enum BookOperation {                //���鼮������صĲ���
	BOOK_LOOK(1,"�鿴ȫ���鼮"),
	BOOK_LOOKBYID(2,"����ID�鿴�鼮"),
	BOOK_ADD(3,"�����鼮"),
	BOOK_ALTER(4,"�޸��鼮"),
	BOOK_DEL(5,"ɾ���鼮")
;
	private int operation_type;
	private String operation_desc;
	
	BookOperation(int operation_type, String operation_desc) {
		this.operation_type = operation_type;
		this.operation_desc = operation_desc;
	}

	public int getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}

	public String getOperation_desc() {
		return operation_desc;
	}

	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
	
	
}
