package courseOrderDetail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import courseOrderDetail.model.CourseOrderDetail;



public class CourseOrderDetailDaoImpl implements CourseOrderDetailDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	public static void main(String[] args) throws ClassNotFoundException {
		CourseOrderDetail a=new CourseOrderDetail(1,2,3,400,5,"上架中");
		CourseOrderDetailDaoImpl b=new CourseOrderDetailDaoImpl();
		CourseOrderDetail c=new CourseOrderDetail(1,2,3,500,6,"下架中");
//		b.insert(a);
//		b.deleteByID(1);
//		b.updateByID(c);
//		System.out.println(b.selectByID(1).getCourseOrderDetailStatus());
//		System.out.println(b.selectAll().get(0).getCourseOrderDetailStatus());

	}

	@Override
	public int insert(CourseOrderDetail CourseOrderDetail) {
		String sql = "insert into CourseOrderDetail values(?,?,?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, CourseOrderDetail.getCourseOrderDetailID());
			pstmt.setInt(2, CourseOrderDetail.getCourseOrderID());
			pstmt.setInt(3, CourseOrderDetail.getCourseID());
			pstmt.setInt(4, CourseOrderDetail.getCoursePrice());
			pstmt.setInt(5, CourseOrderDetail.getQuantity());
			pstmt.setString(6, CourseOrderDetail.getCourseOrderDetailStatus());
			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public int deleteByID(Integer CourseOrderDetailID) {
		String sql = "delete from CourseOrderDetail where courseOrderDetailID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,CourseOrderDetailID);
			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByID(CourseOrderDetail CourseOrderDetail) {
		String sql = "update CourseOrderDetail set courseOrderID =?,courseID=?,coursePrice=?,quantity=?,courseOrderDetailStatus=? "
				+ "where courseOrderDetailID=?;";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, CourseOrderDetail.getCourseOrderID());
			pstmt.setInt(2, CourseOrderDetail.getCourseID());
			pstmt.setInt(3, CourseOrderDetail.getCoursePrice());
			pstmt.setInt(4, CourseOrderDetail.getQuantity());
			pstmt.setString(5, CourseOrderDetail.getCourseOrderDetailStatus());
			pstmt.setInt(6, CourseOrderDetail.getCourseOrderDetailID());


			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public CourseOrderDetail selectByID(Integer CourseOrderDetailID) {
		String sql = "select * from CourseOrderDetail where courseOrderDetailID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,CourseOrderDetailID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					CourseOrderDetail CourseOrderDetail = new CourseOrderDetail();
					
					CourseOrderDetail.setCourseOrderDetailID(rs.getInt("courseOrderDetailID"));
					CourseOrderDetail.setCourseOrderID(rs.getInt("courseOrderID"));
					CourseOrderDetail.setCourseID(rs.getInt("courseID"));
					CourseOrderDetail.setCoursePrice(rs.getInt("coursePrice"));
					CourseOrderDetail.setQuantity(rs.getInt("quantity"));
					CourseOrderDetail.setCourseOrderDetailStatus(rs.getString("courseOrderDetailStatus"));
					return CourseOrderDetail; // 回傳一個物件
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CourseOrderDetail> selectAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * from CourseOrderDetail ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<CourseOrderDetail> list = new ArrayList<CourseOrderDetail>();
			while (rs.next()) {
				CourseOrderDetail CourseOrderDetail = new CourseOrderDetail();
				
				CourseOrderDetail.setCourseOrderDetailID(rs.getInt("courseOrderDetailID"));
				CourseOrderDetail.setCourseOrderID(rs.getInt("courseOrderID"));
				CourseOrderDetail.setCourseID(rs.getInt("courseID"));
				CourseOrderDetail.setCoursePrice(rs.getInt("coursePrice"));
				CourseOrderDetail.setQuantity(rs.getInt("quantity"));
				CourseOrderDetail.setCourseOrderDetailStatus(rs.getString("courseOrderDetailStatus"));

				list.add(CourseOrderDetail);
			}
			return list; // 回傳一個陣列
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
