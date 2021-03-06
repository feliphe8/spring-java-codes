package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
			// start a transaction
			session.beginTransaction();

			Student student = session.get(Student.class, studentId);
			student.setFirstName("Shapeshifter");
			System.out.println(student);

			// commit the transaction
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			// UPDATE EMAIL FOR ALL STUDENTS
			session.createQuery("update Student set email = 'foo@email.com'").executeUpdate();

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
