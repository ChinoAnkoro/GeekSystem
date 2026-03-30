package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
	@Query("""
			SELECT new com.example.demo.dto.OrderHistoryDTO(
			m.name,
			a.name,
			s.name,
			d.quantity,
			d.price * d,quantity,
			o.orderDate
			)
			FROM OrderHistory o
			JOIN o.OrderDetails d
			JOIN d.merchandise m
			JOIN o.admin a
			JOIN o.shop s
			WHERE o.shopId = :shopId
			""")
	List<OrderHistory> findByShopId(Integer shopId);
}
