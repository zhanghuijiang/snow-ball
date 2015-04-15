package com.adapter.obj;

import com.adapter.Source;
import com.adapter.Targetable;

/**
 * 对象的适配器模式
 * @author arvin
 */
public class Wrapper implements Targetable {

	private Source source; 
	 
	public Wrapper(Source source){  
        super();  
        this.source = source;  
    }  
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");  
	}

}
