package pl.finanse.zrzutek.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="SHOPPINGLIST")
public class ShoppingList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHOPPING_ID")
	private long id;
	@Column(name="DATE")
	private String date;
	@NotNull(message = "Pole nie może być puste")
	@Size(min=3, max=30, message="Pole musi zawierać od 3 do 30 znaków")
	@Column(name="PRODUCT_NAME")
	private String product_name;
	@NotNull(message = "Pole nie może być puste")
	@Size(min=3, max=30, message="Pole musi zawierać od 3 do 30 znaków")
	@Column(name="PRODUCT_SHOP")
	private String product_shop;
	@NotNull(message = "Pole może zawierać tylko liczbę zmiennoprzecinkową")
	@Size(min=3, max=16)
	@Column(name="PRODUCT_PRICE")
	private String product_price;
	@NotNull(message = "Pole nie może być puste")
	@Min(1)
	@Column(name="QUANTITY")
	private long quantity;
	@Column(name="OWNER")
	private String owner;
	
	public String getDate() {
		return date;
	}
	public void setDate() {
		SimpleDateFormat readFormat = new SimpleDateFormat("dd.MM.yyyy, kk:mm:ss");
		//long millis=System.currentTimeMillis();
		//Date currentDate = new Date(millis);
		this.date = readFormat.format(new Date());
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
		try {
		this.product_name = product_name.substring(0, 1).toUpperCase() + product_name.substring(1);
		} catch(StringIndexOutOfBoundsException e)
		{
			//do nothing
		}
	}
	public String getProduct_shop() {
		return product_shop;
	}
	public void setProduct_shop(String product_shop) {
		try {
		this.product_shop = product_shop.substring(0, 1).toUpperCase() + product_shop.substring(1);
		} catch(StringIndexOutOfBoundsException e)
		{
			//do nothing
		}
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		product_price=product_price.replace(".", ",");
		Pattern pattern = Pattern.compile("(\\d+),(\\d{2})");
		Matcher matcher = pattern.matcher(product_price);
		if(matcher.matches())
		this.product_price = product_price;
		else
		{
			//nuthin but a g thing...
		}
	}
		
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
