package demo.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session

		Session session = sessionFactory.getCurrentSession();

		try {

			// create student object
			Student student1 = new Student("XXX", "YYY", "XY@abc.com");
			Student student2 = new Student("AAA", "BBB", "AB@abc.com");
			Student student3 = new Student("CCC", "DDD", "CD@abc.com");

			// start a transaction
			session.beginTransaction();

			// save the student
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
