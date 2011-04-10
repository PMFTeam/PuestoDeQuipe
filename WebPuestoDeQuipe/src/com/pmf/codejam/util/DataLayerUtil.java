package com.pmf.codejam.util;

import java.util.ArrayList;
import java.util.List;

import com.pmf.codejam.ejb.ProductService;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.exception.ProductException;

public class DataLayerUtil {

	public static ProductView getProductById(int productId) {
		return new ProductView(productId, "Quipe", 4.55);
	}
	public static List<ProductView> getProducts() {
		List<ProductView> products = new ArrayList<ProductView>();
		
		products.add(new ProductView(1,"Quipe de Pollo",new Double(10.5)));
		products.add(new ProductView(2,"Quipe de Queso",new Double(5.5)));
		products.add(new ProductView(3,"Empanada de Pollo",new Double(12.5)));
		products.add(new ProductView(4,"Empanada de Queso",new Double(15.5)));
		return products;
	}
	
	public static List<IngredientView> getIngredientsByProductId(int productId) {
		List<IngredientView> ingredients = new ArrayList<IngredientView>();
		
		ingredients.add(new IngredientView("Aceite Crisol", 1, new Double(0.5)));
		ingredients.add(new IngredientView("Harina", 2, new Double(5.5)));
		ingredients.add(new IngredientView("Trigo", 3, new Double(1.5)));
		return ingredients;
	}
	public static List<IngredientView> getAllIngredients() {
		List<IngredientView> ingredients = new ArrayList<IngredientView>();
		
		ingredients.add(new IngredientView("Aceite Crisol All", 1, new Double(0.5)));
		ingredients.add(new IngredientView("Harina  All", 2, new Double(5.5)));
		ingredients.add(new IngredientView("Trigo  All", 3, new Double(1.5)));
		return ingredients;
	}
	
	public static void addProduct(ProductView pro)
	{
		Product prodEntity = new Product();
		pro.setProductName(pro.getProductName());
		pro.setPrice(pro.getPrice());
		ProductService prodService = new ProductService();
		prodService.addProduct(prodEntity);
	}
	public static void updateProduct(ProductView pro) throws ProductException {
		try{
			ProductService prodService = new ProductService();
			prodService.updateProduct(pro.getProductId(),pro.getProductName(),pro.getPrice());
		}
		catch(ProductException ex){
			throw ex;
		}			
	}
	public static void deleteProduct(ProductView pro) throws ProductException {
		try{
			ProductService proService = new ProductService();
			proService.deleteProduct(pro.getProductId());
		}
		catch(ProductException ex){
			throw ex;
		}
	}
}
