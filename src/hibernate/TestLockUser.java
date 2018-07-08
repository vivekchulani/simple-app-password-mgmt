package hibernate;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestLockUser {

	public static void main(String[] args) {

		// Method calls

		TestLockUser tlu = new TestLockUser();
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("title:");
		String title = input.nextLine();
		System.out.println("url:");
		String url = input.nextLine();
		System.out.println("username:");
		String username = input.nextLine();
		System.out.println("password:");
		String password = input.nextLine();
		System.out.println("category:");
		String category = input.nextLine();

		tlu.insertLockInfo(title, url, username, password, category, lockUser_ID);
	}

	// 1. Insert data into LockUser (Registration).. User_ID (PK) auto
	// generated.

	public void insertLockUser(String firstName, String lastName,
			String username, String password, String email, long ssn) {
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();

			LockUser lockUser = new LockUser();
			lockUser.setFirstName(firstName);
			lockUser.setLastName(lastName);
			lockUser.setUsername(username);
			lockUser.setPassword(password);
			lockUser.setEmail(email);
			lockUser.setSsn(ssn);

			session.save(lockUser);

			session.flush();
			tx.commit();

			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. Insert data into LockInfo (home page).. Info_ID(PK) auto generated.
	// (Add button)

	public void insertLockInfo(String title, String url, String username,
			String password, String category, LockUser lockUser) {
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();

			LockInfo lockInfo = new LockInfo();
			lockInfo.setTitle(title);
			lockInfo.setUrl(url);
			lockInfo.setUsername(username);
			lockInfo.setPassword(password);
			lockInfo.setCategory(category);
			lockInfo.setLockUser(lockUser);

			session.save(lockInfo);

			session.flush();
			tx.commit();

			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 3. Select data from LockUser to check login (Login page) //

	public LockUser checkLockUser(String username, String password) {
		LockUser lockUser = new LockUser();
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session session = sf.openSession();

			String hql = "from LockUser lockUser where lockUser.username='"
					+ username + "' and lockUser.password='" + password + "'";
			Query query = session.createQuery(hql);

			for (Iterator iterator = query.iterate(); iterator.hasNext();) {
				lockUser = (LockUser) iterator.next();
				if (lockUser != null) {
					lockUser.setUsername(username);
					lockUser.setPassword(password);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lockUser;

	}

	// 4. Select data from LockInfo to retrieve data based on user_Id and
	// category (Retrieve button)

	public LockInfo getLockInfo(LockUser lockUser, String category) {
		LockInfo lockInfo = new LockInfo();
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session session = sf.openSession();

			String hql = "from LockInfo lockInfo where lockInfo.lockUser='"
					+ lockUser + "' and lockInfo.category='" + category + "'";
			Query query = session.createQuery(hql);
			for (Iterator iterator = query.iterate(); iterator.hasNext();) {
				lockInfo = (LockInfo) iterator.next();
				lockInfo.getTitle();
				lockInfo.getUrl();
				lockInfo.getUsername();
				lockInfo.getPassword();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lockInfo;

	}

	// 5. Retrieve forgotten password based on ssn

	public LockUser getLockUserPassword(long ssn) {
		LockUser lockUser = new LockUser();
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session session = sf.openSession();
			
			String hql = "from LockUser where lockUser.ssn = "+ssn+"";
			Query query = session.createQuery(hql);
			for (Iterator iterator = query.iterate(); iterator.hasNext();) {
				 lockUser = (LockUser) iterator.next();
				lockUser.getPassword();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lockUser;

	}

}
