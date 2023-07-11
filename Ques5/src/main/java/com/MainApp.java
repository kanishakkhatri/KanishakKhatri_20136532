package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory=cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        Person person=new Person();
        
        person.setCid(23);
        person.setCname("Kanishak");
        person.setPlace("Delhi");
        person.setPan("KK0008");

        session.save(person);
        transaction.commit();

        System.out.println("Details Added!");
	}

}
