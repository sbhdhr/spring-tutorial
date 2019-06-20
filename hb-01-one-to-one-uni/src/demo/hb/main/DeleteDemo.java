package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class DeleteDemo {

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
			// get instructor by primary key
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);

			// delete instructor
			if (instructor != null) {
				System.out.println("Found instructor : " + instructor);
				
				// Note: will ALSO delete associated "details" object 
				// because of CascadeType .ALL 
				session.delete(instructor) ; 
				
			}

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
