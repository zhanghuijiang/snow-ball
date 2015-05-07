package com.consumerproducer;

public final class PCData {

	private final int intData;

	public PCData(int intData) {
		this.intData = intData;
	}

	public PCData(String intData) {
		this.intData = Integer.valueOf(intData);
	}

	@Override
	public String toString() {
		return "data :" + intData;
	}
	
	public int getData() {
		return intData;
	}
	
}
