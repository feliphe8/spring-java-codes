package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction

			session.beginTransaction();

			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			if (instructor != null) {
				// also delete the instructor detail object due to cascadetype.all
				session.delete(instructor);
			}
			// save the object

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
