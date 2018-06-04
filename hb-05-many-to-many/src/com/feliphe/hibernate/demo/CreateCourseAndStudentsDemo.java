package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Course;
import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;
import com.feliphe.hibernate.demo.entity.Review;
import com.feliphe.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction

			session.beginTransaction();

			Course haskell = new Course("Haskell");
			Student feliphe = new Student("Feliphe", "Simoes", "feliphe@email.com");
			Student irelia = new Student("Irelia", "Evergreen", "irelia@email.com");
			Student caitlyn = new Student("Caitlyn", "Evergreen", "caitlyn@email.com");

			haskell.addStudent(feliphe);
			haskell.addStudent(irelia);
			haskell.addStudent(caitlyn);

			session.save(feliphe);
			session.save(irelia);
			session.save(caitlyn);

			session.save(haskell);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
