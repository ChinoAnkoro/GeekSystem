package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "merchandises")
public class Merchandise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "small_category_id")
	private Integer small_category_id;
	
	@Column(name = "maker_id")
	private Integer maker_id;
	
	@Column(name = "shop_id")
	private Integer shop_id;
	
	private String name;
	
	private String comment;
	
	private String image;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSmallCategoryId() {
		return small_category_id;
	}

	public void setSmallCategoryId(Integer small_category_id) {
		this.small_category_id = small_category_id;
	}

	public Integer getMakerId() {
		return maker_id;
	}

	public void setMakerId(Integer maker_id) {
		this.maker_id = maker_id;
	}

	public Integer getShopId() {
		return shop_id;
	}

	public void setShopId(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
