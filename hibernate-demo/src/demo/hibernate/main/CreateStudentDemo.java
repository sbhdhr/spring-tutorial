package demo.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		
		Session session = sessionFactory.getCurrentSession();

		try {

			// create student object
			Student student = new Student("Subh", "Dhar", "abc@abc.com");

			// start a transaction
			session.beginTransaction();

			// save the student
			session.save(student);

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
		

	}

}
