package courseCar.service;

import java.util.List;

import courseCar.dao.CourseCarPK;
import courseCar.model.CourseCar;

public interface CourseCarService {
	
	//讀取並列出購物車內容
	List<CourseCar> ListCar(Integer userID);
	//點擊商品進入頁面
	void clickPage();
	//加入購物車
	void addCar(CourseCar courseCar);
	//從購物車移除
	void removeCar(CourseCarPK coursePK);
	//清空購物車
	void cleanCar(Integer userID);
	//小計
	Integer subTotal();
	//合計
	Integer Total();
	//資料檢查
	boolean dataCheck();
	//將購物車的資料存至訂單
	void carPush();
	//送出申請
	void sendAply();
}
