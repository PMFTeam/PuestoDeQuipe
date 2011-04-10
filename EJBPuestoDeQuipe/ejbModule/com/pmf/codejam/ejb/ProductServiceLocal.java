package com.pmf.codejam.ejb;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.exception.*;

public interface ProductServiceLocal {
	 public void    addProduct(Product  product);
	 public boolean updateProduct(int idProduct,String name, double price) throws ProductException;
	 public void deleteProduct(int productId) throws ProductException;
}
