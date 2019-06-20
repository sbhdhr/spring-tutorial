package demo.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			int studentID = 3004;

			// start a transaction
			session.beginTransaction();

			// get student object and delete
			System.out.println("Deleting student with ID: " + studentID);
			Student student = session.get(Student.class, studentID);

			if (student != null)
				session.delete(student);

			// Another way of deleting
			session.createQuery("delete from Student where id=2")
					.executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
