package com.example.demo.view;

import java.time.LocalDateTime;

public interface OrderHistoryView {
	String getMerchandiseName();
	String getAdminName();
	String getShopName();
	Integer getQuantity();
	Integer getTotalAmount();
	LocalDateTime getOrderDate();
}
