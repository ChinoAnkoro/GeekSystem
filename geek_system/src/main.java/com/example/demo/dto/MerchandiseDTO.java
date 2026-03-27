package com.example.demo.dto;

import java.io.Serializable;

public class MerchandiseDTO implements Serializable {
	private Integer id;
	private String name;
	private String makerName;
	private String bigCategoryName;
	private String middleCategoryName;
	private String smallCategoryName;
	private Integer price;
	private Integer stock;

	public MerchandiseDTO(Integer id, String name, String makerName,
			String bigCategoryName, String middleCategoryName,
			String smallCategoryName, Integer price, Integer stock) {
		this.id = id;
		this.name = name;
		this.makerName = makerName;
		this.bigCategoryName = bigCategoryName;
		this.middleCategoryName = middleCategoryName;
		this.smallCategoryName = smallCategoryName;
		this.price = price;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMakerName() {
		return makerName;
	}

	public String getBigCategoryName() {
		return bigCategoryName;
	}

	public String getMiddleCategoryName() {
		return middleCategoryName;
	}

	public String getSmallCategoryName() {
		return smallCategoryName;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}
}
