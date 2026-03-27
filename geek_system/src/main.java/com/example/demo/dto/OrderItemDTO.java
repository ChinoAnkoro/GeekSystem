package com.example.demo.dto;

public class OrderItemDTO {
	private Integer merchandiseId;
	private String image;
	private Integer stock;
	private Integer price;
	private Integer quantity;

	public OrderItemDTO(Integer merchandiseId, String image,
			Integer stock, Integer price, Integer quantity) {
		this.merchandiseId = merchandiseId;
		this.image = image;
		this.stock = stock;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getMerchandiseId() {
		return merchandiseId;
	}

	public String getImage() {
		return image;
	}

	public Integer getStock() {
		return stock;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setMerchandiseId(Integer merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
