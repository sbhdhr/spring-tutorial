package demo.hb.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hb.entity.Instructor;
import demo.hb.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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

			int id = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

			if (instructorDetail != null) {
				System.out.println("Found and deleting instructorDetail : " + instructorDetail);
				
				System.out.println("Also deleting associated instructor detail : " + 
						instructorDetail.getInstructor());
				
				//remove the associated object reference
				
				instructorDetail.getInstructor().setInstructorDetail(null);
				
				
				session.delete(instructorDetail);
			}

			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
