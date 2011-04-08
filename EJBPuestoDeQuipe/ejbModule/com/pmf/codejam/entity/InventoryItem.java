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
	private int id;// I decided to add this field. It is not in the class diagram.
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Unit")
	private String unit; //this field has to be normalized in other table.
	
	@Column(name="RestockinLevel")
	private int restockingLevel;
	
	@Column(name="RestockingQuantity")
	private int restockingQuantity;
	

	@OneToOne 
	@JoinColumn(name="InventoryId") 	
    private Ingredient ingredient;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
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
}
