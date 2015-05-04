package com.future;

public class FutureData implements Data {

	public FutureData(){
		System.out.println("货车就绪");
	}
	
	protected RealData realdata = null;
	protected boolean isReady = false;

	public synchronized void setRealData(RealData realdata) {
		System.out.println("装车");
		if (isReady) {
			return;
		}
		System.out.println("装车完成，通知可以开车了");
		this.realdata = realdata;
		this.isReady = true;
		notifyAll();//唤醒等待线程
	}

	@Override
	public synchronized String getResult() {
		while (!isReady) {
			try {
				System.out.println("等待配货和装车.....");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		return realdata.result;
	}

}
