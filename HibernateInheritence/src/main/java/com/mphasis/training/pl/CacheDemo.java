package com.mphasis.training.pl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.entities.Account;
import com.mphasis.training.util.HibernateUtil;

public class CacheDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		Session ses=sessionFactory.openSession();
		Account a1=(Account) ses.get(Account.class, 4425);
		
		ses.close();
		
		Session ses2=sessionFactory.openSession();
		Account a11=(Account) ses2.get(Account.class, 4425);

		ses2.close();
	}

}
