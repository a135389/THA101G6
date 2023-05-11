package courseOrder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import courseOrder.model.CourseOrder;




public class CourseOrderDaoImpl implements CourseOrderDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	public static void main(String[] args) throws ClassNotFoundException {
		CourseOrder a=new CourseOrder(1,2,300,Timestamp.valueOf("2023-04-30 00:00:00"));
		CourseOrderDaoImpl b=new CourseOrderDaoImpl();
		CourseOrder c=new CourseOrder(1,2,500,Timestamp.valueOf("2025-04-30 00:00:00"));
//		b.insert(a);
//		b.deleteByID(1);
//		b.updateByID(c);
//		System.out.println(b.selectByID(1).getCourseOrderID());
//		System.out.println(b.selectAll().get(0).getCourseOrderID());

	}
	@Override
	public int insert(CourseOrder CourseOrder) {
		String sql = "insert into CourseOrder values(?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, CourseOrder.getCourseOrderID());
			pstmt.setInt(2, CourseOrder.getUserID());
			pstmt.setInt(3, CourseOrder.getTotalPrice());
			pstmt.setTimestamp(4, CourseOrder.getBuyDateTime());

			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public int deleteByID(Integer CourseOrderID) {
		String sql = "delete from CourseOrder where courseOrderID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,CourseOrderID);
			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public int updateByID(CourseOrder CourseOrder) {
		String sql = "update CourseOrder set userID =?,totalPrice=?,buyDateTime=? "
				+ "where courseOrderID=?;";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,CourseOrder.getUserID());
			pstmt.setInt(2,CourseOrder.getTotalPrice());
			pstmt.setTimestamp(3,CourseOrder.getBuyDateTime());
			pstmt.setInt(4,CourseOrder.getCourseOrderID());


			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public CourseOrder selectByID(Integer CourseOrderID) {
		String sql = "select * from CourseOrder where courseOrderID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,CourseOrderID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					CourseOrder CourseOrder = new CourseOrder();
					
					CourseOrder.setCourseOrderID(rs.getInt("courseOrderID"));
					CourseOrder.setUserID(rs.getInt("userID"));
					CourseOrder.setTotalPrice(rs.getInt("totalPrice"));
					CourseOrder.setBuyDateTime(rs.getTimestamp("buyDateTime"));


					return CourseOrder; // 回傳一個物件
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<CourseOrder> selectAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * from CourseOrder ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<CourseOrder> list = new ArrayList<CourseOrder>();
			while (rs.next()) {
				CourseOrder CourseOrder = new CourseOrder();
				CourseOrder.setCourseOrderID(rs.getInt("courseOrderID"));
				CourseOrder.setUserID(rs.getInt("userID"));
				CourseOrder.setTotalPrice(rs.getInt("totalPrice"));
				CourseOrder.setBuyDateTime(rs.getTimestamp("buyDateTime"));

				list.add(CourseOrder);
			}
			return list; // 回傳一個陣列
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
