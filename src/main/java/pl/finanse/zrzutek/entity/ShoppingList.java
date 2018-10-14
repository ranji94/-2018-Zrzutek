package pl.finanse.zrzutek.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHOPPINGLIST")
public class ShoppingList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHOPPING_ID")
	private long id;
	@Column(name="DATE")
	private Date date;
	@Column(name="PRODUCT_NAME")
	private String product_name;
	@Column(name="PRODUCT_SHOP")
	private String product_shop;
	@Column(name="PRODUCT_PRICE")
	private float product_price;
	@Column(name="QUANTITY")
	private long quantity;
	
	public Date getDate() {
		return date;
	}
	public void setDate() {
		long millis=System.currentTimeMillis();
		Date currentDate = new Date(millis);
		this.date = currentDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_shop() {
		return product_shop;
	}
	public void setProduct_shop(String product_shop) {
		this.product_shop = product_shop;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	
	
}
