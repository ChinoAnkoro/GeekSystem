package com.example.demo.service;

import com.example.demo.dto.AdminDTO;

public interface AdminService {
	void saveAdmin(AdminDTO dto);
	
	AdminDTO getProfile(String email);
	
	void updateProfile(String email, AdminDTO dto);
}