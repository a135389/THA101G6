package order.productCar.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import order.productCar.model.ProductCar;



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
	public int deleteAllByUserID(Integer userID) {
		Session session=getSession();
		String hql="DELETE FROM ProductCar WHERE userID = :userID";
		Query query=session.createQuery(hql);
		query.setInteger("userID", userID);
		return query.executeUpdate();
		
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


	@Override
	public List<ProductCar> selectAllByUserID(Integer userID) throws ClassNotFoundException {

		return getSession().createQuery("FROM ProductCar WHERE userID = "+userID,ProductCar.class).list();
	}

}
