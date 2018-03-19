package com.hwua.auction.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 竞拍记录实体类
 * 
 * @author hwua
 */
@Entity  //表示这个类是实体类
@Table(name = "bids") //表示会和数据库中一张叫bids的表映射
public class Bids implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid_id")
    private Integer bidId;//竞拍编号
    
    @Basic(optional = false)
    @Column(name = "bid_price")
    private double bidPrice;//竞拍价格
    
    @Basic(optional = false)
    @Column(name = "bid_date")
    @Temporal(TemporalType.DATE)
    private Date bidDate;//竞拍日期
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
    private Users users;//竞拍用户
    
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne(cascade = CascadeType.ALL,optional = true, fetch = FetchType.EAGER)
    private Items items;//竞拍的商品

    public Bids() {
    }

    public Bids(Integer bidId) {
        this.bidId = bidId;
    }

    public Bids(Integer bidId, double bidPrice, Date bidDate) {
        this.bidId = bidId;
        this.bidPrice = bidPrice;
        this.bidDate = bidDate;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidId != null ? bidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Bids)) {
            return false;
        }
        Bids other = (Bids) object;
        if ((this.bidId == null && other.bidId != null) || (this.bidId != null && !this.bidId.equals(other.bidId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Bids [bidId=" + bidId + ", bidPrice=" + bidPrice + ", bidDate=" + bidDate + ", users=" + users
				+ ", items=" + items + "]";
	}

    
}