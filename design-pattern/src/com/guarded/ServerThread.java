package com.guarded;

import com.future.FutureData;
import com.future.RealData;

public class ServerThread extends Thread {

	private RequestQueue requestQueue;

	public ServerThread(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	public void run() {
		while (true) {
			final Request request = requestQueue.getRequest();
			
			final FutureData future = (FutureData)request.getResponse();
			RealData  realdata = new RealData(request.getName());
			future.setRealData(realdata);
			
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
