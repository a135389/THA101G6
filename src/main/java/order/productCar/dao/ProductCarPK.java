package order.productCar.dao;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import product.model.Product;

@Embeddable
public class ProductCarPK implements java.io.Serializable {
	private static final long seriaVersionUID=1L;
	private Integer userID;

	private Integer productID;


	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public ProductCarPK(Integer userID, Integer productID) {
		super();
		this.userID = userID;
		this.productID = productID;
	}
	public ProductCarPK() {}
}
