package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create 3 students objects
			Student tempStudent = new Student("Vayne", "Shawna", "vayne@email.com");
			Student tempStudent2 = new Student("Irelia", "Evergreen", "irelia@email.com");
			Student tempStudent3 = new Student("Lydia", "Evergreen", "lydia@email.com");
			// start a transaction
			session.beginTransaction();
			// save the object
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
