package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory =  buildSessionFactoryNew();
	
	// Method to build the SessionFactory using the old Configuration method
	private static SessionFactory buildSessionFactory() {
		System.out.println("abc");
		try {
			// Create and configure the SessionFactory using properties defined in "hibernate.cfg.xml"
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
		} 
		catch (Throwable ex) {
			// Handle any exceptions that occur during SessionFactory creation
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	// Method to build the SessionFactory using the new approach with MetadataSources and StandardServiceRegistry
	private static SessionFactory buildSessionFactoryNew() {	
		
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
		
	}

	// Method to provide access to the SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
