package com.bridge;

/**
 * 桥接模式
 * @author arvin
 */
public class MyBridge extends Bridge {
	public void method() {
		getSource().method();
	}
}
