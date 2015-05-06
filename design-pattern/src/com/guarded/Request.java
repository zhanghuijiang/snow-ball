package com.guarded;

import com.future.Data;

public class Request {

	private String name;
	private Data  response;
	
	public Request(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "[ Request " + name + "]";
	}
	
	public synchronized Data getResponse(){
		return response;
	}
	
	public synchronized void setResponse(Data response){
		this.response = response;
	}
	
}
