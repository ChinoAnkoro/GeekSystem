package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderHistory;
import com.example.demo.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService {
	@Autowired
	private final OrderHistoryRepository repository;
	
	public OrderHistoryService(OrderHistoryRepository repository) {
		this.repository = repository;
	}
	
	public List<OrderHistory> getOrderHistories(Integer ShopId){
		return repository.findByShopId(ShopId);
	}
}
