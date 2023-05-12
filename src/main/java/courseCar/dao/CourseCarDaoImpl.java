package courseCar.dao;


import java.util.List;

import org.hibernate.Session;

import courseCar.model.CourseCar;




public class CourseCarDaoImpl implements CourseCarDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	public static void main(String[] args) throws ClassNotFoundException {
		CourseCarPK a=new CourseCarPK(3,4);
		CourseCarDaoImpl b=new CourseCarDaoImpl();
		CourseCar c=new CourseCar(a,3);
//		b.insert(a);
//		b.deleteByID(1, 2);
//		b.updateByID(c);
//		System.out.println("UserID:"+b.selectByID(1,2).getUserID());
//		System.out.println(b.selectAll().get(0).getUserID());

	}

	@Override
	public CourseCarPK insert(CourseCar CourseCar) {
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
		return CourseCar.getId();
		
	}

	@Override
	public CourseCarPK deleteByID(CourseCarPK id) {
//		String sql = "delete from CourseCar where userID = ? and courseID= ?";
//		try (Connection conn = DriverManager.getConnection(url, user, passwd);
//				PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setInt(1, userID);
//			pstmt.setInt(2, courseID);
//			return pstmt.executeUpdate(); // 回傳0到N
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
		Session session=getSession();
		CourseCar courseCar=session.get(CourseCar.class,id);
		getSession().remove(courseCar);
		return id;
	}
	
	@Override
	public int deleteAllByUserID(Integer userID) {
		Session session=getSession();
		return session.createQuery("DELETE FROM CourseCar WHERE userID = "+userID,CourseCar.class).executeUpdate();
		
	}

	@Override
	public CourseCarPK updateByID(CourseCar CourseCar) {
//		String sql = "update CourseCar set quantity=? "
//				+ "where userID=? and courseID=?;";
//		try (Connection conn = DriverManager.getConnection(url, user, passwd);
//				PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setInt(1, CourseCar.getQuantity());
//			pstmt.setInt(2, CourseCar.getUserID());
//			pstmt.setInt(3, CourseCar.getCourseID());
//
//			return pstmt.executeUpdate(); // 回傳0到N
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
		
		getSession().update(CourseCar);
		return CourseCar.getId();
	}

	@Override
	public CourseCar selectByID(CourseCarPK id) {
//		String sql = "select * from CourseCar where userID = ? and courseID = ?";
//		try (Connection conn = DriverManager.getConnection(url, user, passwd);
//				PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setInt(1, userID);
//			pstmt.setInt(2, courseID);
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					CourseCar CourseCar = new CourseCar();
//					CourseCar.setUserID(rs.getInt("userID"));
//					CourseCar.setCourseID(rs.getInt("courseID"));
//					CourseCar.setQuantity(rs.getInt("quantity"));
//
//					return CourseCar; // 回傳一個物件
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		CourseCar courseCar=getSession().get(CourseCar.class, id);
		return courseCar;
	}

	@Override
	public List<CourseCar> selectAll() throws ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String sql = "select * from CourseCar ";
//		try (Connection conn = DriverManager.getConnection(url, user, passwd);
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();) {
//			List<CourseCar> list = new ArrayList<CourseCar>();
//			while (rs.next()) {
//				CourseCar CourseCar = new CourseCar();
//				CourseCar.setUserID(rs.getInt("userID"));
//				CourseCar.setCourseID(rs.getInt("courseID"));
//				CourseCar.setQuantity(rs.getInt("quantity"));
//
//				list.add(CourseCar);
//			}
//			return list; // 回傳一個陣列
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		return getSession().createQuery("FROM CourseCar",CourseCar.class).list();
		
	}

	@Override
	public List<CourseCar> selectAllByUserID(Integer userID) throws ClassNotFoundException {
		return getSession().createQuery("FROM CourseCar WHERE userID = "+userID,CourseCar.class).list();
		
	}



}
