package demo.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class PopulateStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		
		Session session = sessionFactory.getCurrentSession();

		Student student;
		int n=100;
		
		try {
			
			// start a transaction
			session.beginTransaction();

			for(int i=0;i<n;i++) {
				// create student object
				student = new Student("Student#"+(i+1), "Lastname#"+(i+1), "Student#"+(i+1)+"@abc.com");

				// save the student
				session.save(student);
			}
			
			

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
		

	}

}
