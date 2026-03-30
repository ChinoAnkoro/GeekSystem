package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.OrderHistory;
import com.example.demo.service.OrderHistoryService;

@Controller
@RequestMapping("/order_history")
public class OrderHistoryController {
	@Autowired
	private OrderHistoryService service;

	@GetMapping("")
	public String list(Model model, Authentication auth) {
		Integer shopId = 1;
		List<OrderHistory> list = service.getOrderHistories(shopId);
		model.addAttribute("historyList", list);
		return "order_history/list";
	}
}
