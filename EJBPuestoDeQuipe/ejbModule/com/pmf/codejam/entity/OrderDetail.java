package com.pmf.codejam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pmf.codejam.util.EjbConstants;

@Entity
@Table(name=EjbConstants.TABLE_ORDER_DETAIL)
public class OrderDetail {
	
    @Column(name="orderNumber")
	private int orderNumber;
	
    @Column(name="product_id")
    private int productId;
    
    @Column(name="quantity")
	private int quantity;

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProduct(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if((obj == null)
				|| (!(obj instanceof OrderDetail)) ) {
			return false;
		}
		
		OrderDetail orderDetailParameter = (OrderDetail)obj;
		
		return this.hashCode() == orderDetailParameter.hashCode();
	}

	@Override
	public int hashCode() {
		return  ((this.orderNumber)+"%"+(this.productId)).hashCode();
	}
	
	
	
	
}
