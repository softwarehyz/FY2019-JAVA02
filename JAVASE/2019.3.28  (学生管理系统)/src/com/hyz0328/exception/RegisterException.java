package com.hyz0328.exception;

class RegisterException extends RuntimeException{  //RegisterException�쳣��
	
	public RegisterException(){
		
	}
	
    public RegisterException(String msg){
		super(msg);
	}

}     
