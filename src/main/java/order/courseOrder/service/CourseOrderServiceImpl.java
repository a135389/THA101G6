package order.courseOrder.service;

import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;
import order.courseOrder.dao.CourseOrderDao;
import order.courseOrder.dao.CourseOrderDaoImpl;
import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;

public class CourseOrderServiceImpl implements CourseOrderService{
	private CourseOrderDao dao;
	static Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	public CourseOrderServiceImpl() {
		dao=new CourseOrderDaoImpl();
	}
	
	@Override
	public List<CourseOrder> listOrderByID(Integer userID) {
		try {
			return dao.selectAllByUserID(userID);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("取得購物車失敗");
			return null;
		}
		
	}

	@Override
	public List<Integer> getIdByUserName(String userName) {
		return dao.getIdByUserName(userName);
		//可能查到同名的會員或無資料,需要送到controller做處理
	}
	@Override
	public List<CourseOrder> listOrderByUserName(String userName,Integer index) {
		List<Integer>list=getIdByUserName(userName);
		Integer userID=list.get(index);	
		return listOrderByID(userID);
	}

	@Override
	public List<CourseOrderDetail> listOrderDetail(Integer courseOrderID) {
		
		return dao.selectDetailByOrderID(courseOrderID);
	}



}
