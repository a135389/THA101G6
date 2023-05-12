package productCar.dao;

import java.util.List;

import core.CoreDao;
import productCar.model.ProductCar;



public interface ProductCarDao extends CoreDao{
	ProductCarPK insert(ProductCar ProductCar);

	ProductCarPK deleteByID(ProductCarPK id);

	ProductCarPK updateByID(ProductCar ProductCar);

	ProductCar selectByID(ProductCarPK id);

	List<ProductCar> selectAll() throws ClassNotFoundException;
}
