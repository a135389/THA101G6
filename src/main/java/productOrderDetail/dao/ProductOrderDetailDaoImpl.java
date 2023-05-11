package productOrderDetail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import productOrderDetail.model.ProductOrderDetail;


public class ProductOrderDetailDaoImpl implements ProductOrderDetailDao{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/PKtest?serverTimezone=Asia/Taipei";
	String user = "root";
	String passwd = "a1b2c3";
	public static void main(String[] args) throws ClassNotFoundException {
		ProductOrderDetail a=new ProductOrderDetail(1,2,3,400,5);
		ProductOrderDetailDaoImpl b=new ProductOrderDetailDaoImpl();
		ProductOrderDetail c=new ProductOrderDetail(1,2,3,500,5);
		//b.insert(a);
		//b.deleteByID(1);
		//b.updateByID(c);
		//System.out.println("ProductOrderDetailID:"+b.selectByID(1).getProductOrderDetailID());
		//System.out.println(b.selectAll().get(0).getProductOrderDetailID());
	}

	@Override
	public int insert(ProductOrderDetail ProductOrderDetail) {
		String sql = "insert into ProductOrderDetail values(?,?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, ProductOrderDetail.getProductOrderDetailID());
			pstmt.setInt(2, ProductOrderDetail.getProductOrderID());
			pstmt.setInt(3, ProductOrderDetail.getProductID());
			pstmt.setInt(4, ProductOrderDetail.getProductPrice());
			pstmt.setInt(5, ProductOrderDetail.getQuantity());


			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteByID(Integer ProductOrderDetailID) {
		String sql = "delete from ProductOrderDetail where ProductOrderDetailID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,ProductOrderDetailID);
			
			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByID(ProductOrderDetail ProductOrderDetail) {
		String sql = "update ProductOrderDetail set productOrderID =?,productID=?,productPrice=?,quantity=? "
				+ "where productOrderDetailID=?;";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, ProductOrderDetail.getProductOrderID());
			pstmt.setInt(2, ProductOrderDetail.getProductID());
			pstmt.setInt(3, ProductOrderDetail.getProductPrice());
			pstmt.setInt(4, ProductOrderDetail.getQuantity());
			pstmt.setInt(5, ProductOrderDetail.getProductOrderDetailID());


			return pstmt.executeUpdate(); // 回傳0到N
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ProductOrderDetail selectByID(Integer ProductOrderDetailID) {
		String sql = "select * from ProductOrderDetail where productOrderDetailID = ? ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1,ProductOrderDetailID);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ProductOrderDetail ProductOrderDetail = new ProductOrderDetail();
					
					ProductOrderDetail.setProductOrderDetailID(rs.getInt("productOrderDetailID"));
					ProductOrderDetail.setProductOrderID(rs.getInt("productOrderID"));
					ProductOrderDetail.setProductID(rs.getInt("productID"));
					ProductOrderDetail.setProductPrice(rs.getInt("productPrice"));
					ProductOrderDetail.setQuantity(rs.getInt("quantity"));
					return ProductOrderDetail; // 回傳一個物件
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			
	}

	@Override
	public List<ProductOrderDetail> selectAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * from ProductOrderDetail ";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<ProductOrderDetail> list = new ArrayList<ProductOrderDetail>();
			while (rs.next()) {
				ProductOrderDetail ProductOrderDetail = new ProductOrderDetail();
				
				ProductOrderDetail.setProductOrderDetailID(rs.getInt("productOrderDetailID"));
				ProductOrderDetail.setProductOrderID(rs.getInt("productOrderID"));
				ProductOrderDetail.setProductID(rs.getInt("productID"));
				ProductOrderDetail.setProductPrice(rs.getInt("productPrice"));
				ProductOrderDetail.setQuantity(rs.getInt("quantity"));

				list.add(ProductOrderDetail);
			}
			return list; // 回傳一個陣列
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
