package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Course;
import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class PopulateCoursesDemo {

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

		int n = 10;
		Instructor instructor;
		Course course;

		try {

			session.beginTransaction();
			int id = 2;
			instructor = session.get(Instructor.class, id);

			for (int i = 1; i <= n; i++) {
				course = new Course("Subject#" + i);

				instructor.add(course);

				session.save(course);

			}

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
