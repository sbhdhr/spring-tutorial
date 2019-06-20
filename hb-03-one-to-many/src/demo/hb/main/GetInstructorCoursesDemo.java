package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Course;
import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			int id = 3;
			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("\n\nInstructor: " + instructor);
			System.out.println("\n\nCourses for instructor:" + instructor.getFirstName() + " " + instructor.getLastName()
					+ " are: " + instructor.getCourses());
			;

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
