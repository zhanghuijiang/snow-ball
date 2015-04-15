package com.factory.method.multi;

import com.factory.Sender;


public class FactoryTest {
	 public static void main(String[] args) {  
	        SendFactory factory = new SendFactory();  
	        Sender sender = factory.produceMail();  
	        sender.Send();  
	 } 
}
