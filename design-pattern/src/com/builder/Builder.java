package com.builder;

import java.util.ArrayList;
import java.util.List;

import com.factory.MailSender;
import com.factory.Sender;
import com.factory.SmsSender;

/**
 * 建造者模式
 * 
 * @author arvin
 */
public class Builder {
	
	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}
}
