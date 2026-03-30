package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.dto.OrderHistoryDTO;
import com.example.demo.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService {

	private final OrderHistoryRepository repository;

	public OrderHistoryService(OrderHistoryRepository repository) {
		this.repository = repository;
	}

	public List<OrderHistoryDTO> getOrderHistories(Integer shopId) {

		return repository.findHistoryList(shopId).stream()
				.map(v -> new OrderHistoryDTO(
						v.getMerchandiseName(),
						v.getAdminName(),
						v.getShopName(),
						v.getQuantity(),
						v.getTotalAmount(),
						v.getOrderDate()))
				.toList();
	}
}
