package com.cen.wehelp.model;

import javax.persistence.Table; 

/**
* Permission 实体类
* Sun Oct 15 21:52:12 CST 2017 cennanfang
*/ 
@Table(name = "t_permission")
public class Permission{

	/**
	* 唯一标识
	*/ 
	private Integer id;

	/**
	* 所属角色
	*/ 
	private Integer roleId;

	/**
	* 未使用
	*/ 
	private String token;

	/**
	* url链接
	*/ 
	private String url;

	/**
	* 是否可用0否1是
	*/ 
	private String available;

	/**
	* 描述介绍
	*/ 
	private String description;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}

	public Integer getRoleId(){
		return roleId;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}

