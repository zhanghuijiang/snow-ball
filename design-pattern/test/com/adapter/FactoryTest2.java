package com.adapter;

import com.adapter.obj.Wrapper;

public class FactoryTest2 {
	public static void main(String[] args) {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}
