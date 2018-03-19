package com.hwua.auction.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 商品实体类
 * @author hwua
 */
@Entity  //表示这个类是实体类
@Table(name = "items")  //表示会和数据库中一张叫items的表映射
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)//表示不为空
    @Column(name = "item_id")//表示与表中的item_id这一列关联
    private Integer itemId;//商品编号
    
    @Basic(optional = false)//表示不为空
    @Column(name = "item_name")//表示与表中的item_name这一列关联
    private String itemName;//商品名称
    
    @Column(name = "item_remark")//表示与表中的item_remark这一列关联
    private String itemRemark;//商品备注
    
    @Column(name = "item_desc")//表示与表中的item_desc这一列关联
    private String itemDesc;//商品描述
    
    @Basic(optional = false)//表示不为空
    @Column(name = "add_time")//表示与表中的add_time这一列关联
    @Temporal(TemporalType.DATE)//表示日期的类型
    private Date addTime;//添加时间
    
    @Basic(optional = false)//表示不为空
    @Column(name = "end_time")//表示与表中的end_time这一列关联
    @Temporal(TemporalType.DATE)
    private Date endTime;//结束竞拍时间
    
    @Basic(optional = false)//表示不为空
    @Column(name = "init_price")//表示与表中的init_price这一列关联
    private double initPrice;//初始价格
    
    @Basic(optional = false)//表示不为空
    @Column(name = "max_price")//表示与表中的max_price这一列关联
    private double maxPrice;//最高价格
    
    @JoinColumn(name = "kind_id", referencedColumnName = "kind_id")//表示两个表中的哪些列进行外键关联
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)//表示多对一的关系，设置级联关系中的操作（增、删、改）都要
    private Kinds kinds;//所属种类
    
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")//表示两个表中的哪些列进行外键关联
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)//表示多对一的关系，设置级联关系中的操作（增、删、改）都要
    private Users ownerUsers;//发布此商品的用户
    
    @JoinColumn(name = "winer_id", referencedColumnName = "user_id")//表示两个表中的哪些列进行外键关联
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)//表示多对一的关系，设置级联关系中的操作（增、删、改）都要
    private Users winerUsers;//赢取此商品的用户
    
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")//表示两个表中的哪些列进行外键关联
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)//表示多对一的关系，设置级联关系中的操作（增、删、改）都要
    private States states;//状态

    @JsonIgnore //表示生成json数据的时候忽略掉它，不生成
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")//表示一对多的关系映射，cascade用于设置级联关系，CascadeType.ALL表示所有操作（增，删，修）都要级联，mappedBy表示与多的那方中的哪个属性对应
    private List<Bids> bidsList;//参与此商品竞拍记录
    
    public Items() {
    }

    public Items(Integer itemId) {
        this.itemId = itemId;
    }

    public Items(Integer itemId, String itemName, Date addTime, Date endTime, double initPrice, double maxPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.addTime = addTime;
        this.endTime = endTime;
        this.initPrice = initPrice;
        this.maxPrice = maxPrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(double initPrice) {
        this.initPrice = initPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<Bids> getBidsList() {
        return bidsList;
    }

    public void setBidsList(List<Bids> bidsList) {
        this.bidsList = bidsList;
    }

    public Kinds getKinds() {
        return kinds;
    }

    public void setKinds(Kinds kinds) {
        this.kinds = kinds;
    }

    public Users getOwnerUsers() {
        return ownerUsers;
    }

    public void setOwnerUsers(Users ownerUsers) {
        this.ownerUsers = ownerUsers;
    }

    public Users getWinerUsers() {
        return winerUsers;
    }

    public void setWinerUsers(Users winerUsers) {
        this.winerUsers = winerUsers;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemRemark=" + itemRemark + ", itemDesc="
				+ itemDesc + ", addTime=" + addTime + ", endTime=" + endTime + ", initPrice=" + initPrice
				+ ", maxPrice=" + maxPrice + ", kinds=" + kinds + ", ownerUsers=" + ownerUsers + ", winerUsers=" + winerUsers
				+ ", states=" + states + "]";
	}

    
}