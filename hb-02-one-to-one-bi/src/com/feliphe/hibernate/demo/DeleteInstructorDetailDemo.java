package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction

			session.beginTransaction();

			int id = 3;
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			System.out.println(detail);
			System.out.println(detail.getInstructor());
			// pra remover soh o instructor detail, é preciso desvincular o instructor com
			// instructor detail
			detail.getInstructor().setInstructorDetail(null);
			session.delete(detail);
			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
