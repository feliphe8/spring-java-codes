package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create a java object

			Instructor tempInstructor = new Instructor("Feliphe", "Simoes", "feliphe@email.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "watch movies and series");
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction

			session.beginTransaction();

			// save the object

			// this will also save the Instructor Detail object because of CascadeType.ALL
			session.save(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
