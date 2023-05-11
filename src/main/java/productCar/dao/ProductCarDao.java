package productCar.dao;

import java.util.List;

import productCar.model.ProductCar;



public interface ProductCarDao {
	int insert(ProductCar ProductCar);

	int deleteByID(Integer userID,Integer productID);

	int updateByID(ProductCar ProductCar);

	ProductCar selectByID(Integer userID,Integer productID);

	List<ProductCar> selectAll() throws ClassNotFoundException;
}
