package order.courseOrder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;




public class CourseOrderDaoImpl implements CourseOrderDao{




	@Override
	public int insert(CourseOrder CourseOrder) {
		getSession().persist(CourseOrder);
		return CourseOrder.getCourseOrderID();
	}
	@Override
	public int deleteByID(Integer CourseOrderID) {
		Session session=getSession();
		CourseOrder courseOrder=session.get(CourseOrder.class, CourseOrderID);
		session.remove(courseOrder);
		return CourseOrderID;
	}
	@Override
	public int updateByID(CourseOrder CourseOrder) {
		getSession().update(CourseOrder);
		return CourseOrder.getCourseOrderID();
	}
	@Override
	public CourseOrder selectByID(Integer CourseOrderID) {
		CourseOrder courseOrder=getSession().get(CourseOrder.class, CourseOrderID);
		return courseOrder;

	}
	@Override
	public List<CourseOrder> selectAll() throws ClassNotFoundException {
		return getSession().createQuery("FROM CourseOrder",CourseOrder.class).list();
	}
	@Override
	public List<Integer> getIdByUserName(String userName) {
		List<Integer>list=getSession().createQuery("SELECT userID FROM Member WHERE userName = '"+userName+"'",Integer.class).list();
		return list;
	}
	@Override
	public List<CourseOrder> selectAllByUserID(Integer userID) throws ClassNotFoundException {
		
		return getSession().createQuery("FROM CourseOrder WHERE userID = "+userID,CourseOrder.class).list();
	}
	@Override
	public List<CourseOrderDetail> selectDetailByOrderID(Integer courseOrderID) {
		
		return getSession().createQuery("FROM CourseOrderDetail WHERE courseOrderID = "+courseOrderID,CourseOrderDetail.class).list();
	}

}
