package com.factory.abstrac;

import com.factory.Provider;
import com.factory.Sender;
import com.factory.abstrac.SendMailFactory;


public class FactoryTest {
	 public static void main(String[] args) {  
		 Provider provider = new SendMailFactory();  
	     Sender sender = provider.produce();  
	     sender.Send(); 
	 } 
}
