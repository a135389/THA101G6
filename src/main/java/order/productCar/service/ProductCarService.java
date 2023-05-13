package order.productCar.service;

import java.util.List;

import order.productCar.dao.ProductCarPK;
import order.productCar.model.ProductCar;

public interface ProductCarService {
	
	//讀取並列出購物車內容
	List<ProductCar> ListCar(Integer userID);
	//加入購物車
	void addCar(ProductCar productCar);
	//從購物車移除
	void removeCar(ProductCarPK productCarPK);
	//清空購物車
	void cleanCar(Integer userID);
	//小計
	Integer subTotal(Integer userID);
	//資料檢查
	boolean dataCheck();
	//將購物車的資料存至訂單
	void carPush(Integer userID,String deliveryAddr);
	//送出申請
	void sendAply(Integer userID,String deliveryAddr);

}
