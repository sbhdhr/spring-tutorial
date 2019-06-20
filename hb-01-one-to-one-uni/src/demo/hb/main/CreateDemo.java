package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		// create session
		// begin transaction
		// commit transaction
		// close session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			/*
			 * // create the object Instructor tempInstructor = new Instructor("Subh",
			 * "Dhar", "sd@abc.com");
			 * 
			 * // associate the object InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("https://www.youtube.com/user/autocarindia1", "bikes");
			 * 
			 * tempInstructor.setInstructorDetail(tempInstructorDetail);
			 */
			
			// create the object
			Instructor tempInstructor2 = new Instructor("John", "Wick", "JW@abc.com");

			// associate the object
			InstructorDetail tempInstructorDetail2 = new InstructorDetail("https://www.youtube.com/johnwick",
					"cat");

			tempInstructor2.setInstructorDetail(tempInstructorDetail2);

			session.beginTransaction();

			// save the instructor
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//session.save(tempInstructor);
			session.save(tempInstructor2);

			// Add todo code
			// Save the instructor

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}
}
