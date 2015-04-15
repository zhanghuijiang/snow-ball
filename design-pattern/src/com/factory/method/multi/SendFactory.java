package com.factory.method.multi;

import com.factory.MailSender;
import com.factory.Sender;
import com.factory.SmsSender;

/**
 * 多个工厂方法模式
 * @author arvin
 */
public class SendFactory {
	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		return new SmsSender();
	}
}
