package courseCar.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import core.util.HibernateUtil;
import courseCar.dao.CourseCarDaoImpl;
import courseCar.dao.CourseCarPK;
import courseCar.model.CourseCar;

public class test {
	private static CourseCarService ccs=new CourseCarServiceImpl();
	

	public static void main(String[] args) {
		CourseCarDaoImpl a =new CourseCarDaoImpl();
		CourseCarPK b=new CourseCarPK(1,2);
		CourseCar c=new CourseCar(b,7);
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		try {
			Transaction tr=session.beginTransaction();
//			a.insert(c);
//			a.deleteByID(b);
//			a.updateByID(c);
			
//			System.out.println("UserID:"+a.selectByID(b).getId().getUserID());
//			System.out.println("CourseID:"+a.selectByID(b).getId().getCourseID());
//			System.out.println("Quantity:"+a.selectByID(b).getQuantity());
//			System.out.println(a.selectAll());
//			System.out.println(a.selectAllByUserID(1).get(0).getQuantity());
//			ccs.addCar(c);
//			ccs.removeCar(b);
			ccs.cleanCar(2);
			tr.commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
