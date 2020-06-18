import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO {
	private SessionFactory factory;
	public UserDAO() {
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		configuration.addAnnotatedClass(User.class);
		this.factory = configuration.buildSessionFactory();
	}
	public int insert(User user) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		int id = 0;

		try {
			transaction = session.beginTransaction();
			id = (int) session.save(user); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

		return id;
	}
	public void updatePassword(User user,String password) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction(); 
			user.setPassword(password);
			session.update(user); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	public void updateDeactivateAccount(User user,String status,String comment) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction(); 
			user.setStatus(status);
			user.setRemark(comment);
			session.update(user); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	public void delete(int id) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			User signUpPojo = (User)session.get(User.class, id);
			session.delete(signUpPojo); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	public List<User> list() {
		Session session = factory.openSession();
		try {
			return session.createCriteria(User.class).list();
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return new ArrayList<User>();
	}
}