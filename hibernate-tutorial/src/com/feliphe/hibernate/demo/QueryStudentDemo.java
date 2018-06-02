package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			java.util.List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Evergreen'").getResultList();
			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Evergreen' or s.firstName='Summer'")
					.getResultList();
			displayStudents(students);

			students = session.createQuery("from Student s where s.email LIKE '%email.com'").getResultList();
			displayStudents(students);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(java.util.List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
