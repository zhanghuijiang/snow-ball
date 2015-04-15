package com.factory.ordinary;

import com.factory.Sender;
import com.factory.ordinary.SendFactory;

public class FactoryTest {
	 public static void main(String[] args) {  
	        SendFactory factory = new SendFactory();  
	        Sender sender = factory.produce("sms");  
	        sender.Send();  
	 }  
}
