package order.productOrder.dao;

import java.util.List;

import org.hibernate.Session;

import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;
import order.productOrder.model.ProductOrder;
import order.productOrderDetail.model.ProductOrderDetail;




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

	@Override
	public List<Integer> getIdByUserName(String userName) {
		List<Integer>list=getSession().createQuery("SELECT userID FROM Member WHERE userName = '"+userName+"'",Integer.class).list();
		return list;
	}

	@Override
	public List<ProductOrder> selectAllByUserID(Integer userID) throws ClassNotFoundException {
		return getSession().createQuery("FROM ProductOrder WHERE userID = "+userID,ProductOrder.class).list();
	}

	@Override
	public List<ProductOrderDetail> selectDetailByOrderID(Integer productOrderID) {
		return getSession().createQuery("FROM ProductOrderDetail WHERE productOrderID = "+productOrderID,ProductOrderDetail.class).list();
	}

}
