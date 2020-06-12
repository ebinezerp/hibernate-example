package hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Employee employee = new Employee("ravi", 40000.00);

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		try {
			session.save(employee);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		session.clear();
		session.close();
	}

}
