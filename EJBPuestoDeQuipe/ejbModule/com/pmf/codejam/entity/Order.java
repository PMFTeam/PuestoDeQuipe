/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pmf.codejam.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pmf.codejam.util.EjbConstants;

/**
 *
 * @author Melvin Severino
 */
@Entity
@Table(name = EjbConstants.TABLE_ORDERS, catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.findByOrderNo", query = "SELECT o FROM Order o WHERE o.orderNo = :orderNo"),
    @NamedQuery(name = "Order.findByEmail", query = "SELECT o FROM Order o WHERE o.email = :email"),
    @NamedQuery(name = "Order.findByCustomerName", query = "SELECT o FROM Order o WHERE o.customerName = :customerName"),
    @NamedQuery(name = "Order.findByAddress", query = "SELECT o FROM Order o WHERE o.address = :address"),
    @NamedQuery(name = "Order.findByPhone", query = "SELECT o FROM Order o WHERE o.phone = :phone")})

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_NO")
    private Long orderNo;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Set<OrderDetail> orderDetailSet;

    public Order() {
    }

    public Order(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Order(Long orderNo, String address) {
        this.orderNo = orderNo;
        this.address = address;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNo != null ? orderNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderNo == null && other.orderNo != null) || (this.orderNo != null && !this.orderNo.equals(other.orderNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.Order[orderNo=" + orderNo + "]";
    }

}
