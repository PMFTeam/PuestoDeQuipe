/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pmf.codejam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Frederick
 */
@Embeddable
public class OrderItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ORDER_NO", nullable = false)
    private int orderNo;
    @Basic(optional = false)
    @Column(name = "DETAIL_SEQ", nullable = false)
    private short detailSeq;

    public OrderItemPK() {
    }

    public OrderItemPK(int orderNo, short detailSeq) {
        this.orderNo = orderNo;
        this.detailSeq = detailSeq;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public short getDetailSeq() {
        return detailSeq;
    }

    public void setDetailSeq(short detailSeq) {
        this.detailSeq = detailSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderNo;
        hash += (int) detailSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItemPK)) {
            return false;
        }
        OrderItemPK other = (OrderItemPK) object;
        if (this.orderNo != other.orderNo) {
            return false;
        }
        if (this.detailSeq != other.detailSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.OrderItemPK[orderNo=" + orderNo + ", detailSeq=" + detailSeq + "]";
    }

}
