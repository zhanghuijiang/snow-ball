package com.guarded;

public class ClientThread extends Thread {

	private RequestQueue requestQueue;

	public ClientThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			Request request = new Request("RequestID:" + i + " ThreadName:"
					+ Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " request "
					+ request);
			requestQueue.addRequest(request);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			System.out.println("ClientThread Name is :"+ Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName() + " request end");
		Thread.currentThread().stop();
		Thread.currentThread().destroy();
	}

}
