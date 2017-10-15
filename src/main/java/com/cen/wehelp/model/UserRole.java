package com.cen.wehelp.model;

import java.util.Date;

/**
* UserRole 实体类
* Sun Oct 15 14:37:44 CST 2017 cennanfang
*/ 
public class UserRole{

	/**
	* 唯一标识
	*/ 
	private Integer id;

	/**
	* 拥有角色的用户
	*/ 
	private Integer userId;

	/**
	* 所属用户的角色
	*/ 
	private Integer roleId;

	/**
	* 是否可用0否1是
	*/ 
	private String available;

	/**
	* 授权时间
	*/ 
	private Date createDate;

	/**
	* 更新时间
	*/ 
	private Date updateDate;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}

	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}

	public Integer getRoleId(){
		return roleId;
	}

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}
}

