package com.factory.abstrac;

import com.factory.Provider;
import com.factory.Sender;
import com.factory.SmsSender;

/**
 * 抽象工程模式
 * @author arvin
 */
public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		 return new SmsSender();  
	}

}
