package com.tsc.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String args[])
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		System.out.println("done");
		
		
	}
}
