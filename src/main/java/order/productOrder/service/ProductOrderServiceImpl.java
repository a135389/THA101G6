package order.productOrder.service;

import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;
import order.productOrder.dao.ProductOrderDao;
import order.productOrder.dao.ProductOrderDaoImpl;
import order.productOrder.model.ProductOrder;
import order.productOrderDetail.model.ProductOrderDetail;

public class ProductOrderServiceImpl implements ProductOrderService{
	private ProductOrderDao dao;
	static Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	public ProductOrderServiceImpl() {
		dao=new ProductOrderDaoImpl();
	}
	@Override
	public List<ProductOrder> listOrderByID(Integer userID) {
		try {
			return dao.selectAllByUserID(userID);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("取得購物車失敗");
			return null;
		}
	}

	@Override
	public List<Integer> getIdByUserName(String userName) {
		return dao.getIdByUserName(userName);
		//可能查到同名的會員或無資料,需要送到controller做處理
	}

	@Override
	public List<ProductOrderDetail> listOrderDetail(Integer productOrderID) {
		return dao.selectDetailByOrderID(productOrderID);
	}

}
