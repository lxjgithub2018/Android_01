package com.hwua.auction.po;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 商品类别实体类
 * @author hwua
 */
@Entity  //表示这个类是实体类
@Table(name = "kinds")  //表示会和数据库中一张叫kinds的表映射
public class Kinds implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kind_id")
    private Integer kindId;//类别编号
    
    @Basic(optional = false)
    @Column(name = "kind_name")
    private String kindName;//类别名称
    
    @Basic(optional = false)
    @Column(name = "kind_desc")
    private String kindDesc;//类别描述
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kinds")
    private List<Items> itemsList;//属于此类别的商品列表

    public Kinds() {
    }

    public Kinds(Integer kindId) {
        this.kindId = kindId;
    }

    public Kinds(Integer kindId, String kindName, String kindDesc) {
        this.kindId = kindId;
        this.kindName = kindName;
        this.kindDesc = kindDesc;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindDesc() {
        return kindDesc;
    }

    public void setKindDesc(String kindDesc) {
        this.kindDesc = kindDesc;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kindId != null ? kindId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Kinds)) {
            return false;
        }
        Kinds other = (Kinds) object;
        if ((this.kindId == null && other.kindId != null) || (this.kindId != null && !this.kindId.equals(other.kindId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Kinds [kindId=" + kindId + ", kindName=" + kindName + ", kindDesc=" + kindDesc + "]";
	}
    
}
