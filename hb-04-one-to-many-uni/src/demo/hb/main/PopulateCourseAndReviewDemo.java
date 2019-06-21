package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Course;
import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;
import demo.hb.entity.Review;

public class PopulateCourseAndReviewDemo {

	public static void main(String[] args) {
		// create session factory
		// create session
		// begin transaction
		// commit transaction
		// close session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		int n = 10;
		Course course;
		Review review;

		try {

			session.beginTransaction();

			for (int i = 1; i <= n; i++) {
				course = new Course("Subject#" + i);
				review = new Review("good!!");
				course.addReview(review);

				review = new Review("Bad ##");
				course.addReview(review);

				session.save(course);

			}

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
