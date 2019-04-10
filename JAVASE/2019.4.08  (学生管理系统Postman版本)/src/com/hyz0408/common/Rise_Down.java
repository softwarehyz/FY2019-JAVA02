package com.hyz0408.common;

public enum Rise_Down {

	RISE_LOOK(1,"升序查看"),
	DOWN_LOOK(2,"降序查看")
	;
	private int look_type;
	private String look_desc;
	
	private Rise_Down(int look_type, String look_desc) {
		this.look_type = look_type;
		this.look_desc = look_desc;
	}
	private Rise_Down() {
	}
	public int getLook_type() {
		return look_type;
	}
	public void setLook_type(int look_type) {
		this.look_type = look_type;
	}
	public String getLook_desc() {
		return look_desc;
	}
	public void setLook_desc(String look_desc) {
		this.look_desc = look_desc;
	}
	
	
}
