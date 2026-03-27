package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "merchandise_shops")
public class MerchandiseShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "shop_id")
	private Integer shopId;

	@Column(name = "merchandise_id")
	private Integer merchandiseId;

	@Column(name = "purchase_cost")
	private Integer purchaseCost;

	@Column(name = "retail_price")
	private Integer retailPrice;

	@Column(name = "sales_price")
	private Integer salesPrice;

	private Integer stock;

	// getter setter
	public Integer getId() {
		return id;
	}

	public Integer getShopId() {
		return shopId;
	}

	public Integer getMerchandiseId() {
		return merchandiseId;
	}

	public Integer getPurchaseCost() {
		return purchaseCost;
	}

	public Integer getRetailPrice() {
		return retailPrice;
	}

	public Integer getSalesPrice() {
		return salesPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setMerchandiseId(Integer merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public void setPurchaseCost(Integer purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}

	public void setSalesPrice(Integer salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
