package com.feliphe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feliphe.hibernate.demo.entity.Course;
import com.feliphe.hibernate.demo.entity.Instructor;
import com.feliphe.hibernate.demo.entity.InstructorDetail;
import com.feliphe.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction

			session.beginTransaction();

			Course haskell = new Course("Haskell");
			haskell.addReview(new Review("Great course."));
			haskell.addReview(new Review("Cool course."));
			haskell.addReview(new Review("Dumb course, php rules"));

			System.out.println(haskell.getReviews());

			session.save(haskell);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
