package demo.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query student

			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			displayStudents(studentList);
			
			
			
			// query student : Last Name='Shine'

			studentList = session.createQuery("from Student s where s.lastName='Shine'")
							.getResultList();
			System.out.println("\nStudent with lastName 'Shine'");
			displayStudents(studentList); 
			
			
			// query student : Last Name='Shine' or First Name='XXX'

			studentList = session.createQuery("from Student s where"
							+ " s.lastName='Shine'"
							+ " OR s.firstName='XXX'")
							.getResultList();
			System.out.println("\nStudent with Last Name='Shine' or First Name='XXX'");
			displayStudents(studentList); 
			
			
			
			// query student : where email like %@abc2.com

			studentList = session.createQuery("from Student s where"
							+ " s.email like '%@abc2.com'")
							.getResultList();
			System.out.println("\nStudent where email like %@abc2.com");
			displayStudents(studentList); 
			
			
			

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			// close session factory
			sessionFactory.close();
		}

	}

	private static void displayStudents(List<Student> studentList) {
		//display the students
		for(Student s:studentList) {
			System.out.println(s);
		}
	}

}
