package com.cen.wehelp.model;

import javax.persistence.Table;
import java.util.Date;

/**
* Message 实体类
* Sun Oct 15 21:52:12 CST 2017 cennanfang
*/ 
@Table(name = "t_message")
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
	* 约定地点
	*/ 
	private String locale;

	/**
	* 经度
	*/ 
	private Float longitude;

	/**
	* 纬度
	*/ 
	private Float latitude;

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

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setLongitude(Float longitude){
		this.longitude = longitude;
	}

	public Float getLongitude(){
		return longitude;
	}

	public void setLatitude(Float latitude){
		this.latitude = latitude;
	}

	public Float getLatitude(){
		return latitude;
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

