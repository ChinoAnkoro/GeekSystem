package com.example.demo.dto;

public class MerchandiseDetailDTO {
	private Integer id;
	private String name;
	private String makerName;
	private String bigCategoryName;
	private String middleCategoryName;
	private String smallCategoryName;
	private Integer price;
	private Integer stock;
	private String comment;
	private String image;
	
	public MerchandiseDetailDTO(Integer id,String name,String makerName,String bigCategoryName,
			String middleCategoryName,String smallCategoryName, Integer price, Integer stock,
			String comment, String image) {
		
		this.id = id;
		this.name = name;
		this.makerName = makerName;
		this.bigCategoryName = bigCategoryName;
		this.middleCategoryName = middleCategoryName;
		this.smallCategoryName = smallCategoryName;
		this.price = price;
		this.stock = stock;
		this.comment = comment;
		this.image = image;
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
	
	public String getComment() {
		return comment;
	}
	
	public String getImage() {
		return image;
	}
}
