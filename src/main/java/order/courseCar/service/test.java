package order.courseCar.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import core.util.HibernateUtil;
import order.courseCar.dao.CourseCarDaoImpl;
import order.courseCar.dao.CourseCarPK;
import order.courseCar.model.CourseCar;
import order.productCar.dao.ProductCarDaoImpl;
import order.productCar.dao.ProductCarPK;
import order.productCar.model.ProductCar;
import order.productCar.service.ProductCarService;
import order.productCar.service.ProductCarServiceImpl;


public class test {
//	private static CourseCarService ccs=new CourseCarServiceImpl();
	private static ProductCarService pcs=new ProductCarServiceImpl();

	public static void main(String[] args) {
		CourseCarDaoImpl a =new CourseCarDaoImpl();
		CourseCarPK b=new CourseCarPK(2,2);
		CourseCar c=new CourseCar(b,5);
		ProductCarDaoImpl a1=new ProductCarDaoImpl();
		ProductCarPK b1=new ProductCarPK(2,3);
		ProductCar c1=new ProductCar(b1,5);
		
		
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
//			System.out.println(ccs.ListCar(1));
//			ccs.addCar(c);
//			ccs.removeCar(b);
//			ccs.cleanCar(1);
//			System.out.println(pcs.ListCar(1));
//			System.out.println(pcs.subTotal(1));
//			System.out.println(ccs.subTotal(2));
//			ccs.carPush(2);
//			ccs.sendAply(2);
//			System.out.println(pcs.ListCar(1).get(0).getQuantity());
//			pcs.addCar(c1);
//			pcs.removeCar(b1);
			pcs.sendAply(2,"台北市");
			
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			
		}
		
		
		
		
		

	}

}
