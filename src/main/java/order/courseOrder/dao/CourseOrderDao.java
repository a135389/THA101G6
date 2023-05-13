package order.courseOrder.dao;

import java.util.List;

import core.CoreDao;
import order.courseOrder.model.CourseOrder;




public interface CourseOrderDao extends CoreDao{
	int insert(CourseOrder CourseOrder);

	int deleteByID(Integer CourseOrderID);

	int updateByID(CourseOrder CourseOrder);

	CourseOrder selectByID(Integer CourseOrderID);

	List<CourseOrder> selectAll() throws ClassNotFoundException;

}
