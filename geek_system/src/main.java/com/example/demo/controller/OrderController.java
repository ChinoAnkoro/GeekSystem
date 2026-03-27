package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.OrderItemDTO;
import com.example.demo.form.OrderForm;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
    private OrderService orderService;

    // 発注画面表示
    @GetMapping("")
    public String showOrder(Model model) {

        OrderForm form = orderService.createForm();

        model.addAttribute("form", form);

        return "order";
    }

    // 発注登録
    @PostMapping("")
    public String order(@ModelAttribute OrderForm form) {

        orderService.order(form.getItems());

        return "redirect:/merchandise/list";
    }
}
