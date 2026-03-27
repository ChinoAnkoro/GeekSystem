package com.example.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderItemDTO;
import com.example.demo.entity.MerchandiseShop;
import com.example.demo.form.OrderForm;
import com.example.demo.repository.MerchandiseRepository;
import com.example.demo.repository.MerchandiseShopRepository;

@Service
public class OrderService {
	@Autowired
    private MerchandiseRepository merchandiseRepository;

    @Autowired
    private MerchandiseShopRepository merchandiseShopRepository;

    // 画面用データ作成
    public OrderForm createForm() {

        List<OrderItemDTO> items = merchandiseRepository.findOrderItems();

        OrderForm form = new OrderForm();
        form.setItems(items);

        return form;
    }

    // 発注処理
    @Transactional
    public void order(List<OrderItemDTO> items) {

        for (OrderItemDTO item : items) {

            if (item.getQuantity() == null || item.getQuantity() == 0) {
                continue;
            }

            MerchandiseShop ms =
                merchandiseShopRepository.findByMerchandiseId(item.getMerchandiseId());

            if (ms == null) {
                continue;
            }

            ms.setStock(ms.getStock() + item.getQuantity());
        }
    }
}
