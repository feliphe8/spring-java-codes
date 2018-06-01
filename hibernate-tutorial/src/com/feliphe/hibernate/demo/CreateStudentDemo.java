package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create a java object
			Student tempStudent = new Student("Feliphe", "Simoes", "feliphe@email.com");
			// start a transaction
			session.beginTransaction();
			// save the object
			session.save(tempStudent);
			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
