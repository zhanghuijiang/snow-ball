package com.factory.method.stati;

import com.factory.MailSender;
import com.factory.Sender;
import com.factory.SmsSender;

/**
 * 静态工厂方法模式
 * 
 * @author arvin
 */
public class SendFactory {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}
