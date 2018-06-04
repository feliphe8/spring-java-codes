package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Course;
import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create a java object

			// start a transaction

			session.beginTransaction();

			int id = 11;
			Course course = session.get(Course.class, id);
			session.delete(course);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
