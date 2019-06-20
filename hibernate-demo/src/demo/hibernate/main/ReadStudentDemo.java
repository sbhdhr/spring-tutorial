package demo.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session

		Session session = sessionFactory.getCurrentSession();

		try {

			// create student object
			Student student = new Student("Ducky", "Shine", "DS@abc.com");

			// start a transaction
			session.beginTransaction();

			// save the student
			session.save(student);
			System.out.println("Saving student: " + student);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Saved student!! Generated ID: " + student.getId());

			// Read Code

			// get new session and start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on id:primary key
			System.out.println("\n\nGetting student with ID: " + student.getId());
			Student readStudent = session.get(Student.class, student.getId());

			System.out.println("Get Complete! Student: " + readStudent);

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
