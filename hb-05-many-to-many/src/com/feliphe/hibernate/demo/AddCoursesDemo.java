package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Course;
import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;
import com.feliphe.hibernate.demo.entity.Review;
import com.feliphe.hibernate.demo.entity.Student;

public class AddCoursesDemo {

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

			Course course = new Course("Java");
			Course course2 = new Course("PHP");
			Student feliphe = session.get(Student.class, 1);

			course.addStudent(feliphe);
			course2.addStudent(feliphe);

			// feliphe.addCourse(course);
			// feliphe.addCourse(course2);

			System.out.println(feliphe.getCourses());

			// session.save(feliphe);
			session.save(course);
			session.save(course2);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
