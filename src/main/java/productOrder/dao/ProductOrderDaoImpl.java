package productOrder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import productOrder.model.ProductOrder;



public class ProductOrderDaoImpl implements ProductOrderDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";

	public static void main(String[] args) throws ClassNotFoundException {
			ProductOrderDaoImpl a=new ProductOrderDaoImpl();
			ProductOrder b=new ProductOrder(1,2,300,"dd",Timestamp.valueOf("2023-04-30 00:00:00"),"dd");
			ProductOrder c=new ProductOrder(1,2,500,"dd",Timestamp.valueOf("2023-04-30 00:00:00"),"dd");
			//a.insert(b);
			//a.deleteByID(1);
			//a.updateByID(c);
			//System.out.println("ProductOrderID:"+a.selectByID(1).getProductOrderID());
			//System.out.println(a.selectAll().get(0).getProductOrderID());
			
			

	}

	@Override
	public int insert(ProductOrder ProductOrder) {
		String sql = "insert into ProductOrder values(?,?,?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, ProductOrder.getProductOrderID());
			pstmt.setInt(2, ProductOrder.getUserID());
			pstmt.setInt(3, ProductOrder.getTotalPrice());
			pstmt.setString(4, ProductOrder.getDeliveryAddr());
			pstmt.setTimestamp(5, ProductOrder.getBuyDateTime());
			pstmt.setString(6, ProductOrder.getProductOrderStatus());

			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteByID(Integer productOrderID) {
		String sql = "delete from ProductOrder where ProductOrderID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,productOrderID);
			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByID(ProductOrder ProductOrder) {
		String sql = "update ProductOrder set userID =?,totalPrice=?,deliveryAddr=?,buyDateTime=?,ProductOrderStatus=? "
				+ "where productOrderID=?;";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,ProductOrder.getUserID());
			pstmt.setInt(2,ProductOrder.getTotalPrice());
			pstmt.setString(3,ProductOrder.getDeliveryAddr());
			pstmt.setTimestamp(4,ProductOrder.getBuyDateTime());
			pstmt.setString(5,ProductOrder.getProductOrderStatus());
			pstmt.setInt(6,ProductOrder.getProductOrderID());


			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ProductOrder selectByID(Integer productOrderID) {
		String sql = "select * from ProductOrder where productOrderID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,productOrderID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ProductOrder ProductOrder = new ProductOrder();
					
					ProductOrder.setProductOrderID(rs.getInt("productOrderID"));
					ProductOrder.setUserID(rs.getInt("userID"));
					ProductOrder.setTotalPrice(rs.getInt("totalPrice"));
					ProductOrder.setDeliveryAddr(rs.getString("deliveryAddr"));
					ProductOrder.setBuyDateTime(rs.getTimestamp("buyDateTime"));
					ProductOrder.setProductOrderStatus(rs.getString("productOrderStatus"));


					return ProductOrder; // 回傳一個物件
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductOrder> selectAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * from ProductOrder ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<ProductOrder> list = new ArrayList<ProductOrder>();
			while (rs.next()) {
				ProductOrder ProductOrder = new ProductOrder();
				
				ProductOrder.setProductOrderID(rs.getInt("productOrderID"));
				ProductOrder.setUserID(rs.getInt("userID"));
				ProductOrder.setTotalPrice(rs.getInt("totalPrice"));
				ProductOrder.setDeliveryAddr(rs.getString("deliveryAddr"));
				ProductOrder.setBuyDateTime(rs.getTimestamp("buyDateTime"));
				ProductOrder.setProductOrderStatus(rs.getString("productOrderStatus"));

				list.add(ProductOrder);
			}
			return list; // 回傳一個陣列
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
