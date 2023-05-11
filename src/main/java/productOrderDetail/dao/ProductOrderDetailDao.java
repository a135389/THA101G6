package productOrderDetail.dao;

import java.util.List;

import productOrderDetail.model.ProductOrderDetail;



public interface ProductOrderDetailDao {
	int insert(ProductOrderDetail ProductOrderDetail);

	int deleteByID(Integer ProductOrderDetailID);

	int updateByID(ProductOrderDetail ProductOrderDetail);

	ProductOrderDetail selectByID(Integer ProductOrderDetailID);

	List<ProductOrderDetail> selectAll() throws ClassNotFoundException;
}
