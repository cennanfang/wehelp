package com.cen.wehelp.model;

import java.util.Date;

/**
* Message 实体类
* Sun Oct 15 14:37:43 CST 2017 cennanfang
*/ 
public class Message{

	/**
	* 唯一标识且自增
	*/ 
	private Integer id;

	/**
	* 消息创建者
	*/ 
	private Integer userId;

	/**
	* 消息类型
	*/ 
	private Integer typeId;

	/**
	* 消息内容
	*/ 
	private String content;

	/**
	* 联系信息
	*/ 
	private String contacts;

	/**
	* 创建时间
	*/ 
	private Date createDate;

	/**
	* 发布时间
	*/ 
	private Date publishedDate;

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

	public void setTypeId(Integer typeId){
		this.typeId = typeId;
	}

	public Integer getTypeId(){
		return typeId;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setContacts(String contacts){
		this.contacts = contacts;
	}

	public String getContacts(){
		return contacts;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setPublishedDate(Date publishedDate){
		this.publishedDate = publishedDate;
	}

	public Date getPublishedDate(){
		return publishedDate;
	}
}

