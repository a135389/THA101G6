package order.courseCar.dao;

import java.util.List;

import core.CoreDao;
import order.courseCar.model.CourseCar;





public interface CourseCarDao extends CoreDao{
	CourseCarPK insert(CourseCar CourseCar);

	CourseCarPK deleteByID(CourseCarPK id);
	
	int deleteAllByUserID(Integer userID);

	CourseCarPK updateByID(CourseCar CourseCar);

	CourseCar selectByID(CourseCarPK id);

	List<CourseCar> selectAll() throws ClassNotFoundException;
	
	List<CourseCar> selectAllByUserID(Integer userID) throws ClassNotFoundException;

}
