package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.AdminDTO;
import com.example.demo.service.AdminService;
import com.example.demo.constant.AdminConstant;

@Controller
public class ProfileController {
	@Autowired
	private AdminService service;
	// 表示画面
	public String profile(Authentication auth, Model model) {
		String email = auth.getName();
		
		AdminDTO dto = service.getProfile(email);
		model.addAttribute("profile",dto);
		return "admin/email";
	}
	
	// 編集画面
	public String edit(Authentication auth, Model model) {
		String email = auth.getName();
		AdminDTO dto = service.getProfile(email);
		
		model.addAttribute("form",dto);
		
		// 役職
		model.addAttribute("postList", AdminConstant.POST_LIST);

	    // 権限
		model.addAttribute("authorityList", AdminConstant.AUTHORITY_LIST);
		
		return "admin/profile_edit";
	}
	
	@PostMapping("/admin/profile/update")
	public String update(@Valid @ModelAttribute("form") AdminDTO dto,
BindingResult result,Authentication auth,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("postList", AdminConstant.POST_LIST);
			model.addAttribute("authorityList", AdminConstant.AUTHORITY_LIST);
			return "admin/progile_edit";
		}
		String email = auth.getName();
		service.updateProfile(email, dto);
		return "redirect:/admin/profile";
	}
}
