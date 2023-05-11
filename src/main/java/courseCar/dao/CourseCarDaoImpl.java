package courseCar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import courseCar.model.CourseCar;




public class CourseCarDaoImpl implements CourseCarDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	public static void main(String[] args) throws ClassNotFoundException {
		CourseCar a=new CourseCar(1,2,1);
		CourseCarDaoImpl b=new CourseCarDaoImpl();
		CourseCar c=new CourseCar(1,2,3);
//		b.insert(a);
//		b.deleteByID(1, 2);
//		b.updateByID(c);
//		System.out.println("UserID:"+b.selectByID(1,2).getUserID());
//		System.out.println(b.selectAll().get(0).getUserID());

	}

	@Override
	public void insert(CourseCar CourseCar) {
//		String sql = "insert into CourseCar values(?,?,?)";
//		try (Connection conn = DriverManager.getConnection(url, user, passwd);
//				PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setInt(1, CourseCar.getUserID());
//			pstmt.setInt(2, CourseCar.getCourseID());
//			pstmt.setInt(3, CourseCar.getQuantity());
//			
//			return pstmt.executeUpdate(); // 回傳0到N
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
		getSession().persist(CourseCar);
		System.out.println(CourseCar.getCourseID());
		
	}

	@Override
	public int deleteByID(Integer userID, Integer courseID) {
		String sql = "delete from CourseCar where userID = ? and courseID= ?";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, userID);
			pstmt.setInt(2, courseID);
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByID(CourseCar CourseCar) {
		String sql = "update CourseCar set quantity=? "
				+ "where userID=? and courseID=?;";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, CourseCar.getQuantity());
			pstmt.setInt(2, CourseCar.getUserID());
			pstmt.setInt(3, CourseCar.getCourseID());

			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public CourseCar selectByID(Integer userID, Integer courseID) {
		String sql = "select * from CourseCar where userID = ? and courseID = ?";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, userID);
			pstmt.setInt(2, courseID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					CourseCar CourseCar = new CourseCar();
					CourseCar.setUserID(rs.getInt("userID"));
					CourseCar.setCourseID(rs.getInt("courseID"));
					CourseCar.setQuantity(rs.getInt("quantity"));

					return CourseCar; // 回傳一個物件
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CourseCar> selectAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * from CourseCar ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<CourseCar> list = new ArrayList<CourseCar>();
			while (rs.next()) {
				CourseCar CourseCar = new CourseCar();
				CourseCar.setUserID(rs.getInt("userID"));
				CourseCar.setCourseID(rs.getInt("courseID"));
				CourseCar.setQuantity(rs.getInt("quantity"));

				list.add(CourseCar);
			}
			return list; // 回傳一個陣列
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
