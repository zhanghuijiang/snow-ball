package com.guarded;

import java.util.ArrayList;
import java.util.List;

import com.future.FutureData;

public class ClientThread extends Thread {

	private RequestQueue requestQueue;

    private List<Request> myRequest = new ArrayList<Request>();	
	
	public ClientThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			Request request = new Request("RequestID:" + i + " ThreadName:"
					+ Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " request "
					+ request);
			
			request.setResponse(new FutureData());
			
			requestQueue.addRequest(request);
			
			myRequest.add(request);
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			System.out.println("ClientThread Name is :"+ Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName() + " request end");
		
		for (Request r : myRequest) {
			System.out.println("ClientThred Name is "+Thread.currentThread().getName()+" Response is " + r.getResponse());
		}
		
		Thread.currentThread().stop();
		Thread.currentThread().destroy();
		
		
	}

}
