package com.hyz0408.common;

public enum BookOperation {                //对书籍进行相关的操作
	BOOK_LOOK(1,"查看全部书籍"),
	BOOK_LOOKBYID(2,"按照ID查看书籍"),
	BOOK_ADD(3,"增加书籍"),
	BOOK_ALTER(4,"修改书籍"),
	BOOK_DEL(5,"删除书籍")
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
