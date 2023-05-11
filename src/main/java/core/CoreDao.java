package core;

import org.hibernate.Session;

import core.util.HibernateUtil;

public interface CoreDao {
	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	
	}
}
