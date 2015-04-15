package com.web.controller.util;

public enum Code {
	
	SUCCESS("SUCCESS",200),FAILURE("SUCCESS",400);
	
	private int code;
	
	Code(String name,int code){
		this.code = code;
	};
	
	@Override
    public String toString() {
        return String.valueOf(this.code);
    }
	
}

