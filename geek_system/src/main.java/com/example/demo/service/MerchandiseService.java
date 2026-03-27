package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MerchandiseDTO;
import com.example.demo.dto.MerchandiseDetailDTO;
import com.example.demo.repository.MerchandiseRepository;

@Service
public class MerchandiseService {
	@Autowired
    private MerchandiseRepository repository;

    /**
     * 一覧取得
     */
    public List<MerchandiseDTO> findMerchandiseList() {
        return repository.findMerchandiseList();
    }

    /**
     * 検索
     */
    public List<MerchandiseDTO> search(String name,
                                       Integer bigCategoryId,
                                       Integer middleCategoryId,
                                       Integer smallCategoryId) {

        return repository.search(name, bigCategoryId, middleCategoryId, smallCategoryId);
    }

    /**
     * 詳細取得
     */
    public MerchandiseDetailDTO findDetailById(Integer id) {
        return repository.findDetailById(id);
    }
}