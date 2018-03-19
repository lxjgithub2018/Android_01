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
 * 用户实体类
 * 
 * @author hwua
 */
@Entity  //表示这个类是实体类
@Table(name = "users")  //表示会和数据库中一张叫users的表映射
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id //表示这个属性是与主键关联
    @GeneratedValue(strategy = GenerationType.IDENTITY) //表示主键生成机制是自增长，IDENTITY主要面向mysql、mssqlserver
    @Basic(optional = false)//表示不为空
    @Column(name = "user_id")//表示与表中的user_id这一列关联
    private Integer userId;//用户编号
    
    @Basic(optional = false)//表示不为空
    @Column(name = "user_name")//表示与表中的user_name这一列关联
    private String userName;//用户名
    
    @Basic(optional = false)//表示不为空
    @Column(name = "user_pass")//表示与表中的user_pass这一列关联
    private String userPass;//用户密码
    
    @Basic(optional = false)//表示不为空
    @Column(name = "email")//表示与表中的email这一列关联
    private String email;//用户邮箱
    
    @JsonIgnore //表示生成json数据的时候忽略掉它，不生成
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")//表示一对多的关系映射，cascade用于设置级联关系，CascadeType.ALL表示所有操作（增，删，修）都要级联，mappedBy表示与多的那方中的哪个属性对应
    private List<Bids> bidsList;//此用户参与的竞拍记录
    
    @JsonIgnore //表示生成json数据的时候忽略掉它，不生成
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerUsers")//表示一对多的关系映射，cascade用于设置级联关系，CascadeType.ALL表示所有操作（增，删，修）都要级联，mappedBy表示与多的那方中的哪个属性对应
    private List<Items> ownItemsList;//此用户发布的竞拍商品
    
    @JsonIgnore //表示生成json数据的时候忽略掉它，不生成
    @OneToMany(mappedBy = "winerUsers")//表示一对多的关系映射，cascade用于设置级联关系，CascadeType.ALL表示所有操作（增，删，修）都要级联，mappedBy表示与多的那方中的哪个属性对应
    private List<Items> winItemsList;//此用户赢得的竞拍商品

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userName, String userPass, String email) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bids> getBidsList() {
        return bidsList;
    }

    public void setBidsList(List<Bids> bidsList) {
        this.bidsList = bidsList;
    }

    public List<Items> getOwnItemsList() {
        return ownItemsList;
    }

    public void setOwnItemsList(List<Items> ownItemsList) {
        this.ownItemsList = ownItemsList;
    }

    public List<Items> getWinItemsList() {
        return winItemsList;
    }

    public void setWinItemsList(List<Items> winItemsList) {
        this.winItemsList = winItemsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", email=" + email
				+ "]";
	}
    
}