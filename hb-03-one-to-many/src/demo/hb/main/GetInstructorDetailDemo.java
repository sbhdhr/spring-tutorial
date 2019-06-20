package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	// create session factory
	// create session
	// begin transaction
	// commit transaction
	// close session factory

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			// Add TODO code
			// get the instructor detail object
			// print the instructor detail
			// print the associated instructor

			int id = 299;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

			System.out.println("Found instructorDetail : " + instructorDetail);
			if (instructorDetail != null) {
				System.out.println("Associated instructor detail : " + instructorDetail.getInstructor());
			}

			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
