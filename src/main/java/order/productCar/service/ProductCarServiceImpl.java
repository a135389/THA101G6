package order.productCar.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;
import course.model.Course;
import order.courseCar.model.CourseCar;
import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;
import order.productCar.dao.ProductCarDao;
import order.productCar.dao.ProductCarDaoImpl;
import order.productCar.dao.ProductCarPK;
import order.productCar.model.ProductCar;
import order.productOrder.model.ProductOrder;
import order.productOrderDetail.model.ProductOrderDetail;
import product.model.Product;

public class ProductCarServiceImpl implements ProductCarService{
	private ProductCarDao dao;	
	static Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	public ProductCarServiceImpl() {
		dao=new ProductCarDaoImpl();
	}
	@Override
	public List<ProductCar> ListCar(Integer userID) {
		try {
			return dao.selectAllByUserID(userID);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addCar(ProductCar productCar) {
		if(session.get(ProductCar.class,productCar.getId())==null) {
			dao.insert(productCar);

		}else {
			System.out.println("購物車已有同一商品");
		}
		
	}

	@Override
	public void removeCar(ProductCarPK productCarPK) {
		try {
			dao.deleteByID(productCarPK);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.err.println("無此資料");
		}
		
	}

	@Override
	public void cleanCar(Integer userID) {
		try {
			System.out.println("刪除使用者"+userID+"的"+dao.deleteAllByUserID(userID)+"筆購物車資料");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("清空購物車失敗");
		}
		
	}

	@Override
	public Integer subTotal(Integer userID) {
		Integer total=0;
		
		try {
			List<ProductCar> list=dao.selectAllByUserID(userID);
			for(ProductCar productCar:list) {
				int productId=productCar.getId().getProductID();
				Product product=session.get(Product.class, productId);
				int price=product.getProductPrice();
				int quantity=productCar.getQuantity();
				total=total+(price*quantity);
				
			}
			return total;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("計算總額失敗");
			return null;
		}
	
	}

	@Override
	public boolean dataCheck() {
		
		return false;
	}

	@Override
	public void carPush(Integer userID,String deliveryAddr) {
		try {
			List<ProductCar>list=dao.selectAllByUserID(userID);
			ProductOrder productOrder=new ProductOrder(null,userID,subTotal(userID),deliveryAddr,Timestamp.from(Instant.now()),"已收到訂單");
			session.persist(productOrder);
			int productOrderID=productOrder.getProductOrderID();
			for(ProductCar productCar:list) {
				int productID=productCar.getId().getProductID();
				int productPrice=session.get(Product.class,productID).getProductPrice();
				int quantity=productCar.getQuantity();
				ProductOrderDetail productOrderDetail=new ProductOrderDetail(null,productOrderID,productID,productPrice,quantity);
				session.persist(productOrderDetail);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("送出購物車失敗");
		}
		
	}

	@Override
	public void sendAply(Integer userID,String deliveryAddr) {
		carPush(userID,deliveryAddr);
		cleanCar(userID);
		
	}

}
