package main.java.com.example.demo.dto;

import java.time.LocalDateTime;

import main.java.com.example.demo.entity.Admin;

import lombok.Data;

@Data
public class AdminDTO {
	public Long id;
	public String lastName;
	public String firstName;
	public String email;
	public String post;
	public String authority;
	public String phone_number;
	public String password;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
}