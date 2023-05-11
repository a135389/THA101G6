package courseOrderDetail.dao;

import java.util.List;

import courseOrderDetail.model.CourseOrderDetail;




public interface CourseOrderDetailDao {
	int insert(CourseOrderDetail CourseOrderDetail);

	int deleteByID(Integer CourseOrderDetailID);

	int updateByID(CourseOrderDetail CourseOrderDetail);

	CourseOrderDetail selectByID(Integer CourseOrderDetailID);

	List<CourseOrderDetail> selectAll() throws ClassNotFoundException;

}
