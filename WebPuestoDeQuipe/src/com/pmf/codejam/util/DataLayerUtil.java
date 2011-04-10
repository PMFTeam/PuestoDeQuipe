package com.pmf.codejam.util;

import java.util.ArrayList;
import java.util.List;

public class DataLayerUtil {

	public static List<ProductView> getProducts() {
		List<ProductView> products = new ArrayList<ProductView>();
		
		products.add(new ProductView(1,"Quipe de Pollo",new Double(10.5)));
		products.add(new ProductView(2,"Quipe de Queso",new Double(5.5)));
		products.add(new ProductView(3,"Empanada de Pollo",new Double(12.5)));
		products.add(new ProductView(4,"Empanada de Queso",new Double(15.5)));
		return products;
	}
}
