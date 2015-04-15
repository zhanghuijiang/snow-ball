package com.adapter;

import com.adapter.interf.SourceSub1;
import com.adapter.interf.SourceSub2;

public class FactoryTest3 {

	public static void main(String[] args) {

		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();

		System.out.println("-----");
		source1.method1();
		System.out.println("-----");
		source1.method2();
		System.out.println("-----");
		source2.method1();
		System.out.println("-----");
		source2.method2();
		System.out.println("-----");

	}
}
