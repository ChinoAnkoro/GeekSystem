package main.java.com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.java.com.example.demo.entity.Admin;
import main.java.com.example.demo.dto.AdminDTO;
import main.java.com.example.demo.repository.AdminRepository;

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

	private Admin dtoToEntity(AdminDTO dto) {
		Admin admin = new Admin();
		admin.setLastName(dto.getLastName());
		admin.setFirstName(dto.getFirstName());
		admin.setEmail(dto.getEmail());
		return admin;
	}
}