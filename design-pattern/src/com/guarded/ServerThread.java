package com.guarded;

public class ServerThread extends Thread {

	private RequestQueue requestQueue;

	public ServerThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	public void run() {
		while (true) {
			final Request request = requestQueue.getRequest();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + " handles"+ request);
			if(requestQueue.size()==0){
				Thread.currentThread().stop();
				Thread.currentThread().destroy();
			}
		}
	}

}
