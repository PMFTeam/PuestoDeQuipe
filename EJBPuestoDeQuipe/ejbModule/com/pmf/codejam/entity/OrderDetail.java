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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.pmf.codejam.util.EjbConstants;

/**
 *
 * @author Melvin Severino
 */
@Entity
@Table(name = EjbConstants.TABLE_ORDER_DETAILS, catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByOrderNo", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.orderNo = :orderNo"),
    @NamedQuery(name = "OrderDetail.findByProductId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.productId = :productId"),
    @NamedQuery(name = "OrderDetail.findByDetailSeq", query = "SELECT o FROM OrderDetail o WHERE o.detailSeq = :detailSeq"),
    @NamedQuery(name = "OrderDetail.findByQuantity", query = "SELECT o FROM OrderDetail o WHERE o.quantity = :quantity")})
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderDetailPK orderDetailPK;
    @Basic(optional = false)
    @Column(name = "DETAIL_SEQ")
    private short detailSeq;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private short quantity;
    @JoinColumn(name = "ORDER_NO", referencedColumnName = "ORDER_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public OrderDetail(OrderDetailPK orderDetailPK, short detailSeq, short quantity) {
        this.orderDetailPK = orderDetailPK;
        this.detailSeq = detailSeq;
        this.quantity = quantity;
    }

    public OrderDetail(long orderNo, int productId) {
        this.orderDetailPK = new OrderDetailPK(orderNo, productId);
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public short getDetailSeq() {
        return detailSeq;
    }

    public void setDetailSeq(short detailSeq) {
        this.detailSeq = detailSeq;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash += (orderDetailPK != null ? orderDetailPK.hashCode() : 31);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailPK == null && other.orderDetailPK != null) || (this.orderDetailPK != null && !this.orderDetailPK.equals(other.orderDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.OrderDetail[orderDetailPK=" + orderDetailPK + "]";
    }

}
