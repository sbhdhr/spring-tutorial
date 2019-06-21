package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Course;
import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;
import demo.hb.entity.Review;

public class GetCourseandReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		int id = 12;
		Course course;

		try {

			session.beginTransaction();
			
			course = session.get(Course.class, id);
			
			System.out.println("\nFound course: "+course);
			
			System.out.println("\n\nAssociated reviews: "+course.getReviews());
			
			

			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
