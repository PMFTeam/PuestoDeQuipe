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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		if (orderNumber != other.orderNumber)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNumber;
		result = prime * result + productId;
		return result;
	}
	
	
	
	
}
