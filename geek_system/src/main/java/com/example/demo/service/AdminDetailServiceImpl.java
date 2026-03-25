package main.java.com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.example.demo.repository.AdminRepository;
import main.java.com.example.demo.entity.Admin;
import main.java.com.example.demo.security.AdminUserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AdminDetailServiceImpl implements UserDetailsService {
	@Autowired
	AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(email).orElseThrow(()
				-> new UsernameNotFoundException("Admin not found"));
				
				return AdminUserDetails.from(admin);
	}
}