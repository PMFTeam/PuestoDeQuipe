
package com.pmf.codejam.entity;
import javax.persistence.*;
import com.pmf.codejam.util.EjbConstants;
import java.io.Serializable;

//@Entity
//@Table(name = EjbConstants.TABLE_INGREDIENTS)
@Embeddable
public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductId")
	private Product product;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="InventoryId")
	private InventoryItem inventoryItem;
	
	@Column(name="Quantity")
	private int quantity;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}	
	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}
	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
