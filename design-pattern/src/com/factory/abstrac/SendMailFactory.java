package com.factory.abstrac;

import com.factory.MailSender;
import com.factory.Provider;
import com.factory.Sender;

/**
 * 抽象工程模式
 * @author arvin
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();  
	}

}
