package com.pmf.codejam.entity;
import java.io.Serializable;
import com.pmf.codejam.util.EjbConstants;
import javax.persistence.*;


@Entity
@Table(name = EjbConstants.TABLE_INVENTORY)
public class InventoryItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="SupplierProductId")
	private int supplierProductId;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Unit")
	private String unit; 
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="RestockingLevel")
	private int restockingLevel;
	
	@Column(name="RestockingQuantity")
	private int restockingQuantity;	
	
	@OneToOne
	@JoinColumn(name="InventoryId")             
	private Ingredient ingredient;
	
	//gette's and setter's
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}		
	public void setDescription(String desc) {
		this.description = desc;
	}
	public String getDescription() {
		return description;
	}	
	public void setSupplierId(int supp){
		this.supplierProductId = supp;
	}	
	public int getSupplierId(){
		return supplierProductId;
	}
	public void setQuantity(int quantity)	{
		this.quantity = quantity;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}	
	public int getRestockingLevel() {
		return restockingLevel;
	}
	public void setRestockingLevel(int restockingLevel) {
		this.restockingLevel = restockingLevel;
	}	
	public int getRestockingQuantity() {
		return restockingQuantity;
	}	
	public void setRestockingQuantity(int restockingQuantity) {
		this.restockingQuantity = restockingQuantity;
	}		
	public void setIngredient(Ingredient ingredient)	{
		this.ingredient = ingredient;
	}
	public Ingredient getIngredient(){
		return ingredient;
	}
	//Customs methods	
	/**
	 * Its is responsible for decreasing the amount of ingredient inventory.
	 */
	public void decreaseQuantity(InventoryItem item, int quantity ){
		if(item.getQuantity() <= item.getRestockingQuantity()){
			int supplierProductId = item.getId();
			String uni = item.getUnit();
			int quan   = item.getRestockingQuantity();			
			restockingItemQuantity(supplierProductId,uni,quan);
			//WHAT WE GONNA DO BEFORE THE SERVICE CALL???.
		}
		else{
			item.setQuantity(item.getQuantity() - quantity); 
		}
	}	
	/**
	 * Its is responsible for increase the amount of ingredient inventory to calling Supply WebServices.
	 * @param supplierId
	 * @param uni
	 * @param quantity
	 */
	public void restockingItemQuantity(int supplierProductId, String uni, int quantity)
	{
		//Remove this comment when we implement the web service.
		/*
		InventoryRequest inventoryR = new InventoryRequest();
		RequestItem itemR = new RequestItem();
		itemR.setQuantity(quantity);
		itemR.setUnit = unit;
		itemR.setSupplierProductId(supplierProductId);
		inventoryR.addItem(itemR);
		sendRequest(inventoryR);
		*/	
	}
	
	
}
