package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Course;
import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create session factory
		// create session
		// begin transaction
		// commit transaction
		// close session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			// get a course from db
			int id = 11;
			Course course = session.get(Course.class, id);

			// delete the course
			if (course != null) {
				System.out.println("Found course and deleting: " + course);
				session.delete(course);
			}

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
