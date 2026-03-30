package com.example.demo.dto;

import java.time.LocalDateTime;

public class OrderHistoryDTO {
	private String merchandiseName;
	private String adminName;
	private String shopName;
	private Integer quantity;
	private Integer totalAmount;
	private LocalDateTime orderDate;

	public OrderHistoryDTO(String merchandiseName, String adminName, String shopName,
			Integer quantity, Integer totalAmount, LocalDateTime orderDate) {
		this.merchandiseName = merchandiseName;
		this.adminName = adminName;
		this.shopName = shopName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
	}
	
	public String getMerchandiseName() {
		return merchandiseName;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Integer getTotalAmount() {
		return totalAmount;
	}
	
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	
	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
}
