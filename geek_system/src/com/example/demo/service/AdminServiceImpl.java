package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveAdmin(AdminDTO dto) {
		Admin admin = dtoToEntity(dto);
		admin.setPassword(passwordEncoder.encode(dto.getPassword()));
		adminRepository.save(admin);
	}

	@Override
	public AdminDTO getProfile(String email) {
		Admin admin = adminRepository.findByEmail(email).orElseThrow();
		return entityToDto(admin);
	}

	private Admin dtoToEntity(AdminDTO dto) {
		Admin admin = new Admin();
		admin.setLastName(dto.getLastName());
		admin.setFirstName(dto.getFirstName());
		admin.setEmail(dto.getEmail());
		admin.setPost(dto.getPost());
		admin.setAuthority(String.join(",", dto.getAuthority()));
		admin.setPhone_number(dto.getPhone_number());
		return admin;
	}

	private AdminDTO entityToDto(Admin admin) {
		AdminDTO dto = new AdminDTO();

		dto.setLastName(admin.getLastName());
		dto.setFirstName(admin.getFirstName());
		dto.setEmail(admin.getEmail());
		dto.setPost(admin.getPost());
		dto.setAuthority(List.of(admin.getAuthority().split(",")));
		dto.setPhone_number(admin.getPhone_number());
		return dto;
	}

	@Override
	public void updateProfile(
			String email,
			AdminDTO dto) {

		Admin admin = adminRepository
				.findByEmail(email)
				.orElseThrow();

		admin.setLastName(dto.getLastName());
		admin.setFirstName(dto.getFirstName());
		admin.setPost(dto.getPost());
		admin.setAuthority(String.join(",", dto.getAuthority()));
		admin.setPhone_number(dto.getPhone_number());

		adminRepository.save(admin);
	}
}