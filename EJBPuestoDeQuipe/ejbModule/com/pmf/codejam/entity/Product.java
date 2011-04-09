package com.pmf.codejam.entity;
import java.io.Serializable;

import com.pmf.codejam.exception.ProductException;
import com.pmf.codejam.util.EjbConstants;
import javax.persistence.*;
import java.util.*;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Price")
	private float price;
	
	@ElementCollection
	@CollectionTable(name=EjbConstants.TABLE_PRODUCTS,joinColumns=@JoinColumn(name="ProductId"))
	private Set<Ingredient> ingredients;

	//setter's and getter's
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name= name;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public float getPrice(){
		return this.price;
	}
	public void setPrice(float price){
		this.price = price;
	}
	public Set<Ingredient> getIngredients(){
		return this.ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients){
		this.ingredients = ingredients;
	}
	
	//Customs methods.....
	public void addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
	}	
	public void restock(int amountProductToRequest) throws ProductException{			
			Set<Ingredient> i = new HashSet<Ingredient>();
			 for (Iterator<Ingredient> ing = i.iterator(); ing.hasNext(); ){
				 Ingredient currentIngre = ing.next();
				 
				 int ingredientId =currentIngre.getInventoryItem().getId();
				 int amountIngredientNeeded = currentIngre.getQuantity();
			     String unit = currentIngre.getInventoryItem().getUnit();  
			     int amountIngredientToRequest = amountProductToRequest *  amountIngredientNeeded;
			     
			     currentIngre.getInventoryItem().restockingItemQuantity(ingredientId, unit, amountIngredientToRequest);							
			 }		
	}
	/***
	 * Its Calculate the amount of products that can be done according to what exists in Stock.
	 * @return
	 */
	public int avariableQuantity() throws ProductException{
		int avariableQuantity = 0;
		
		Set<Ingredient> i = new HashSet<Ingredient>();
		 for (Iterator<Ingredient> ing = i.iterator(); ing.hasNext(); ){
			 int quantityTemp;
			 Ingredient currentIngre = ing.next();
			 quantityTemp = currentIngre.getInventoryItem().getQuantity() / currentIngre.getQuantity();
			 
			 if(avariableQuantity > quantityTemp)
				 avariableQuantity = quantityTemp;
		 }
		return avariableQuantity;		 
	}
	public void removeIngredient(Ingredient ingredient){
		this.ingredients.remove(ingredient);
	}
}
