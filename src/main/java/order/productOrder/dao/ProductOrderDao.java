package order.productOrder.dao;

import java.util.List;

import core.CoreDao;
import order.productOrder.model.ProductOrder;




public interface ProductOrderDao extends CoreDao{
	int insert(ProductOrder ProductOrder);

	int deleteByID(Integer productOrderID);

	int updateByID(ProductOrder ProductCar);

	ProductOrder selectByID(Integer productOrderID);

	List<ProductOrder> selectAll() throws ClassNotFoundException;
}
