package productOrder.dao;

import java.util.List;

import productOrder.model.ProductOrder;



public interface ProductOrderDao {
	int insert(ProductOrder ProductOrder);

	int deleteByID(Integer productOrderID);

	int updateByID(ProductOrder ProductCar);

	ProductOrder selectByID(Integer productOrderID);

	List<ProductOrder> selectAll() throws ClassNotFoundException;
}
