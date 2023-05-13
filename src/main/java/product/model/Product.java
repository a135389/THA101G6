package product.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	private static final long serivalVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer productID;
	private String productClass;
	private String productName;
	private Integer productPrice;
	private Integer productQuantity;
	private byte[] productImage;
	private String productDetail;
	private Integer productBuyPerson;
	private String productDate;
	private String productStatus;

	
	public Product() {
		super();
	}


	public Product(Integer productID, String productClass, String productName, Integer productPrice,
			Integer productQuantity, byte[] productImage, String productDetail, Integer productBuyPerson,
			String productDate, String productStatus) {
		super();
		this.productID = productID;
		this.productClass = productClass;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productImage = productImage;
		this.productDetail = productDetail;
		this.productBuyPerson = productBuyPerson;
		this.productDate = productDate;
		this.productStatus = productStatus;
	}
	

	public Integer getproductID() {
		return productID;
	}

	public void setproductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public Integer getProductBuyPerson() {
		return productBuyPerson;
	}

	public void setProductBuyPerson(Integer productBuyPerson) {
		this.productBuyPerson = productBuyPerson;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}


	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productClass=" + productClass + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productImage="
				+ productImage + ", productDetail=" + productDetail + ", productBuyPerson=" + productBuyPerson
				+ ", productDate=" + productDate + ", productStatus=" + productStatus + "]";
	}
	public static byte[] getPicture(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
	
	
	
}