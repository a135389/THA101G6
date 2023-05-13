package order.courseCar.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;
import course.model.Course;
import order.courseCar.dao.CourseCarDao;
import order.courseCar.dao.CourseCarDaoImpl;
import order.courseCar.dao.CourseCarPK;
import order.courseCar.model.CourseCar;
import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;


public class CourseCarServiceImpl implements CourseCarService{
	private CourseCarDao dao;
	static Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	
	public CourseCarServiceImpl() {
		dao=new CourseCarDaoImpl();
	}
	@Override
	public List<CourseCar> ListCar(Integer userID) {		
		try {
			return dao.selectAllByUserID(userID);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void addCar(CourseCar courseCar) {
		
		if(session.get(CourseCar.class,courseCar.getId())==null) {
			dao.insert(courseCar);

		}else {
			System.out.println("購物車已有同一商品");
		}
		
		
	}

	@Override
	public void removeCar(CourseCarPK coursePK) {
		try {
			dao.deleteByID(coursePK);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.err.println("無此資料");
		}
		
	}

	@Override
	public void cleanCar(Integer userID) {
		try {
			System.out.println("刪除使用者"+userID+"的"+dao.deleteAllByUserID(userID)+"筆購物車資料");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("清空購物車失敗");
		}
		
	}

	@Override
	public Integer subTotal(Integer userID) {
		Integer total=0;
		try {
			List<CourseCar> list=dao.selectAllByUserID(userID);
			for(CourseCar courseCar:list) {
				int courseId=courseCar.getId().getCourseID();
				Course course=session.get(Course.class,courseId);
				int price=(int) course.getCoursePrice();
				total=total+price;
			}
			return total;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("計算總額失敗");
			return null;
		}
		
		
	}


	@Override
	public boolean dataCheck() {
		
		return false;
	}

	@Override
	public void carPush(Integer userID) {
		try {
			List<CourseCar>list=dao.selectAllByUserID(userID);
			CourseOrder courseOrder=new CourseOrder(null,userID,subTotal(userID),Timestamp.from(Instant.now()));
			session.persist(courseOrder);
			int courseOrderID=courseOrder.getCourseOrderID();
			for(CourseCar courseCar:list) {
				int courseID=courseCar.getId().getCourseID();
				int coursePrice=session.get(Course.class,courseID).getCoursePrice();
				int quantity=courseCar.getQuantity();
				CourseOrderDetail courseOrderDetail=new CourseOrderDetail(null,courseOrderID,courseID,coursePrice,quantity,"審核中");
				session.persist(courseOrderDetail);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("送出購物車失敗");
		}
		
	}
	@Override
	public void sendAply(Integer userID) {
		carPush(userID);
		cleanCar(userID);
		
	}



}
