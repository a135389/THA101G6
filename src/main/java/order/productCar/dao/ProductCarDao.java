package order.productCar.dao;

import java.util.List;

import core.CoreDao;
import order.productCar.model.ProductCar;




public interface ProductCarDao extends CoreDao{
	ProductCarPK insert(ProductCar ProductCar);

	ProductCarPK deleteByID(ProductCarPK id);
	
	int deleteAllByUserID(Integer userID);

	ProductCarPK updateByID(ProductCar ProductCar);

	ProductCar selectByID(ProductCarPK id);

	List<ProductCar> selectAll() throws ClassNotFoundException;
	
	List<ProductCar> selectAllByUserID(Integer userID) throws ClassNotFoundException;
}
