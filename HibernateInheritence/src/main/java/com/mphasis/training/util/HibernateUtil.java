package com.mphasis.training.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.mphasis.training.entities.Account;
import com.mphasis.training.entities.CurrentAccount;
import com.mphasis.training.entities.SavingsAccount;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory getSessionFactory() {
        Configuration con=new Configuration();//.configure();
        Properties props=new Properties();
        props.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver"); // 1 - 4 jdbc properties  nd rest Hibernt props
        props.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
        props.put(Environment.USER, "hiber");
        props.put(Environment.PASS, "hiber");
        props.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
        props.put(Environment.HBM2DDL_AUTO, "update");
        props.put(Environment.SHOW_SQL, "true");
       // props.put(Environment.FORMAT_SQL, "true");
        props.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
        props.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        con.setProperties(props);
        con.addAnnotatedClass(Account.class);
        con.addAnnotatedClass(SavingsAccount.class);
        con.addAnnotatedClass(CurrentAccount.class);
        StandardServiceRegistryBuilder builder=
                new StandardServiceRegistryBuilder().applySettings(con.getProperties());
         sessionFactory = con.buildSessionFactory(builder.build());
        return sessionFactory;
    }

}
