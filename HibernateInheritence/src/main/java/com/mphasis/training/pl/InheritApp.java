package com.mphasis.training.pl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mphasis.training.entities.Account;
import com.mphasis.training.entities.CurrentAccount;
import com.mphasis.training.entities.SavingsAccount;
import com.mphasis.training.util.HibernateUtil;


public class InheritApp {

	public static void main(String[] args) {
		//
		
		// TODO Auto-generated method stub
//		Configuration con=new Configuration().configure().addAnnotatedClass(Account.class).addAnnotatedClass(SavingsAccount.class)
//				.addAnnotatedClass(CurrentAccount.class);
//		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
//		SessionFactory sessionFactory =con.buildSessionFactory(builder.build());

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		
//		Account a=new Account();
//		
//		a.setAcc_holder_name("Sashank");
//		a.setAcntnum(7435);
//		a.setBalance(12000);
//		
//		SavingsAccount s=new SavingsAccount();
//		s.setAcc_holder_name("Maya");
//		s.setAcntnum(5568);
//		s.setBalance(15000);
//		s.setAdhrnum(969313);
//		
//		CurrentAccount c=new CurrentAccount();
//		c.setAcc_holder_name("Nila");
//		c.setAcntnum(3657);
//		c.setBalance(9000);
//		c.setGstin("l593k");
//		
//		Session ses=sessionFactory.openSession();
//		ses.beginTransaction();
//		ses.save(a);
//		ses.save(s);
//		ses.save(c);
//		ses.getTransaction().commit();
//		ses.close();
//
		
		//Criteria
		
		Session session=sessionFactory.openSession();
		List<Account>  accnts=session.createCriteria(Account.class).list();
		for(Account a:accnts) {
			System.out.println(a.getAcntnum()+" "+a.getAcc_holder_name()+" "+a.getBalance());
		
		}
		session.close();
		
		
		//HQL
		Session s1=sessionFactory.openSession();
		Query q=s1.createQuery("FROM Account");
		q.list().forEach(System.out::println);
		
		Query q1=s1.createQuery("select a.acntnum from Account a");
		q1.list().forEach(System.out::println);
		
		//HQL
		s1.beginTransaction();
		Query q2=s1.createQuery("DELETE FROM Account where acntnum=:acn");
		q2.setParameter("acn", 4569);
		q2.executeUpdate();
		s1.getTransaction().commit();
		System.out.println("Deleted");
		s1.close();
		
		//SQL queries
		Session s2=sessionFactory.openSession();
		Query sq=s2.createSQLQuery("select acntnum, acc_holder_name from Account");
		List<Object[]> objs=sq.list();
		for(Object[] row:objs) {
			Account a=new Account();
			a.setAcntnum(Integer.parseInt((row[0].toString())));
			a.setAcc_holder_name(row[1].toString());
			System.out.println(a.getAcntnum()+" "+a.getAcc_holder_name());
		}
		s2.close();
		
		
	}

}
