package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Course;
import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class PopulateInstructorDemo {

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

		int n = 5;
		Instructor tempInstructor;
		InstructorDetail tempInstructorDetail;

		try {

			session.beginTransaction();

			for (int i = 1; i <= n; i++) {

				tempInstructor = new Instructor("Subh#" + i, "Dhar", "sd#" + i + "@abc.com");
				tempInstructorDetail = new InstructorDetail("https://www.youtube.com/user/sd#" + i, "bikes" + i);

				tempInstructor.setInstructorDetail(tempInstructorDetail);

				session.save(tempInstructor);

			}

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
