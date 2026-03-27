package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.MerchandiseDTO;
import com.example.demo.dto.MerchandiseDetailDTO;
import com.example.demo.service.MerchandiseService;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseController {
	@Autowired
    private MerchandiseService merchandiseService;

    // 一覧＋検索
    @GetMapping("/list")
    public String showList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer bigCategoryId,
            @RequestParam(required = false) Integer middleCategoryId,
            @RequestParam(required = false) Integer smallCategoryId,
            Model model) {

        List<MerchandiseDTO> list = merchandiseService.search(
                name, bigCategoryId, middleCategoryId, smallCategoryId);

        model.addAttribute("merchandiseList", list);

        // 検索条件保持
        model.addAttribute("name", name);
        model.addAttribute("bigCategoryId", bigCategoryId);
        model.addAttribute("middleCategoryId", middleCategoryId);
        model.addAttribute("smallCategoryId", smallCategoryId);

        return "merchandise/list";
    }

    // 詳細
    @GetMapping("/detail")
    public String showDetail(@RequestParam Integer id, Model model) {

        MerchandiseDetailDTO item = merchandiseService.findDetailById(id);

        if (item == null) {
            return "redirect:/merchandise/list";
        }

        model.addAttribute("item", item);

        return "merchandise/detail";
    }
}
