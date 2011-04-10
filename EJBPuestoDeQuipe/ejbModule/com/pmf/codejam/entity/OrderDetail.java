/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pmf.codejam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Frederick
 */
@Entity
@Table(name = "ORDER_DETAILS")
@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
    @NamedQuery(name = "OrderItem.findByOrderNo", query = "SELECT o FROM OrderItem o WHERE o.orderItemPK.orderNo = :orderNo"),
    @NamedQuery(name = "OrderItem.findByDetailSeq", query = "SELECT o FROM OrderItem o WHERE o.orderItemPK.detailSeq = :detailSeq"),
    @NamedQuery(name = "OrderItem.findByQuantity", query = "SELECT o FROM OrderItem o WHERE o.quantity = :quantity")})
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderItemPK orderItemPK;
    @Basic(optional = false)
    @Column(name = "QUANTITY", nullable = false)
    private short quantity;
    @JoinColumn(name = "ORDER_NO", referencedColumnName = "ORDER_NO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderEntity orderEntity;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product productId;

    public OrderDetail() {
    }

    public OrderDetail(OrderItemPK orderItemPK) {
        this.orderItemPK = orderItemPK;
    }

    public OrderDetail(OrderItemPK orderItemPK, short quantity) {
        this.orderItemPK = orderItemPK;
        this.quantity = quantity;
    }

    public OrderDetail(int orderNo, short detailSeq) {
        this.orderItemPK = new OrderItemPK(orderNo, detailSeq);
    }

    public OrderItemPK getOrderItemPK() {
        return orderItemPK;
    }

    public void setOrderItemPK(OrderItemPK orderItemPK) {
        this.orderItemPK = orderItemPK;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemPK != null ? orderItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderItemPK == null && other.orderItemPK != null) || (this.orderItemPK != null && !this.orderItemPK.equals(other.orderItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.OrderItem[orderItemPK=" + orderItemPK + "]";
    }

}
