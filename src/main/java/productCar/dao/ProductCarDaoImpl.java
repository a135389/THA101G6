package productCar.dao;


import java.util.List;
import org.hibernate.Session;

import courseCar.model.CourseCar;
import productCar.model.ProductCar;



public class ProductCarDaoImpl implements ProductCarDao{

	@Override
	public ProductCarPK insert(ProductCar ProductCar) {
		getSession().persist(ProductCar);
		return ProductCar.getId();
	}

	@Override
	public ProductCarPK deleteByID(ProductCarPK id) {
		Session session=getSession();
		ProductCar productCar=session.get(ProductCar.class,id);
		getSession().remove(productCar);
		return id;
	}

	@Override
	public ProductCarPK updateByID(ProductCar ProductCar) {
		getSession().update(ProductCar);
		return ProductCar.getId();
	}

	@Override
	public ProductCar selectByID(ProductCarPK id) {
		ProductCar productCar=getSession().get(ProductCar.class, id);
		
		return productCar;
	}

	@Override
	public List<ProductCar> selectAll() throws ClassNotFoundException {
		
		return getSession().createQuery("FROM ProductCar",ProductCar.class).list();
	}

}
