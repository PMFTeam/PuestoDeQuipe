package com.pmf.codejam.entity;
import javax.persistence.*;
import com.pmf.codejam.util.EjbConstants;
import java.io.Serializable;

@Entity
@Table(name = EjbConstants.TABLE_INGREDIENTS)
public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="ProductId")
	private int productId;
	
	@Column(name="InventoryId")
	private int inventoryId;
	
	@Column(name="Quantity")
	private int quantity;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
