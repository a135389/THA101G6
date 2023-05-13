package order.productOrder.dao;

import java.util.List;

import org.hibernate.Session;

import order.productOrder.model.ProductOrder;




public class ProductOrderDaoImpl implements ProductOrderDao{


	@Override
	public int insert(ProductOrder ProductOrder) {
		getSession().persist(ProductOrder);
		return ProductOrder.getProductOrderID();
	}

	@Override
	public int deleteByID(Integer productOrderID) {
		Session session=getSession();
		ProductOrder productOrder=session.get(ProductOrder.class, productOrderID);
		session.remove(productOrder);
		return productOrderID;
	}

	@Override
	public int updateByID(ProductOrder ProductOrder) {
		getSession().update(ProductOrder);
		return ProductOrder.getProductOrderID();
	}

	@Override
	public ProductOrder selectByID(Integer productOrderID) {
		ProductOrder productOrder=getSession().get(ProductOrder.class, productOrderID);
		return productOrder;
	}

	@Override
	public List<ProductOrder> selectAll() throws ClassNotFoundException {
		return getSession().createQuery("FROM ProductOrder",ProductOrder.class).list();
	}

}