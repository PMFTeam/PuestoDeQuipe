package com.pmf.codejam.ejb;

import com.pmf.codejam.entity.*;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.exception.IngredientException;
import com.pmf.codejam.exception.ProductException;
/**
 * 
 * @author fpimentel
 *
 */
public interface IngredientServiceLocal {	
	 public void addIngredient(int productId, int ingredientId, int quantity)throws IngredientException;
	 public boolean updateIngredient(int idIngredient,int idProducto,int quantityNeeded) throws IngredientException;
	 public boolean deleteIngredient(int productId, int ingredientId) throws IngredientException;	
}
