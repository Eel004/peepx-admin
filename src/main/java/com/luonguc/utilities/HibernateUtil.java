package com.luonguc.utilities;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	public static SessionFactory createSessionFactory(){
		try{
			sessionFactory = new Configuration().buildSessionFactory();
		} catch (HibernateException ex){
			System.err.println("create SessionFactory fail beacause: " + ex);
		}
		return sessionFactory;
	}
}
