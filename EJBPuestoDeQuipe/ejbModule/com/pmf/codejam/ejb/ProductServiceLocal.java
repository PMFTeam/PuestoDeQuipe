package com.pmf.codejam.ejb;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.exception.*;

public interface ProductServiceLocal {
	 public void    addProduct(Product  product);
	 public boolean updateProduct(int idProduct,String name, double price) throws ProductException;
	 public void deleteProduct(int productId) throws ProductException;
	 public void addIngredient(int productId, int ingredientId, int quantity)throws IngredientException;
	 public boolean updateIngredient(int idIngredient,int idProducto,int quantityNeeded) throws IngredientException;
	 public boolean deleteIngredient(int productId, int ingredientId) throws IngredientException;	
}
