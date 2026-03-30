package com.example.demo.form;

import java.util.List;

import jakarta.validation.Valid;

import com.example.demo.dto.OrderItemDTO;

public class OrderForm {
	@Valid
	private List<OrderItemDTO> items;

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
