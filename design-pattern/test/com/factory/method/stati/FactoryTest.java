package com.factory.method.stati;

import com.factory.Sender;


public class FactoryTest {
	 public static void main(String[] args) {  
		 Sender sender = SendFactory.produceMail();  
	     sender.Send();
	 } 
}
