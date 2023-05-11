package productCar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import productCar.model.ProductCar;



public class ProductCarDaoImpl implements ProductCarDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	@Override
	public int insert(ProductCar ProductCar) {
		String sql = "insert into ProductCar values(?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, ProductCar.getUserID());
			pstmt.setInt(2, ProductCar.getProductID());
			pstmt.setInt(3, ProductCar.getQuantity());
			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteByID(Integer userID, Integer productID) {
		String sql = "delete from ProductCar where userID = ? and productID= ?";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, userID);
			pstmt.setInt(2, productID);
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}

	@Override
	public int updateByID(ProductCar ProductCar) {
		String sql = "update ProductCar set quantity=?\r\n"
				+ "where userID=? and productID=?;";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, ProductCar.getQuantity());
			pstmt.setInt(2, ProductCar.getUserID());
			pstmt.setInt(3, ProductCar.getProductID());

			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ProductCar selectByID(Integer userID, Integer productID) {
		String sql = "select * from ProductCar where userID = ? and productID = ?";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, userID);
			pstmt.setInt(2, productID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ProductCar ProductCar = new ProductCar();
					ProductCar.setUserID(rs.getInt("userID"));
					ProductCar.setProductID(rs.getInt("ProductID"));
					ProductCar.setQuantity(rs.getInt("quantity"));

					return ProductCar; // 回傳一個物件
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public List<ProductCar> selectAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * from ProductCar ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<ProductCar> list = new ArrayList<ProductCar>();
			while (rs.next()) {
				ProductCar ProductCar = new ProductCar();
				ProductCar.setUserID(rs.getInt("userID"));
				ProductCar.setProductID(rs.getInt("productID"));
				ProductCar.setQuantity(rs.getInt("quantity"));

				list.add(ProductCar);
			}
			return list; // 回傳一個陣列
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String args[]) throws ClassNotFoundException {
	ProductCar a=new ProductCar(1,2,3);
	ProductCar c=new ProductCar(1,2,5);
	ProductCarDaoImpl b=new ProductCarDaoImpl();
//	b.insert(a);
//	b.deleteByID(1,2);
//	b.updateByID(c);
//	System.out.println("數量:"+b.selectByID(1, 2).getQuantity());
//	System.out.println(b.selectAll().get(0).getProductID());
	
	}
}
