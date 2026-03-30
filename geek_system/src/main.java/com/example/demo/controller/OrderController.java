package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
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
    
    @PostMapping("/execute")
    public String order(
            @Valid @ModelAttribute OrderForm form,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "order"; // 元画面に戻す
        }

        orderService.order(form.getItems());

        return "redirect:/merchandise/list";
    }
}
