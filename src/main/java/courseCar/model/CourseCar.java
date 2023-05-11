package courseCar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseCar implements java.io.Serializable{
	@Id
	private Integer userID;
	@Id
	private Integer courseID;
	private Integer quantity;
	public CourseCar() {};
	public CourseCar(Integer userID, Integer courseID, Integer quantity) {
		super();
		this.userID = userID;
		this.courseID = courseID;
		this.quantity = quantity;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getCourseID() {
		return courseID;
	}
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
