package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OrderHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "admin_id", nullable = false)
	private Integer adminId;

	@Column(name = "merchandise_id", nullable = false)
	private Integer merchandiseId;

	@Column(name = "shop_id", nullable = false)
	private Integer shopId;

	@Column(name = "number_of_order", nullable = false)
	private Integer numberOfOrder;

	@Column(name = "total_amount", nullable = false)
	private Integer totalAmount;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	public Integer getId() {
		return id;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public Integer getMerchandiseId() {
		return merchandiseId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public Integer getNumberOfOrder() {
		return numberOfOrder;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public void setMerchandiseId(Integer merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setNumberOfOrder(Integer numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
