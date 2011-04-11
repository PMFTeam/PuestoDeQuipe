package com.pmf.codejam.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pmf.codejam.ejb.ProductService;
import com.pmf.codejam.ejb.ProductServiceLocal;
import com.pmf.codejam.ejb.SpecialService;
import com.pmf.codejam.ejb.SpecialServiceLocal;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.entity.Special;
import com.pmf.codejam.exception.IllegalOrphanException;
import com.pmf.codejam.exception.ProductException;
import com.pmf.codejam.exception.SpecialException;

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
		ProductServiceLocal prodService = new ProductService();
		prodService.create(prodEntity);
	}
	public static void updateProduct(ProductView pro) throws IllegalOrphanException, Exception {
		try{
			ProductServiceLocal prodService = new ProductService();
			prodService.edit(pro.getProductId(),pro.getProductName(), pro.getDescription(),pro.getPrice());
		}
		catch(ProductException ex){
			throw ex;
		}			
	}
	public static void deleteProduct(ProductView pro) throws ProductException, IllegalOrphanException {
		try{
			ProductServiceLocal proService = new ProductService();
			proService.destroy(pro.getProductId());
		}
		catch(ProductException ex){
			throw ex;
		}
	}
	
	public static void addSpecial(SpecialView special) {
		
		Special specialEntity = new Special();
		specialEntity.setDescription(special.getDescription());
		specialEntity.setSummary(special.getSummary());

		if (special.getExpirationDate() != null &&  special.getExpirationDate().getTime() != null)
			specialEntity.setExpirationDate(special.getExpirationDate().getTime());
		
		SpecialServiceLocal specialService = new SpecialService();
		specialService.create(specialEntity);
	}
	
	public static void updateSpecial(SpecialView special) {
		SpecialServiceLocal specialService = new SpecialService();
		
		Special specialEntity = specialService.findSpecial(new Long(special.getSpecialId()));
		specialEntity.setDescription(special.getDescription());
		specialEntity.setSummary(special.getSummary());

		if (special.getExpirationDate() != null &&  special.getExpirationDate().getTime() != null)
			specialEntity.setExpirationDate(special.getExpirationDate().getTime());
		
		try {
			specialService.edit(specialEntity);
		} catch (IllegalOrphanException e) {
			e.printStackTrace();
		} catch (SpecialException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteSpecial(Long specialId) {
		SpecialServiceLocal specialService = new SpecialService();
		
		Special specialEntity = specialService.findSpecial(specialId);
		try {
			specialService.destroy(specialEntity.getId());
		} catch (IllegalOrphanException e) {
			e.printStackTrace();
		} catch (SpecialException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
