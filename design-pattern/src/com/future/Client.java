package com.future;

/**
 * 客户端
 * @author arvin
 */
public class Client {

	public Data request(final String queryStr) {
		final FutureData future = new FutureData();
		new Thread() {
			public void run() {
				RealData realdata = new RealData(queryStr);
				future.setRealData(realdata);
			}
		}.start();
		return future;
	}

}
