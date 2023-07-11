package com;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String args[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e = (Employee)context.getBean("emp");
		
		System.out.println(e.getId() );
		System.out.println(e.getName() );

        ArrayList<String> ats = e.getProgramming();
        System.out.println("Programming language: ");
        for(String string: ats) {
            System.out.println("  "+string);
        }
	}
}
