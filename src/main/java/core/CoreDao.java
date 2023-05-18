package core;

import org.hibernate.Session;

import core.util.HibernateUtil;

public interface CoreDao {
	
	default Session getSession() {
		return  HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
//	default Session getSession() {
//		Session session =HibernateUtil.getSessionFactory().getCurrentSession();
//		if(session==null) {
//			return HibernateUtil.getSessionFactory().openSession();
//		}
//		else {
//			return HibernateUtil.getSessionFactory().getCurrentSession();
//		}
//	
//	}
}
