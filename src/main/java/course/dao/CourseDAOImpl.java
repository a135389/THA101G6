package course.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import course.model.Course;

    public class CourseDAOImpl implements CourseDAO {
            
        @Override
    	public int insertCourse(Course course) {
        	String sql = "INSERT INTO course (courseName, classIntroduce, classMax, classMin, classPerson, classPrice, classPhoto, " +
                    "level, coachID, skill, pointID, classDate, startDate, endDate, classStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///PKtest", "root", "a1b2c3");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			 	pstmt.setString(1, course.getCourseName());
	            pstmt.setString(2, course.getCourseIntroduce());
	            pstmt.setInt(3, course.getCourseMax());
	            pstmt.setInt(4, course.getCourseMin());
	            pstmt.setInt(5, course.getCoursePerson());
	            pstmt.setDouble(6, course.getCoursePrice());
	            pstmt.setBytes(7, course.getCoursePhoto());
	            pstmt.setString(8, course.getLevel());
	            pstmt.setInt(9, course.getCoachID());
	            pstmt.setString(10, course.getSkill());
	            pstmt.setInt(11, course.getPointID());
	            pstmt.setString(12, course.getCourseDate());
	            pstmt.setString(13, course.getStartDate());
	            pstmt.setString(14, course.getEndDate());
	            pstmt.setString(15, course.getCourseStatus());   	         
    			return pstmt.executeUpdate();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
			return -1;
    	}
              
        @Override
    	public Course getCourseByCourseId(int courseId) {
        	String sql = "SELECT * FROM course WHERE courseId = ?";
    		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///PKtest", "root", "a1b2c3");
    				PreparedStatement pstmt = conn.prepareStatement(sql);) {
    			pstmt.setInt(1, courseId);
    			try (ResultSet rs = pstmt.executeQuery()) {
    				if (rs.next()) {
    					Course course = new Course();
		                course.setCourseID(rs.getInt("courseId"));
		                course.setCourseName(rs.getString("courseName"));
		                course.setCourseIntroduce(rs.getString("courseIntroduce"));
		                course.setCourseMax(rs.getInt("courseMax"));
		                course.setCourseMin(rs.getInt("courseMin"));
		                course.setCoursePerson(rs.getInt("coursePerson"));
		                course.setCoursePrice(rs.getInt("coursePrice"));
		                course.setCoursePhoto(rs.getBytes("coursePhoto"));
		                course.setLevel(rs.getString("level"));
		                course.setCoachID(rs.getInt("coachID"));
		                course.setSkill(rs.getString("skill"));
		                course.setPointID(rs.getInt("pointID"));
		                course.setCourseDate(rs.getString("courseDate"));
		                course.setStartDate(rs.getString("startDate"));
		                course.setEndDate(rs.getString("endDate"));
		                course.setCourseStatus(rs.getString("courseStatus"));
		                return course; 
    				}
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return null;
    	}
        
        @Override
    	public List<Course> getAllCourses() throws ClassNotFoundException {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String sql = "SELECT * FROM course";
    		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///PKtest", "root", "a1b2c3");
    				PreparedStatement pstmt = conn.prepareStatement(sql);
    				ResultSet rs = pstmt.executeQuery();) {
    			List<Course> courses = new ArrayList<Course>();
    			while (rs.next()) {
    				Course course = new Course();
                    course.setCourseID(rs.getInt("courseId"));
                    course.setCourseName(rs.getString("courseName"));
                    course.setCourseIntroduce(rs.getString("classIntroduce"));
                    course.setCourseMax(rs.getInt("classMax"));
                    course.setCourseMin(rs.getInt("classMin"));
                    course.setCoursePerson(rs.getInt("classPerson"));
                    course.setCoursePrice(rs.getInt("classPrice"));
                    course.setCoursePhoto(rs.getBytes("classPhoto"));
                    course.setLevel(rs.getString("level"));
                    course.setCoachID(rs.getInt("coachID"));
                    course.setSkill(rs.getString("skill"));
                    course.setPointID(rs.getInt("pointID"));
                    course.setCourseDate(rs.getString("classDate"));
                    course.setStartDate(rs.getString("startDate"));
                    course.setEndDate(rs.getString("endDate"));
                    course.setCourseStatus(rs.getString("classStatus"));
                    courses.add(course);
    			}
    			return courses; 
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return null;
    	}

    	@Override
        public int updateByCourseId(Course course) {
    		String sql = "UPDATE Course SET CourseName=?, classIntroduce=?, classMax=?, classMin=?, classPerson=?, " +
                    "classPrice=?, classPhoto=?, level=?, coachID=?, skill=?, pointID=?, classDate=?, startDate=?, " +
                    "endDate=?, classStatus=? WHERE CourseID=?";
    		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///PKtest", "root", "a1b2c3");
    			PreparedStatement pstmt = conn.prepareStatement(sql);) {
    			pstmt.setString(1, course.getCourseName());
                pstmt.setString(2, course.getCourseIntroduce());
                pstmt.setInt(3, course.getCourseMax());
                pstmt.setInt(4, course.getCourseMin());
                pstmt.setInt(5, course.getCoursePerson());
                pstmt.setDouble(6, course.getCoursePrice());
                pstmt.setBytes(7, course.getCoursePhoto());
                pstmt.setString(8, course.getLevel());
                pstmt.setInt(9, course.getCoachID());
                pstmt.setString(10, course.getSkill());
                pstmt.setInt(11, course.getPointID());
                pstmt.setString(12, course.getCourseDate());
                pstmt.setString(13, course.getStartDate());
                pstmt.setString(14, course.getEndDate());
                pstmt.setString(15, course.getCourseStatus());
                pstmt.setInt(16, course.getCourseID());
    			return pstmt.executeUpdate(); 
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return -1;
    	}
           
        @Override
        public int deleteByCourseId(int courseId) {
        	String sql = "DELETE FROM Course WHERE CourseID = ?";
    		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///PKtest", "root", "a1b2c3");
    			PreparedStatement pstmt = conn.prepareStatement(sql);) {
    			pstmt.setInt(1, courseId);
    			return pstmt.executeUpdate();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return -1;
    		}

    }

		
    
