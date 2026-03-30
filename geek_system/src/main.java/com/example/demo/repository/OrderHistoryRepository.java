package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.OrderHistory;
import com.example.demo.view.OrderHistoryView;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
	@Query(value = """
			SELECT
			m.name AS merchandiseName,
			a.name AS adminName,
			s.name AS shopName,
			o.number_of_order AS quantity,
			o.total_amount AS totalAmount,
			o.created_at AS orderDate
			FROM order_histories o
			JOIN merchandises m ON o.merchandise_id = m.id
			JOIN admins a ON o.admin_id = a.id
			JOIN shops s ON o.shop_id = s.id
			WHERE o.shop_id = :shop_id
			""", nativeQuery = true)
	List<OrderHistoryView> findHistoryList(Integer shopId);
}
