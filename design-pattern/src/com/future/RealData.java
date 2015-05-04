package com.future;

public class RealData implements Data {
	
	protected final String result;
	
	public RealData(String para){
		System.out.println("配货");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 9; i++) {
			sb.append(para);
			sb.append(",");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		result = sb.toString();
	}
	
	@Override
	public String getResult() {
		return result;
	}

}
