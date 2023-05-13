package product.dao;

import java.util.List;

import product.model.Product;



public interface ProductDao {
	int insert(Product product);

	int updateByProductID(Product product);
	
	int deleteByProductID(Integer productID);

	List<Product> selectByProductClass(String productClass);
	
	List<Product> selectByProductID(Integer productID);

	List<Product> selectByProductName(String productName);

	List<Product> selectAll() throws ClassNotFoundException;
}
