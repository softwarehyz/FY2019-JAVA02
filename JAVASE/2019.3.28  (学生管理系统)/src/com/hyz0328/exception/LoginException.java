package com.hyz0328.exception;

class LoginException extends RuntimeException{  //LoginException�쳣��
		
		public LoginException(){
			
		}
		
        public LoginException(String msg){
			super(msg);
		}
	}   

