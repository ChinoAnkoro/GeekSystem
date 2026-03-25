package main.java.com.example.demo.service;

import main.java.com.example.demo.dto.AdminDTO;

public interface AdminService {
	void saveAdmin(AdminDTO dto);
	
	AdminDTO getProfile(String email);
}