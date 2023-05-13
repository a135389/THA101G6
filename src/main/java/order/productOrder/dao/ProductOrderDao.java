package order.productOrder.dao;

import java.util.List;

import core.CoreDao;
import order.productOrder.model.ProductOrder;
import order.productOrderDetail.model.ProductOrderDetail;




public interface ProductOrderDao extends CoreDao{
	int insert(ProductOrder ProductOrder);

	int deleteByID(Integer productOrderID);

	int updateByID(ProductOrder ProductCar);
	
	List<Integer> getIdByUserName(String userName);

	ProductOrder selectByID(Integer productOrderID);

	List<ProductOrder> selectAll() throws ClassNotFoundException;
	
	List<ProductOrder> selectAllByUserID(Integer userID) throws ClassNotFoundException;
	
	List<ProductOrderDetail> selectDetailByOrderID(Integer productOrderID);
}
