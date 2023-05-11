package courseCar.dao;

import java.util.List;

import core.CoreDao;
import courseCar.model.CourseCar;




public interface CourseCarDao extends CoreDao{
	void insert(CourseCar CourseCar);

	int deleteByID(Integer userID,Integer courseID);

	int updateByID(CourseCar CourseCar);

	CourseCar selectByID(Integer userID,Integer courseID);

	List<CourseCar> selectAll() throws ClassNotFoundException;

}
