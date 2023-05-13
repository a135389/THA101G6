package course.dao;

import java.util.List;

import course.model.Course;

public interface CourseDAO {
	int insertCourse(Course course) ;
    Course getCourseByCourseId(int courseId) ;
    List<Course> getAllCourses() throws ClassNotFoundException;
    int updateByCourseId(Course course) ;
    int deleteByCourseId(int courseId) ;
}

