package com.pmf.codejam.entity;
import java.io.Serializable;
import java.util.Set;

import com.pmf.codejam.util.EjbConstants;
import javax.persistence.*;

/**
*
* @author fpimentel
*/
@Entity
@Table(name = EjbConstants.TABLE_INVENTORY)
@NamedQueries({
    @NamedQuery(name = "InventoryItem.findAll", query = "SELECT i FROM InventoryItem i"),
    @NamedQuery(name = "InventoryItem.findById", query = "SELECT i FROM InventoryItem i WHERE i.id = :id"),
    @NamedQuery(name = "InventoryItem.findByDescription", query = "SELECT i FROM InventoryItem i WHERE i.description = :description"),
    @NamedQuery(name = "InventoryItem.findByUnit", query = "SELECT i FROM InventoryItem i WHERE i.unit = :unit"),
    @NamedQuery(name = "InventoryItem.findByRestockingLevel", query = "SELECT i FROM InventoryItem i WHERE i.restockingLevel = :restockingLevel"),
    @NamedQuery(name = "InventoryItem.findByRestockingQuantity", query = "SELECT i FROM InventoryItem i WHERE i.restockingQuantity = :restockingQuantity")})
public class InventoryItem implements Serializable{
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)	
    @Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name="SupplierProductId")
	private int supplierProductId;
	
	@Column(name="Description")
	private String description;
	
	@Basic(optional = false)
	@Column(name="Unit")
	private String unit; 
	
	@Basic(optional = false)
	@Column(name="Quantity")
	private int quantity;

	@Basic(optional = false)
    @Column(name = "RESTOCKING_LEVEL", nullable = false)
	private short  restockingLevel;

    @Basic(optional = false)
    @Column(name = "RESTOCKING_QUANTITY", nullable = false)
	private short  restockingQuantity;	
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryItem", fetch = FetchType.LAZY)
	@OneToOne          
	private Set<Ingredient> ingredientSet;
	
    public InventoryItem() {
    }

    public InventoryItem(Integer id) {
        this.id = id;
    }

    public InventoryItem(Integer id, String description, String unit, short restockingLevel, short restockingQuantity) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.restockingLevel = restockingLevel;
        this.restockingQuantity = restockingQuantity;
    }
    
	//gette's and setter's
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public void setRestockingLevel(short restockingLevel) {
		this.restockingLevel = restockingLevel;
	}	
	public int getRestockingQuantity() {
		return restockingQuantity;
	}	
	public void setRestockingQuantity(short restockingQuantity) {
		this.restockingQuantity = restockingQuantity;
	}		
    public Set<Ingredient> getIngredientSet() {
        return ingredientSet;
    }
    public void setIngredientSet(Set<Ingredient> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }
	//Customs methods
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventoryItem)) {
            return false;
        }
        InventoryItem other = (InventoryItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.InventoryItem[id=" + id + "]";
    }

	/**
	 * Its is responsible for decreasing the amount of ingredient inventory.
	 */
	public void decreaseQuantity(int quantityToDecrease){
		if((this.quantity <= this.restockingLevel) || (this.quantity < quantityToDecrease)){				
			restockingItemQuantity(this.getId(),this.getUnit(),this.getRestockingQuantity());
			//WHAT WE GONNA DO BEFORE THE SERVICE CALL???.I only know that the amount is increased.
			this.quantity+= quantityToDecrease;
		}
		else{
			this.quantity-=  quantityToDecrease; 
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
