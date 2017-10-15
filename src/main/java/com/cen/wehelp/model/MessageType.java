package com.cen.wehelp.model;

import javax.persistence.Table; 

/**
* MessageType 实体类
* Sun Oct 15 21:52:12 CST 2017 cennanfang
*/ 
@Table(name = "t_message_type")
public class MessageType{

	/**
	* 唯一标识且自增
	*/ 
	private Integer id;

	/**
	* 类型名称
	*/ 
	private String name;

	/**
	* 描述
	*/ 
	private String description;

	/**
	* 是否可用0否1是
	*/ 
	private String available;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}
}

