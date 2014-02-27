package org.example.entities.dao;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl {
	
	@Inject
	private SessionFactory sessionFactory;
	
	public Session getcurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}