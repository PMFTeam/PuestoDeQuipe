
package com.pmf.codejam.entity;
import javax.persistence.*;
import com.pmf.codejam.util.EjbConstants;
import java.io.Serializable;

/**
*
* @author fpimentel
*/
@Entity
@Table(name = EjbConstants.TABLE_INGREDIENTS)
@NamedQueries({
   @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i"),
   @NamedQuery(name = "Ingredient.findByProductId", query = "SELECT i FROM Ingredient i WHERE i.ingredientPK.productId = :productId"),
   @NamedQuery(name = "Ingredient.findByInventoryId", query = "SELECT i FROM Ingredient i WHERE i.ingredientPK.inventoryId = :inventoryId"),
   @NamedQuery(name = "Ingredient.findByQuantity", query = "SELECT i FROM Ingredient i WHERE i.quantity = :quantity")})
public class Ingredient implements Serializable{
	//Merge Test. Frederick Apr 2009, 2011
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected IngredientPK ingredientPK;
	
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)    
	private Product product;
	
	@JoinColumn(name = "INVENTORY_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)    
	private InventoryItem inventoryItem;
		   
    @Basic(optional = false)
    @Column(name = "QUANTITY", nullable = false)	
	private double quantityNeeded;
	
    public Ingredient() {
    }

    public Ingredient(IngredientPK ingredientPK) {
        this.ingredientPK = ingredientPK;
    }

    public Ingredient(IngredientPK ingredientPK, double quantity) {
        this.ingredientPK = ingredientPK;
        this.quantityNeeded = quantity;
    }

    public Ingredient(int productId, int inventoryId) {
        this.ingredientPK = new IngredientPK(productId, inventoryId);
    }
    
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
	public double getQuantityNeeded() {
		return quantityNeeded;
	}
	public void setQuantityNedded(double quantity) {
		this.quantityNeeded = quantity;
	}
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientPK != null ? ingredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.ingredientPK == null && other.ingredientPK != null) || (this.ingredientPK != null && !this.ingredientPK.equals(other.ingredientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.Ingredient[ingredientPK=" + ingredientPK + "]";
    }
}
