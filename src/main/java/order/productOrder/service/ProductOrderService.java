package order.productOrder.service;

import java.util.List;

import order.productOrder.model.ProductOrder;
import order.productOrderDetail.model.ProductOrderDetail;

public interface ProductOrderService {
	//以id取得該使用者所有訂單
	List<ProductOrder> listOrderByID(Integer userID);
	//以姓名查詢該使用者id,考慮到同名狀況,size()>1時需要再從前端選擇會員,並送出一個ID來查詢
	List<Integer> getIdByUserName(String userName);
	//取得該訂單主檔所有明細
	List<ProductOrderDetail>listOrderDetail(Integer productOrderID);

}
