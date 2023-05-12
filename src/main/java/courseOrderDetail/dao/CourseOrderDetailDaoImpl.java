package courseOrderDetail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import courseOrderDetail.model.CourseOrderDetail;



public class CourseOrderDetailDaoImpl implements CourseOrderDetailDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	public static void main(String[] args) throws ClassNotFoundException {
		CourseOrderDetail a=new CourseOrderDetail(1,2,3,400,5,"上架中");
		CourseOrderDetailDaoImpl b=new CourseOrderDetailDaoImpl();
		CourseOrderDetail c=new CourseOrderDetail(1,2,3,500,6,"下架中");
//		b.insert(a);
//		b.deleteByID(1);
//		b.updateByID(c);
//		System.out.println(b.selectByID(1).getCourseOrderDetailStatus());
//		System.out.println(b.selectAll().get(0).getCourseOrderDetailStatus());

	}

	@Override
	public int insert(CourseOrderDetail CourseOrderDetail) {
		getSession().persist(CourseOrderDetail);
		return CourseOrderDetail.getCourseOrderDetailID();
	}
	@Override
	public int deleteByID(Integer CourseOrderDetailID) {
		Session session=getSession();
		CourseOrderDetail courseOrderDetail=session.get(CourseOrderDetail.class, CourseOrderDetailID);
		session.remove(courseOrderDetail);
		return CourseOrderDetailID;
	}

	@Override
	public int updateByID(CourseOrderDetail CourseOrderDetail) {
		getSession().update(CourseOrderDetail);
		return CourseOrderDetail.getCourseOrderDetailID();
	}

	@Override
	public CourseOrderDetail selectByID(Integer CourseOrderDetailID) {
		CourseOrderDetail courseOrderDetail=getSession().get(CourseOrderDetail.class, CourseOrderDetailID);
		return courseOrderDetail;
	}

	@Override
	public List<CourseOrderDetail> selectAll() throws ClassNotFoundException {
		return getSession().createQuery("FROM CourseOrderDetail",CourseOrderDetail.class).list();
	}

}
