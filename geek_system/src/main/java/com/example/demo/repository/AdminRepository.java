package main.java.com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.example.demo.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	Optional<Admin> findByEmail(String email);
}