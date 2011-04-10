package com.pmf.codejam.util;

public class ProductView {

	private int productId;
	private String productName;
	private	double price;
	
	
	
	public ProductView(int productId,String productName,double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	



}
