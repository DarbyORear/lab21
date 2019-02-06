package co.grandcircus.lab21.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedQuery;

//@NamedQuery(
//		name="Items.findAllCategories",
//		query="SELECT DISTINCT category FROM Items") //CHANGE MADE: ADDED NAMED QUERY.

@Entity
public class Items {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column (name = "admin_quantity", nullable = true)
	private int adminQuantity;
	private float price;


	public Items() {}
	
	public Items(int id, String name, String description, int adminQuantity, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.adminQuantity = adminQuantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAdminQuantity() {
		return adminQuantity;
	}

	public void setAdminQuantity(int adminQuantity) {
		this.adminQuantity = adminQuantity;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}


