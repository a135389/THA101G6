package order.courseOrder.dao;

import java.util.List;

import core.CoreDao;
import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;




public interface CourseOrderDao extends CoreDao{
	int insert(CourseOrder CourseOrder);

	int deleteByID(Integer CourseOrderID);

	int updateByID(CourseOrder CourseOrder);
	
	List<Integer> getIdByUserName(String userName);

	CourseOrder selectByID(Integer CourseOrderID);

	List<CourseOrder> selectAll() throws ClassNotFoundException;
	
	List<CourseOrder> selectAllByUserID(Integer userID) throws ClassNotFoundException;
	
	List<CourseOrderDetail> selectDetailByOrderID(Integer courseOrderID);

}
