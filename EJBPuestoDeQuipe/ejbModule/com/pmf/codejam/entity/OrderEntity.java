package com.pmf.codejam.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pmf.codejam.util.EjbConstants;

@Entity
@Table(name=EjbConstants.TABLE_ORDER)
public class OrderEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="number")
	private int number;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String geAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<OrderDetail> getOrderDetail() {
		return orderDetails;
	}
	
	public boolean addOrderDetail(OrderDetail orderDetail) {
		return orderDetails.add(orderDetail);
	}
	
	public boolean removeOrderDetail(OrderDetail orderDetail){
		return orderDetails.remove(orderDetail);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		if (number != other.number)
			return false;
		return true;
	}
	
	
	
	
}
