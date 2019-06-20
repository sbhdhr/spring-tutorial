package demo.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			int studentID = 3004;

			System.out.println("Getting student with ID: " + studentID);

			// start a transaction
			session.beginTransaction();

			// get student object and update
			Student student = session.get(Student.class, studentID);

			if(student!=null) {
				System.out.println("Updating student...");
				student.setFirstName("Subhashis");
			}
			
			// commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
