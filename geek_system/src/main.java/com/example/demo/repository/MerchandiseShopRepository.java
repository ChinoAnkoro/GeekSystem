package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.MerchandiseShop;

public interface MerchandiseShopRepository extends JpaRepository<MerchandiseShop, Integer> {
	@Query("""
			SELECT ms FROM MerchandiseShop ms
			WHERE ms.merchandiseId = :merchandiseId
			""")
	MerchandiseShop findByMerchandiseId(Integer merchandiseId);
}
