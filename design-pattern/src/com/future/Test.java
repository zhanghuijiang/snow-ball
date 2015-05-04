package com.future;

public class Test {

	public static void main(String[] args) {

		Client client = new Client();
		Data data = client.request("name");
		try {
			System.out.println("神游一下");
			Thread.sleep(2000);
			System.out.println("神游回来了");
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("先去冲杯coffee");

		System.out.println("生产完成：" + data.getResult());

	}

}
