package co.grandcircus.lab21.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "shoppingcart")
public class Cart {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "itemId")
private int itemId;
private String userName;
private String itemName;
private int itemQuantity;
private float unitPrice;


	public Cart() {	
		super();
	}


	public Cart(int id, int itemId, String userName, String itemName, int itemQuantity, float unitPrice) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.userName = userName;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.unitPrice = unitPrice;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(float f) {
		this.unitPrice = f;
	}
	

	@Override
	public String toString() {
		return "Cart [id=" + id + ", itemId=" + itemId + ", userName=" + userName + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity
				+ ", unitPrice=" + unitPrice + "]";
	}
	
	//Other methods:
	
//	public int totalSum() {
//		for(int i = 0; i<= )
//	}
	

}
	