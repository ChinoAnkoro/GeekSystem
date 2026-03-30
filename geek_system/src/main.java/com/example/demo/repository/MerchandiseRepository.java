package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.MerchandiseDTO;
import com.example.demo.dto.MerchandiseDetailDTO;
import com.example.demo.dto.OrderItemDTO;
import com.example.demo.entity.Merchandise;

public interface MerchandiseRepository extends JpaRepository<Merchandise, Integer> {
	/**
	 * 一覧取得
	 */
	@Query("""
			SELECT new com.example.demo.dto.MerchandiseDTO(
			    m.id,
			    m.name,
			    mk.name,
			    bc.name,
			    mc.name,
			    sc.name,
			    ms.salesPrice,
			    ms.stock
			)
			FROM Merchandise m
			JOIN Maker mk ON m.makerId = mk.id
			JOIN SmallCategory sc ON m.smallCategoryId = sc.id
			JOIN MiddleCategory mc ON sc.middleCategoryId = mc.id
			JOIN BigCategory bc ON mc.bigCategoryId = bc.id
			JOIN MerchandiseShop ms ON ms.merchandiseId = m.id
			""")
	List<MerchandiseDTO> findMerchandiseList();

	/**
	 * 検索
	 */
	@Query("""
			SELECT new com.example.demo.dto.MerchandiseDTO(
			    m.id,
			    m.name,
			    mk.name,
			    bc.name,
			    mc.name,
			    sc.name,
			    ms.salesPrice,
			    ms.stock
			)
			FROM Merchandise m
			JOIN Maker mk ON m.makerId = mk.id
			JOIN SmallCategory sc ON m.smallCategoryId = sc.id
			JOIN MiddleCategory mc ON sc.middleCategoryId = mc.id
			JOIN BigCategory bc ON mc.bigCategoryId = bc.id
			JOIN MerchandiseShop ms ON ms.merchandiseId = m.id
			WHERE (:name IS NULL OR m.name LIKE %:name%)
			  AND (:bigCategoryId IS NULL OR bc.id = :bigCategoryId)
			  AND (:middleCategoryId IS NULL OR mc.id = :middleCategoryId)
			  AND (:smallCategoryId IS NULL OR sc.id = :smallCategoryId)
			""")
	List<MerchandiseDTO> search(String name,
			Integer bigCategoryId,
			Integer middleCategoryId,
			Integer smallCategoryId);

	/**
	 * 詳細取得（←今のコードOK）
	 */
	@Query("""
			SELECT new com.example.demo.dto.MerchandiseDetailDTO(
			    m.id,
			    m.name,
			    mk.name,
			    bc.name,
			    mc.name,
			    sc.name,
			    ms.salesPrice,
			    ms.stock,
			    m.comment,
			    m.image
			)
			FROM Merchandise m
			JOIN Maker mk ON m.makerId = mk.id
			JOIN SmallCategory sc ON m.smallCategoryId = sc.id
			JOIN MiddleCategory mc ON sc.middleCategoryId = mc.id
			JOIN BigCategory bc ON mc.bigCategoryId = bc.id
			JOIN MerchandiseShop ms ON ms.merchandiseId = m.id
			WHERE m.id = :id
			""")
	MerchandiseDetailDTO findDetailById(Integer id);
	
	@Query("""
			SELECT new com.example.demo.dto.OrderDTO(
			    m.id,
			    m.image,
			    ms.stock,
			    ms.salesPrice,
			    0
			)
			FROM Merchandise m
			JOIN MerchandiseShop ms ON ms.merchandiseId = m.id
			""")
			List<OrderItemDTO> findOrderItems();
}
