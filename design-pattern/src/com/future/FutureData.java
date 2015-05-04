package com.future;

public class FutureData implements Data {

	public FutureData(){
		System.out.println("生产部门准备完毕");
	}
	
	protected RealData realdata = null;
	protected boolean isReady = false;

	public synchronized void setRealData(RealData realdata) {
		if (isReady) {
			return;
		}
		System.out.println("交付生产部门，通知其他部门可以取货");
		this.realdata = realdata;
		this.isReady = true;
		notifyAll();//唤醒等待线程
	}

	@Override
	public synchronized String getResult() {
		while (!isReady) {
			try {
				System.out.println("等待生产.....");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		return realdata.result;
	}

}
