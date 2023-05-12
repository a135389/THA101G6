package courseCar.service;

import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;
import courseCar.dao.CourseCarDao;
import courseCar.dao.CourseCarDaoImpl;
import courseCar.dao.CourseCarPK;
import courseCar.model.CourseCar;

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
	public void clickPage() {
		// TODO Auto-generated method stub
		
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
			System.out.println("刪除"+dao.deleteAllByUserID(userID)+"筆資料");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Integer subTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Total() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dataCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void carPush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendAply() {
		// TODO Auto-generated method stub
		
	}

}
