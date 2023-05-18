package order.courseOrder.service;

import java.util.List;

import order.courseOrder.model.CourseOrder;
import order.courseOrderDetail.model.CourseOrderDetail;

public interface CourseOrderService {
	//以id取得該使用者所有已通過審核的訂單,userID查詢CourseOrder取得CourseOrderID,再用以查詢courseOrderDetail中的courseID與coursePrice
	List<CourseOrder> listOrderByID(Integer userID);
	//以id取得該使用者所有已通過審核的訂單,照上述流程取得各個價格後加總回傳
	Integer getUnpayOrderTotal(Integer userID,);
	//移除單筆訂單細節,以courseDetailID刪除以通過審核未結帳的訂單,呼叫上面取得總價的方法,再取得courseOrderID改變總價
	
	//正式結帳訂單,將此會員以通過的課程訂單狀態改為已結帳
	
	//以姓名查詢該使用者id,考慮到同名狀況,size()>1時需要再從前端選擇會員,並送出一個ID來查詢
	List<Integer> getIdByUserName(String userName);
	//上面情況經前端選擇後再用id取得訂單
	List<CourseOrder> listOrderByUserName(String userName,Integer index);
	//取得該訂單主檔所有明細
	List<CourseOrderDetail>listOrderDetail(Integer courseOrderID);

}
