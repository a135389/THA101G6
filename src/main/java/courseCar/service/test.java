package courseCar.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import core.util.HibernateUtil;
import courseCar.dao.CourseCarDaoImpl;
import courseCar.model.CourseCar;

public class test {

	public static void main(String[] args) {
		CourseCarDaoImpl a =new CourseCarDaoImpl();
		CourseCar b=new CourseCar(2,3,4);
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		try {
			Transaction tr=session.beginTransaction();
			a.insert(b);
			tr.commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
