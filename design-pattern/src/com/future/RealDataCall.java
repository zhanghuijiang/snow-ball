package com.future;

import java.util.concurrent.Callable;

public class RealDataCall implements Callable<String> {

	private String para;

	public RealDataCall(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 9; i++) {
			sb.append(para);
			sb.append(",");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		return sb.toString();
	}

}
