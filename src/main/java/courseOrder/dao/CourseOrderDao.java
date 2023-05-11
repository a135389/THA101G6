package courseOrder.dao;

import java.util.List;

import courseOrder.model.CourseOrder;



public interface CourseOrderDao {
	int insert(CourseOrder CourseOrder);

	int deleteByID(Integer CourseOrderID);

	int updateByID(CourseOrder CourseOrder);

	CourseOrder selectByID(Integer CourseOrderID);

	List<CourseOrder> selectAll() throws ClassNotFoundException;

}
