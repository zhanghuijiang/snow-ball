package com.adapter;

import com.adapter.clas.Adapter;

public class FactoryTest {
	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}
