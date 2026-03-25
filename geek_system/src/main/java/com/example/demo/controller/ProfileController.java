package main.java.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import main.java.com.example.demo.dto.AdminDTO;
import main.java.com.example.demo.service.AdminService;

@Controller
public class ProfileController {
	@Autowired
	private AdminService service;
	//表示画面
	public String profile(Authentication auth, Model model) {
		String email = auth.getName();
		
		AdminDTO dto = service.getProfile(email);
		model.addAttribute("profile",dto);
		return "admin/email";
	}
	
	//編集画面
	public String edit(Authentication auth, Model model) {
		String email = auth.getName();
		AdminDTO dto = service.getProfile(email);
		
		model.addAttribute("form",dto);
		
		return "admin/profile_edit";
	}
	
	public String update(@ModelAttribute AdminDTO dto,Authentication auth) {
		String email = auth.getName();
		return "redirect:/admin/profile";
	}
}
