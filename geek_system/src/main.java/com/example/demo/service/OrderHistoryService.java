package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderHistoryDTO;
import com.example.demo.entity.OrderHistory;
import com.example.demo.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService {

	private final OrderHistoryRepository repository;

	public OrderHistoryService(OrderHistoryRepository repository) {
		this.repository = repository;
	}

	public List<OrderHistoryDTO> getOrderHistories(Integer shopId) {

		List<Object[]> results = repository.findHistoryList(shopId);

		return results.stream()
				.map(r -> new OrderHistoryDTO(
						(String) r[0],
						(String) r[1],
						(String) r[2],
						((Number) r[3]).intValue(),
						((Number) r[4]).intValue(),
						r[5] != null
								? ((java.sql.Timestamp) r[5]).toLocalDateTime()
								: null))
				.toList();
	}
}
