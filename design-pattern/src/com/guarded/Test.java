package com.guarded;

public class Test {

	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		for (int i = 0; i < 3; i++) {
          new ServerThread(requestQueue, "ServerThread_"+i).start();
		}
		
		for (int i = 0; i < 3; i++) {
		  new ClientThread(requestQueue, "ClientThread_"+i).start();;
		}
	}

}
